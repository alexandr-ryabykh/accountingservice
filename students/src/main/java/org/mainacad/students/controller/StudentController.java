package org.mainacad.students.controller;

import org.mainacad.students.dao.impl.StudentDAOImpl;
import org.mainacad.students.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    private StudentDAOImpl studentDAOimpl;

    @Autowired
    public StudentController(StudentDAOImpl studentDAOimpl) {
        this.studentDAOimpl = studentDAOimpl;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/students/all", method = RequestMethod.GET)
    public String listStudents(Model model) {
        List<Student> studentList = studentDAOimpl.listStudents();
        model.addAttribute("studentListAttribute", studentList);
        return "studentList";
    }

    @RequestMapping(value = "/student/add", method = RequestMethod.GET)
    public String getStudent(Model model) {
        model.addAttribute("studentAttribute", new Student());
        return "addStudent";
    }

    @RequestMapping(value = "/student/add", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("studentAttribute") Student student) {
        this.studentDAOimpl.addStudent(student);
        return "redirect:/student/all";
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ModelAndView getEditStudent(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("editStudent");
        Student student = this.studentDAOimpl.getStudent(id);
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.POST)
    public String saveEditContact(Student student) {
        this.studentDAOimpl.editStudent(student);
        return "redirect:/student/all";
    }

    @RequestMapping(value = "/student/{id}/remove", method = RequestMethod.GET)
    public String removeContact(@PathVariable int id) {
        this.studentDAOimpl.deleteStudent(id);
        return "redirect:/student/all";
    }

}

