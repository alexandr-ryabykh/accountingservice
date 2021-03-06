package org.mainacad.core.controller;

import lombok.Setter;
import org.mainacad.db.register.domain.Groups;
import org.mainacad.db.register.domain.Payments;
import org.mainacad.db.register.domain.Student;
import org.mainacad.db.register.service.PaymentService;
import org.mainacad.db.register.service.ServiceGroups;
import org.mainacad.db.register.service.ServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentsController {

    private ServiceStudent serviceStudent;

    @Autowired
    @Setter
    private ServiceGroups serviceGroups;

    @Autowired
    public StudentsController(ServiceStudent serviceStudent) {
        this.serviceStudent = serviceStudent;
    }

    @Autowired
    @Setter
    private PaymentService paymentService;


    @ModelAttribute("allGroups")
    public Iterable<Groups> getAllGroups() {
        return this.serviceGroups.listAllGroups();
    }

    @RequestMapping(value = "/register/students", method = RequestMethod.GET)
    public String listStudents(Model model) {
        model.addAttribute("studentsAttribute", this.serviceStudent.listAllStudent());
        return "studentlist";
    }

    @RequestMapping("/register/student/{id}")
    public String showStudent(@PathVariable long id, Model model) {
        model.addAttribute("student", this.serviceStudent.getStudentById(id));
        return "studentshow";
    }

    @RequestMapping("/register/student/edit/{id}")
    public String editStudent(@PathVariable long id, Model model) {
        model.addAttribute("student", this.serviceStudent.getStudentById(id));
        return "studentform";
    }

    @RequestMapping("/register/student/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "studentform";
    }

    @RequestMapping(value = "/register/student", method = RequestMethod.POST)
    public String addStudent(Student student) {
        this.serviceStudent.saveStudent(student);
        return "redirect:/register/students";
    }

    @RequestMapping("/register/student/delete/{id}")
    public String deleteStudent(@PathVariable long id) {
        this.serviceStudent.deleteStudent(id);
        return "redirect:/register/students";
    }

    @RequestMapping(value = "/register/student/{id}/payment", method = RequestMethod.GET)
    public String showPayment(@PathVariable long id, Model model) {
        model.addAttribute("payments", this.paymentService.getPaymentById(id));
        model.addAttribute("student", this.serviceStudent.getStudentById(id));
        model.addAttribute("payment", new Payments());
        return "paymentform";
    }

    @RequestMapping(value = "/register/student/{id}/payment", method = RequestMethod.POST)
    public String savePayment(@PathVariable long id, Payments payment) {
        Student student = serviceStudent.getStudentById(id);
        payment.setStudent(student);
        paymentService.addPayment(payment);
        return "redirect:/register/students";
    }

}
