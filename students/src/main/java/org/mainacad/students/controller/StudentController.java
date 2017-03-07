package org.mainacad.students.controller;

import com.google.common.collect.ImmutableList;
import org.mainacad.students.dao.impl.StudentDAOImpl;
import org.mainacad.students.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = ImmutableList.of(new Student(1, "Student", "Studentovich", "student@mail.com"));

    @RequestMapping("/welcome")
    public String welcome() {
        return "Hi all";
    }

    @RequestMapping("/students")

    public List<Student> findAll() {
        return students;
    }


    @RequestMapping(value = "/studentList", method = RequestMethod.GET)
    public String listStudents(Model model) {
        model.addAttribute("studentList", students);
        return "studentList";
    }
}

