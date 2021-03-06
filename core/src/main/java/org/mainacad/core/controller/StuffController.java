package org.mainacad.core.controller;

import org.mainacad.accstuffs.exporter.XlsExporter;

import org.mainacad.db.register.domain.Stuff;
import org.mainacad.db.register.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class StuffController {

    private StuffService stuffService;

    @Autowired(required = true)
    public void setStuffService(StuffService stuffService) {
        this.stuffService = stuffService;

        stuffService.listStuff();
    }

    @RequestMapping(value = "/stuffs")
    public String listStuffs(Model model) {
        model.addAttribute("stuffAttribute", stuffService.listStuff());
        return "stuffList";
    }

    @RequestMapping(value = "/stuffs/new", method = RequestMethod.GET)
    public String showForm(Stuff stuff) {
        return "stuffForm";
    }

    @RequestMapping(value = "/stuffs/new", method = RequestMethod.POST)
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
        model.addAttribute("stuff", stuffService.getStuff(id));
        return "stuffToShow";
    }

    @RequestMapping("stuffs/edit/{id}")
    public String editStuff(@PathVariable long id, Model model) {
        model.addAttribute("stuff", stuffService.getStuff(id));
        return "stuffForm";
    }

    @RequestMapping("stuffs/excel.xls")
    public HttpEntity<byte[]> showExcel() {

        byte[] documentBody = new XlsExporter().exportListOfStuffs(stuffService.listStuff());

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "vnd.ms-excel"));

        header.set(HttpHeaders.ACCEPT_RANGES, "bytes");
        header.setContentLength(documentBody.length);

        return new HttpEntity<>(documentBody, header);

    }
}


