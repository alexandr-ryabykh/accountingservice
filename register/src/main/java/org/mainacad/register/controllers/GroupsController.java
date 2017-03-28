package org.mainacad.register.controllers;

import org.mainacad.register.domain.Groups;
import org.mainacad.register.domain.Teacher;
import org.mainacad.register.service.ServiceGroups;
import org.mainacad.register.service.ServiceTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by genich on 22.03.17.
 */
@Controller
public class GroupsController {

    private ServiceGroups serviceGroups;

    private ServiceTeacher serviceTeacher;

    @Autowired
    public void setServiceGroup(ServiceGroups serviceGroups) {
        this.serviceGroups = serviceGroups;
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
        model.addAttribute("groups",serviceGroups.listAllGroups());
        return "groups";
    }

    @RequestMapping("group/{id}")
    public String showGroup(@PathVariable Long id,Model model){
        model.addAttribute("group",serviceGroups.getGroupsById(id));
        return "groupshow";
    }

    @RequestMapping("group/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        model.addAttribute("group",serviceGroups.getGroupsById(id));
        return "groupform";
    }

    @RequestMapping("group/new")
    public String newGroup(Model model){
        model.addAttribute("group",new Groups());
        return "groupform";
    }

    @RequestMapping(value = "group",method = RequestMethod.POST)
    public String saveGroup(Groups groups){
        serviceGroups.saveGroups(groups);
        return "redirect:/group/"+ groups.getId();
    }

    @RequestMapping("group/delete/{id}")
    public String delete(@PathVariable Long id){
        serviceGroups.deleteGroups(id);
        return "redirect/groups";
    }

}