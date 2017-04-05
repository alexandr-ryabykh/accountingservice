package org.mainacad.core.controller;


import lombok.Setter;
import org.mainacad.db.register.domain.DayTime;
import org.mainacad.db.register.domain.Project;
import org.mainacad.db.register.domain.Teacher;
import org.mainacad.db.register.domain.UserTM;
import org.mainacad.db.register.service.DayTimeService;
import org.mainacad.db.register.service.ProjectService;
import org.mainacad.db.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DayTimeController {


    @Autowired
    @Setter
    private DayTimeService dayTimeService;
    @Autowired
    @Setter
    private ProjectService projectService;

    @Autowired
    @Setter
    private UserService userService;


    @ModelAttribute("allProjects")
    public Iterable<Project> existingProjects() {
        return this.projectService.listProjects();
    }

    @ModelAttribute("allUsers")
    public Iterable<UserTM> existingUsers() {
        return this.userService.listUsers();
    }


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

