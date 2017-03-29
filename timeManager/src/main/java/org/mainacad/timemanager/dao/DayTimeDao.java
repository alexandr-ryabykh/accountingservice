package org.mainacad.timemanager.dao;


import org.mainacad.timemanager.model.DayTime;

import java.util.List;

public interface DayTimeDao {

    public List<DayTime> listDayTimes();

    public DayTime addDayTime(DayTime dayTime);

    public void deleteDayTime(long dayTimeId);

    public DayTime getDayTime(long dayTimeId);
}
