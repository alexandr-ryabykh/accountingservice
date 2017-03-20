package org.mainacad.timemanager.controller;

import org.mainacad.timemanager.dao.impl.MyUserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyUserController {

    private MyUserDaoImpl myUserDaoImpl;

    @Autowired
    public MyUserController(MyUserDaoImpl myUserDaoImpl) {
        this.myUserDaoImpl = myUserDaoImpl;
    }

    @RequestMapping(value = "/tmusers", method = RequestMethod.GET)
    public String listMyUsers(Model model) {
        model.addAttribute("myuserAttribute", this.myUserDaoImpl.listMyUsers());
        return "usersList";
    }
}
