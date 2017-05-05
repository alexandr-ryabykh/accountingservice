package org.mainacad.db.register.service;

import org.mainacad.db.register.domain.DayTime;
import org.mainacad.db.register.domain.Project;
import org.mainacad.db.register.domain.UserTM;

import java.util.List;

public interface DayTimeService {

    public Iterable<DayTime> listDayTimes();

    public DayTime addDayTime(DayTime dayTime);

    public void deleteDayTime(long dayTimeId);

    public DayTime getDayTime(long dayTimeId);

    List<DayTime> getAllDayTimes ();

    public Iterable<DayTime> listDayTimesForUserProject(Long userId, Long projectId);




}
