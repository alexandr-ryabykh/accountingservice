package org.mainacad.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mainacad.model.Stuff;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Fujitsu on 05.03.2017.
 */

@Repository
public class StuffDaoImpl implements StuffDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStuff(Stuff stuff) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(stuff);

    }

    @Override
    public void deleteStuff(int id) {

        Session session = this.sessionFactory.getCurrentSession();
        Stuff stuff = (Stuff) session.load(Stuff.class, new Integer(id));
        if (stuff != null) {
            session.delete(stuff);
        }

    }

    @Override
    public void updateStuff(Stuff stuff) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(stuff);
    }

    @Override
    public Stuff getStuff(int id) {

        Session session=this.sessionFactory.getCurrentSession();
        Stuff stuff=(Stuff)session.load(Stuff.class, new Integer(id));
        return stuff;

    }

    @Override
    public List<Stuff> listStuff() {
        Session session =this.sessionFactory.getCurrentSession();

//       DataBase and Querry needed
        List<Stuff> stuffList =session.createQuery("").list();
        return stuffList;
    }
}
