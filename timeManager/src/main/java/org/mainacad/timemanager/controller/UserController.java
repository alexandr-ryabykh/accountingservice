package org.mainacad.timemanager.controller;

import org.mainacad.timemanager.dao.impl.UserDaoImpl;
import org.mainacad.timemanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Autowired
    public UserController(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @RequestMapping(value = "/tmusers", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("userAttribute", this.userDaoImpl.listUsers());
        return "userList";
    }

    @RequestMapping("tmusers/new")
    public String addUser(Model model) {
        model.addAttribute("addNewUser", new User());
        return "userForm";
    }

    @RequestMapping(value = "userAddUser", method = RequestMethod.POST)
    public String newUser(User user) {
        this.userDaoImpl.addUser(user);
        return "redirect:/tmusers";
    }

    @RequestMapping("tmusers/delete/{userId}")
    public String deleteUser(@PathVariable long userId) {
        this.userDaoImpl.deleteUser(userId);
        return "redirect:/tmusers";
    }
}
