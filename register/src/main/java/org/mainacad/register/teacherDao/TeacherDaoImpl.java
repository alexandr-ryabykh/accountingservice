package org.mainacad.register.teacherDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mainacad.register.teacher.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository     // @Component
public class TeacherDaoImpl implements TeacherDao {

    private SessionFactory sessionFactory;


    @Override
    public List<Teacher> listTeacher() {
        Session session = this.sessionFactory.getCurrentSession();

//       DataBase and Querry needed
        List<Teacher> teacherList = session.createQuery("").list();
        session.close();
        return teacherList;

    }

    @Override
    public void addTeacher(Teacher teacher) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(teacher);
        session.close();
    }

    @Override
    public void deleteTeacher(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Teacher teacher = (Teacher) session.load(Teacher.class, new Integer(id));
        if (teacher != null) {
            session.delete(teacher);
        }
        session.close();

    }

    @Override
    public void editTeacher(Teacher teacher) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(teacher);
        session.close();
    }

    @Override
    public Teacher getTeacher(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Teacher teacher = (Teacher) session.load(Teacher.class, new Integer(id));
        session.close();
        return teacher;

    }
}
