package org.mainacad.db.register.service;

import lombok.Setter;
import org.mainacad.db.register.domain.DayTime;
import org.mainacad.db.register.domain.UserTM;
import org.mainacad.db.register.repositories.DayTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<DayTime> getAllDayTimes() {
        Iterable<DayTime> dayTimesIterable = dayTimeRepository.findAll();
        List<DayTime> dayTimesList = new ArrayList<>();
        for (DayTime iter : dayTimesIterable) {
            dayTimesList.add(iter);
        }


        return dayTimesList;
    }

    @Override
    public Iterable<DayTime> listDayTimesForUserProject(Long userId, Long projectId) {
        Iterable<DayTime> iteratorDayTimesForUserProject = dayTimeRepository.findAll();
        List<DayTime> dayTime = new ArrayList<>();

        for (DayTime itr : iteratorDayTimesForUserProject) {
            if ((itr.getUsers().getUserId() == userId) && (itr.getProjects().getProjectId() == projectId))
            dayTime.add(itr);
        }

        iteratorDayTimesForUserProject = (Iterable<DayTime>)dayTime;

        return iteratorDayTimesForUserProject;
    }


}

