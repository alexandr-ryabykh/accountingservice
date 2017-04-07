package org.mainacad.core.controller;

import lombok.Setter;
import org.mainacad.accstuffs.exporter.XlsExporter;
import org.mainacad.db.register.domain.Groups;
import org.mainacad.db.register.domain.Register;
import org.mainacad.db.register.service.ServiceGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RegisterController {

    @Autowired
    @Setter
    private ServiceGroups serviceGroups;

    @ModelAttribute("allGroups")
    public Iterable<Groups> getAllGroups(){
        return  this.serviceGroups.listAllGroups();
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerForm(Model model){
        model.addAttribute("register",new Register());
        return "register";
    }



    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public HttpEntity<byte[]> showExcel(@ModelAttribute Register register){
        byte[] documentBody = new XlsExporter().exportRegister(register);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "vnd.ms-excel"));

        header.set(HttpHeaders.ACCEPT_RANGES, "bytes");
        header.setContentLength(documentBody.length);

        return new HttpEntity<>(documentBody, header);
    }

}
