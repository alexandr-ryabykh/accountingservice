package org.mainacad.accstuffs.controller;


import org.mainacad.accstuffs.model.Stuff;
import org.mainacad.accstuffs.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Fujitsu on 06.03.2017.
 */

@Controller
public class StuffController {

    private StuffService stuffService;

    @Autowired(required = true)
    public void setStuffService(StuffService stuffService) {
        this.stuffService = stuffService;
    }

    @RequestMapping(value = "/stuffs")
    public String listStuffs(Model model) {
        model.addAttribute("stuffAttribute", stuffService.listStuff());
        return "stuffList";
    }

    @GetMapping("/stuffs/new")
    public String showForm(Stuff stuff) {
        return "stuffForm";
    }

    @PostMapping("/stuffs/new")
    public String checkPersonInfo(@Valid Stuff stuff, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "stuffForm";
        }

        stuffService.saveStuff(stuff);
        return "redirect:/stuffs";
    }
    @RequestMapping("stuffs/delete/{id}")
    public String removeId(@PathVariable Long id) {
        stuffService.deleteStuff(id);

        return "redirect:/stuffs";
    }


    @RequestMapping("stuffs/{id}")
    public String showStuff(@PathVariable Long id, Model model) {
        model.addAttribute("stuffs", stuffService.getStuff(id));
        return "stuffToShow";
    }

    @RequestMapping("stuffs/edit/{id}")
    public String editStuff(@PathVariable Long id, Model model) {
        model.addAttribute("stuffs", stuffService.getStuff(id));
        return "stuffForm";
    }
}


