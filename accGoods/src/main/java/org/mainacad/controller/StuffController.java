package org.mainacad.controller;


import org.mainacad.model.Stuff;
import org.mainacad.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Fujitsu on 06.03.2017.
 */

@Controller
public class StuffController {

    private StuffService stuffService;

    @Autowired(required = true)
    @Qualifier(value = "stuffService")

    public void setStuffService(StuffService stuffService) {
        this.stuffService = stuffService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listStuffs(Model model) {
        model.addAttribute("", new Stuff());
        model.addAttribute("", this.stuffService.listStuff());
        return "";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addStuff(@ModelAttribute("") Stuff stuff) {
        if(stuff.getId()==0){
            this.stuffService.addStuff(stuff);
        }
        else{
            this.stuffService.updateStuff(stuff);
        }

        return ("redirect:");

    }

    @RequestMapping("remove/id")
    public String removeId(@PathVariable("id")int id){
        this.stuffService.deleteStuff(id);

        return "redirect:/";
    }

    @RequestMapping("edit id")
    public String editStuff(@PathVariable("id") int id, Model model){
        model.addAttribute("", this.stuffService.getStuff(id));
        model.addAttribute("", this.stuffService.listStuff());

        return "";


    }



}
