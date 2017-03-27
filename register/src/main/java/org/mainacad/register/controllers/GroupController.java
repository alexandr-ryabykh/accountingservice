package org.mainacad.register.controllers;

import org.mainacad.register.domain.Grouppy;
import org.mainacad.register.domain.Teacher;
import org.mainacad.register.service.ServiceGroup;
import org.mainacad.register.service.ServiceTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by genich on 27.03.17.
 */
@Controller
public class GroupController {

    private ServiceGroup serviceGroup;

    private ServiceTeacher serviceTeacher;

    @Autowired
    public void setServiceGroup(ServiceGroup serviceGroup) {
        this.serviceGroup = serviceGroup;
    }

    @Autowired
    public void setServiceTeacher(ServiceTeacher serviceTeacher) {
        this.serviceTeacher = serviceTeacher;
    }

    @ModelAttribute("allTeachers")
    public Iterable<Teacher> existingTeachers(){
        return this.serviceTeacher.listAllTeachers();
    }

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("groups",serviceGroup.listAllGroups());
        return "groups";
    }

    @RequestMapping("group/{id}")
    public String showGroup(@PathVariable Long id, Model model){
        model.addAttribute("group",serviceGroup.getGroupById(id));
        return "groupshow";
    }

    @RequestMapping("group/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        model.addAttribute("group",serviceGroup.getGroupById(id));
        return "groupform";
    }

    @RequestMapping("group/new")
    public String newGroup(Model model){
        model.addAttribute("group",new Grouppy());
        return "groupform";
    }

    @RequestMapping(value = "group",method = RequestMethod.POST)
    public String saveGroup(Grouppy grouppy){
        serviceGroup.saveGroup(grouppy);
        return "redirect:/group/"+ grouppy.getId();
    }

    @RequestMapping("group/delete/{id}")
    public String delete(@PathVariable Long id){
        serviceGroup.deleteGroup(id);
        return "redirect/groups";
    }

}

