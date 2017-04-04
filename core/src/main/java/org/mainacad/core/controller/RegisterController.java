package org.mainacad.core.controller;

import lombok.Setter;
import org.mainacad.db.register.domain.Groups;
import org.mainacad.db.register.domain.Register;
import org.mainacad.db.register.service.ServiceGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RegisterController {

    @Autowired
    @Setter
    private ServiceGroups serviceGroups;

    @ModelAttribute("newRegister")
    public Register getNewRegister(){
        return new Register();
    }

    @ModelAttribute("allGroups")
    public Iterable<Groups> getAllGroups(){
        return  this.serviceGroups.listAllGroups();
    }

    @RequestMapping("/register")
    String register(){
        return "register";
    }

}
