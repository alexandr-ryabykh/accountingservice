package org.mainacad.timemanager.controller;

import lombok.Setter;
import org.mainacad.db.register.domain.DayTime;
import org.mainacad.db.register.service.DayTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DayTimeController {

    @Autowired
    @Setter
    private DayTimeService dayTimeService;


    @RequestMapping(value = "/tmdayTimes", method = RequestMethod.GET)
    public String listDayTimes(Model model) {
        model.addAttribute("dayTimeAttribute", this.dayTimeService.listDayTimes());
        return "dayTimeList";
    }

    @RequestMapping("tmdayTimes/new")
    public String addDayTime(Model model) {
        model.addAttribute("addNewDayTime", new DayTime());
        return "dayTimeForm";
    }

    @RequestMapping(value = "dayTimeAddDayTime", method = RequestMethod.POST)
    public String newDayTime(DayTime dayTime) {
        this.dayTimeService.addDayTime(dayTime);
        return "redirect:/tmdayTimes";
    }

    @RequestMapping("tmdayTimes/delete/{dayTimeId}")
    public String deleteDayTime(@PathVariable long dayTimeId) {
        this.dayTimeService.deleteDayTime(dayTimeId);
        return "redirect:/tmdayTimes";
    }
}

