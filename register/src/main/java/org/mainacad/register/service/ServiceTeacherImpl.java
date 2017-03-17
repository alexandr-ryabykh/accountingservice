package org.mainacad.register.service;

import org.mainacad.register.domain.Teacher;
import org.mainacad.register.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTeacherImpl implements ServiceTeacher {

    private TeacherRepository teacherRepository;

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public Iterable<Teacher> listAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }


    @Override
    public void deleteTeacher(int id) {
        teacherRepository.delete(id);
    }


    @Override
    public Teacher getTeacherById(int id) {
        return teacherRepository.findOne(id);
    }


}