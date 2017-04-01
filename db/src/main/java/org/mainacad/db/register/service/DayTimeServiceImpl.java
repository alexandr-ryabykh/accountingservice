package org.mainacad.db.register.service;

import lombok.Setter;
import org.mainacad.db.register.domain.DayTime;
import org.mainacad.db.register.repositories.DayTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayTimeServiceImpl implements DayTimeService {

    @Autowired
    @Setter
    private DayTimeRepository dayTimeRepository;


    @Override
    public Iterable<DayTime> listDayTimes() {
        return dayTimeRepository.findAll();
    }

    @Override
    public DayTime addDayTime(DayTime dayTime) {
        return dayTimeRepository.save(dayTime);
    }

    @Override
    public void deleteDayTime(long dayTimeId) {
        dayTimeRepository.delete(dayTimeId);
    }

    @Override
    public DayTime getDayTime(long dayTimeId) {
        return dayTimeRepository.findOne(dayTimeId);
    }
}

