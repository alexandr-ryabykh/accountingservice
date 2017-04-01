package org.mainacad.security.controller;

import org.mainacad.security.entity.User;
import org.mainacad.security.service.SecurityService;
import org.mainacad.security.service.UsersService;
import org.mainacad.security.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistration(Model model) {
        model.addAttribute("registrationForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String postRegistration(@ModelAttribute("registrationForm") @Valid User registrationForm,
                                   BindingResult bindingResult,
                                   Model model) {
        userValidator.validate(registrationForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        usersService.save(registrationForm);
        securityService.autologin(registrationForm.getUsername(), registrationForm.getPasswordConfirm());
        model.addAttribute(registrationForm.getUsername(), "name");
        return "redirect:/";
    }

}