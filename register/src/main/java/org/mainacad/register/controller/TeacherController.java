package org.mainacad.register.controller;

import org.mainacad.register.teacher.Teacher;
import org.mainacad.register.teacherDao.TeacherDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class TeacherController {

    private TeacherDaoImpl teacherDaoimpl;

    @Autowired
    public TeacherController(TeacherDaoImpl teacherDaoimpl) {
        this.teacherDaoimpl = teacherDaoimpl;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/teacher/all", method = RequestMethod.GET)
    public String listTeacher(Model model) {
        List<Teacher> teachersList=teacherDaoimpl.listTeacher();
        model.addAttribute("teacherList", teachersList);
        return "teacherList";
    }

    @RequestMapping(value = "/teacher/add", method = RequestMethod.GET)
    public String getStudent(Model model) {
        model.addAttribute("teacherAttribute", new Teacher());

        return "addTeacher";
    }

    @RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    public String saveTeacher(@ModelAttribute("teacherAttribute") Teacher teacher) {
        this.teacherDaoimpl.addTeacher(teacher);
        return "redirect:/teacher/all";
    }

    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET)
    public ModelAndView getEditTeacher(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("editStudent");
        Teacher teacher = this.teacherDaoimpl.getTeacher(id);
        modelAndView.addObject("teacher", teacher);
        return modelAndView;
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.POST)
    public String saveEditContact(Teacher teacher) {
        this.teacherDaoimpl.editTeacher(teacher);
        return "redirect:/student/all";
    }

    @RequestMapping(value = "/student/{id}/remove", method = RequestMethod.GET)
    public String removeContact(@PathVariable int id) {
        this.teacherDaoimpl.deleteTeacher(id);
        return "redirect:/student/all";
    }


}
