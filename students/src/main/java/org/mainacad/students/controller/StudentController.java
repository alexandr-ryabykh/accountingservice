package org.mainacad.students.controller;

import org.mainacad.students.dao.impl.StudentDAOImpl;
import org.mainacad.students.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

    private StudentDAOImpl studentDAOimpl;

    @Autowired
    public StudentController(StudentDAOImpl studentDAOimpl) {
        this.studentDAOimpl = studentDAOimpl;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String listStudents(Model model) {
        model.addAttribute("studentAttribute", this.studentDAOimpl.listStudents());
        return "studentList";
    }

    @RequestMapping("student/{id}")
    public String showStudent(@PathVariable long id, Model model) {
        model.addAttribute("student", this.studentDAOimpl.getStudent(id));
        return "studentShow";
    }

    @RequestMapping("student/edit/{id}")
    public String editStudent(@PathVariable long id, Model model) {
        model.addAttribute("student", this.studentDAOimpl.getStudent(id));
        return "studentForm";
    }

    @RequestMapping("student/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @RequestMapping(value = "student", method = RequestMethod.POST)
    public String addStudent(Student student) {
        this.studentDAOimpl.addStudent(student);
        return "redirect:/students";
    }

    @RequestMapping("student/delete/{id}")
    public String deleteStudent(@PathVariable long id) {
        this.studentDAOimpl.deleteStudent(id);
        return "redirect:/students";
    }
}

