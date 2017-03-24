package org.mainacad.register.service;

import org.mainacad.register.domain.Teacher;
import org.mainacad.register.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
    public void saveTeacher(Teacher teacher) {
         teacherRepository.save(teacher);
    }


    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.delete(id);
    }


    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findOne(id);
    }


}
