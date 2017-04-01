package org.mainacad.timemanager.controller;

import lombok.Setter;
import org.mainacad.db.register.domain.UserTM;
import org.mainacad.db.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    @Setter
    private UserService userService;

    @RequestMapping(value = "/tmusers", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("userAttribute", this.userService.listUsers());
        return "userList";
    }

    @RequestMapping("tmusers/new")
    public String addUser(Model model) {
        model.addAttribute("addNewUser", new UserTM());
        return "userForm";
    }

    @RequestMapping(value = "userAddUser", method = RequestMethod.POST)
    public String newUser(UserTM userTM) {
        this.userService.addUser(userTM);
        return "redirect:/tmusers";
    }

    @RequestMapping("tmusers/delete/{userId}")
    public String deleteUser(@PathVariable long userId) {
        this.userService.deleteUser(userId);
        return "redirect:/tmusers";
    }
}
