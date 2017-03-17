package org.mainacad.students.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mainacad.students.dao.StudentDAO;
import org.mainacad.students.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    @Override
    public List<Student> listStudents() {
        List<Student> studentList;
        try (Session session = this.sessionFactory.openSession()) {
            studentList = session.createCriteria(Student.class).list();
        }
        return studentList;
    }

    @Override
    public Student addStudent(Student student) {
        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(student);
            session.getTransaction().commit();
        }
        return student;
    }

    @Override
    public void deleteStudent(long id) {
        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
        }

    }

    @Override
    public Student getStudent(long id) {
        try (Session session = this.sessionFactory.openSession()) {
            return session.get(Student.class, id);
        }
    }
}
