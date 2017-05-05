package org.mainacad.core.controller;


import com.google.common.collect.Iterables;
import com.google.common.collect.Streams;
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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

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
        Iterable<DayTime> dayTimes = dayTimeService.listDayTimes();
        model.addAttribute("dayTimeAttribute", dayTimes);
        double hours = Streams.stream(dayTimes).map(DayTime::getHoursPerDay).mapToDouble(Double::doubleValue).sum();
        model.addAttribute("hours", hours);
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




    @RequestMapping(value = "/tmdayTimes/allDayTimesChoseProjectUser", method = RequestMethod.GET)
    public String getProjectUserForDT(Model model) {
        model.addAttribute("allUsers", userService.listUsers());
        model.addAttribute("allProjects", projectService.listProjects());
        model.addAttribute("user", 0);
        model.addAttribute("project", 0);



        return "dayTimeAllChoseProjectUser";
    }

    @RequestMapping(value = "/tmdayTimes/allDayTimesChoseProjectUser", method = RequestMethod.POST)
    public String getGetProjectUserForDT (String user, String project){
        return "redirect:/tmdayTimes/allDayTimesProjectUser/" + user +"/"+ project;
    }


    @RequestMapping("tmstartpage")
    public String showStartPage() {

        return "tmstartpage";
    }






    /*@RequestMapping(value="/tmdayTimes/allDayTimesProjectUserPassParam", method = RequestMethod.GET)
    public String deleteUser (@RequestParam Long user) {
        Long abs = user;
        return "redirect:/tmdayTimes/allDayTimesProjectUser";
    }*/



    @RequestMapping(value = "/tmdayTimes/allDayTimesProjectUser/{userId}/{projectId}", method = RequestMethod.GET)
    public String showDayTimeByUserProject(Model model,@PathVariable long userId,@PathVariable long projectId) {
        Iterable<DayTime> dayTimes = dayTimeService.listDayTimesForUserProject(userId,projectId);
        model.addAttribute("dayTimeAttribute", dayTimes);
        double hours = Streams.stream(dayTimes).map(DayTime::getHoursPerDay).mapToDouble(Double::doubleValue).sum();
        model.addAttribute("hours", hours);


        return "dayTimeList";
    }


}

