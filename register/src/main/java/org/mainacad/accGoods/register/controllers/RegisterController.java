package org.mainacad.accGoods.register.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RegisterController {
    @RequestMapping("/register")
    String register(){
        return "register";
    }
}
