package org.mainacad.controller;

import org.mainacad.dao.impl.StudentDAOImpl;
import org.mainacad.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

  private   StudentDAOImpl studentDAOimpl;
    @Autowired
    public StudentController(StudentDAOImpl studentDAOimpl) {
        this.studentDAOimpl = studentDAOimpl;
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "Hi all";
    }

    @RequestMapping("/students")

    public List<Student> findAll() {
        return studentDAOimpl.findAll();
    }


    @RequestMapping(value = "/studentList", method = RequestMethod.GET)
    public String listStudents(Model model) {
        List<Student> studentList = this.studentDAOimpl.findAll();
        model.addAttribute("studentList", studentList);
        return "studentList";
    }
}

