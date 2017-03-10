package org.mainacad.register.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

   


    @RequestMapping("/createRegister")
    public String welcome() {
        return "Hi from register";
    }
}
