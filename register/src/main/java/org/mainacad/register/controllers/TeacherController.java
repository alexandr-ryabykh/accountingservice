package org.mainacad.register.controllers;

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

@Controller
public class TeacherController {

    private ServiceTeacher serviceTeacher;

    private ServiceGroup serviceGroup;




    @Autowired
    public void setServiceGroup(ServiceGroup serviceGroup) {
        this.serviceGroup = serviceGroup;
    }

    @Autowired
    public void setServiceTeacher(ServiceTeacher serviceTeacher) {
        this.serviceTeacher = serviceTeacher;
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("teachers", serviceTeacher.listAllTeachers());
        return "teachers";
    }

    @RequestMapping("teacher/{id}")
    public String showTeacher(@PathVariable Long id, Model model) {
        model.addAttribute("teacher", serviceTeacher.getTeacherById(id));
        return "teachershow";
    }

    @RequestMapping("teacher/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("teacher", serviceTeacher.getTeacherById(id));
        return "teacherform";
    }
    @RequestMapping("teacher/new")
    public String newTeacher(Model model){
        model.addAttribute("teacher", new Teacher());
        return "teacherform";
    }

    @RequestMapping(value = "teacher", method = RequestMethod.POST)
    public String saveTeacher(Teacher teacher){
        serviceTeacher.saveTeacher(teacher);
        return "redirect:/teacher/" + teacher.getId();
    }

    @RequestMapping("teacher/delete/{id}")
    public String delete(@PathVariable Long id){
        serviceTeacher.deleteTeacher(id);
        return "redirect:/teachers";
    }
}
