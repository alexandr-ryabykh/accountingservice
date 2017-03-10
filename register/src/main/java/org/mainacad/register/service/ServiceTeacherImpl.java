package org.mainacad.register.service;

import org.mainacad.register.teacher.Teacher;
import org.mainacad.register.teacherDao.TeacherDao;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTeacherImpl implements ServiceTeacher {

    private TeacherDao teacherDao;

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public List<Teacher> listTeacher() {
        return teacherDao.listTeacher();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);

    }

    @Override
    public void deleteTeacher(int id) {
        teacherDao.deleteTeacher(id);

    }

    @Override
    public void editTeacher(Teacher teacher) {
        teacherDao.editTeacher(teacher);

    }

    @Override
    public Teacher getTeacher(int id) {
        return teacherDao.getTeacher(id);
    }
}
