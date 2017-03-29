package org.mainacad.timemanager.service;

import org.mainacad.timemanager.model.DayTime;

import java.util.List;


public interface DayTimeService {


        public List<DayTime> listDayTimes();

        public DayTime addDayTime(DayTime dayTime);

        public void deleteDayTime(long dayTimeId);

        public DayTime getDayTime(long dayTimeId);

}
