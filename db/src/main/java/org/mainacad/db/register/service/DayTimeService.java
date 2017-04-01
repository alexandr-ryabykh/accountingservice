package org.mainacad.db.register.service;

import org.mainacad.db.register.domain.DayTime;

public interface DayTimeService {

    public Iterable<DayTime> listDayTimes();

    public DayTime addDayTime(DayTime dayTime);

    public void deleteDayTime(long dayTimeId);

    public DayTime getDayTime(long dayTimeId);

}
