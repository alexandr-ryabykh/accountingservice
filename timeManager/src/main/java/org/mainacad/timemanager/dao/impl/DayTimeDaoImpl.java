package org.mainacad.timemanager.dao.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mainacad.timemanager.dao.DayTimeDao;
import org.mainacad.timemanager.model.DayTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class DayTimeDaoImpl implements DayTimeDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<DayTime> listDayTimes() {
        List<DayTime> dayTimeList;
        try (Session session = this.sessionFactory.openSession()) {
            dayTimeList = session.createCriteria(DayTime.class).list();
        }
        return dayTimeList;
    }

    @Override
    public DayTime addDayTime(DayTime dayTime) {

        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(dayTime);
            session.getTransaction().commit();

        }

        return dayTime;
    }

    @Override
    public void deleteDayTime(long dayTimeId) {


        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();
            DayTime dayTime = session.get(DayTime.class, dayTimeId);
            session.delete(dayTime);
            session.getTransaction().commit();
        }

    }

    @Override
    public DayTime getDayTime(long dayTimeId) {
        return null;
    }
}

