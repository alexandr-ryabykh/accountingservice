package org.mainacad.timemanager.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mainacad.timemanager.dao.MyUserDao;
import org.mainacad.timemanager.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MyUserDaoImpl implements MyUserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List listMyUsers() {
        List myUserList;
        try (Session session = this.sessionFactory.openSession()) {
            myUserList = session.createCriteria(MyUser.class).list();
        }
        return myUserList;
    }
}
