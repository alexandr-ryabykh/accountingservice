package org.mainacad.timemanager.controller;

import org.mainacad.timemanager.dao.impl.DayTimeDaoImpl;
import org.mainacad.timemanager.model.DayTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DayTimeController {

    
    

        @Autowired
        private DayTimeDaoImpl dayTimeDaoImpl;

        @Autowired
        public DayTimeController(DayTimeDaoImpl dayTimeDaoImpl) {
            this.dayTimeDaoImpl = dayTimeDaoImpl;
        }

        @RequestMapping(value = "/tmdayTimes", method = RequestMethod.GET)
        public String listDayTimes(Model model) {
            model.addAttribute("dayTimeAttribute", this.dayTimeDaoImpl.listDayTimes());
            return "dayTimeList";
        }

        @RequestMapping("tmdayTimes/new")
        public String addDayTime(Model model) {
            model.addAttribute("addNewDayTime", new DayTime());
            return "dayTimeForm";
        }

        @RequestMapping(value = "dayTimeAddDayTime", method = RequestMethod.POST)
        public String newDayTime(DayTime dayTime) {
            this.dayTimeDaoImpl.addDayTime(dayTime);
            return "redirect:/tmdayTimes";
        }

        @RequestMapping("tmdayTimes/delete/{dayTimeId}")
        public String deleteDayTime(@PathVariable long dayTimeId) {
            this.dayTimeDaoImpl.deleteDayTime(dayTimeId);
            return "redirect:/tmdayTimes";
        }
    }

