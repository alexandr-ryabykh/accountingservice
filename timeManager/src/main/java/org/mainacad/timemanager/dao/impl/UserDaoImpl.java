package org.mainacad.timemanager.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mainacad.timemanager.dao.UserDao;
import org.mainacad.timemanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> listUsers() {
        List<User> userList;
        try (Session session = this.sessionFactory.openSession()) {
            userList = session.createCriteria(User.class).list();
        }
        return userList;
    }

    @Override
    public User addUser(User user) {

        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(user);
            session.getTransaction().commit();

        }

        return user;
    }

    @Override
    public void deleteUser(long userId) {


        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, userId);
            session.delete(user);
            session.getTransaction().commit();
        }

    }

    @Override
    public User getUser(long userId) {
        return null;
    }
}

