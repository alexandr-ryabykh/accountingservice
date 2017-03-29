package org.mainacad.timemanager.service;

import org.mainacad.timemanager.dao.DayTimeDao;
import org.mainacad.timemanager.model.DayTime;

import java.util.List;


public class DayTimeServiceImpl implements DayTimeService {

    
        private DayTimeDao dayTimeDao;

        public void setStudentDAO(DayTimeDao dayTimeDao) {
            this.dayTimeDao = dayTimeDao;
        }

        @Override
        public List<DayTime> listDayTimes() {
            return dayTimeDao.listDayTimes();
        }

        @Override
        public DayTime addDayTime(DayTime dayTime) {
            return dayTimeDao.addDayTime(dayTime);
        }

        @Override
        public void deleteDayTime(long dayTimeId) {
            dayTimeDao.deleteDayTime(dayTimeId);
        }

        @Override
        public DayTime getDayTime(long dayTimeId) {
            return null;
        }
    }

