package org.mainacad.students.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mainacad.students.dao.StudentDAO;
import org.mainacad.students.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> listStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> studentList = session.createQuery("from Student ").list();
        session.close();
        return studentList;
    }

    @Override
    public Student addStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Student editStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(student);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    @Override
    public Student getStudent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }
}
