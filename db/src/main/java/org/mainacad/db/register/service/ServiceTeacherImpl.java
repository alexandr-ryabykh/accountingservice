package org.mainacad.db.register.service;

import org.mainacad.db.register.domain.Groups;
import org.mainacad.db.register.domain.Teacher;
import org.mainacad.db.register.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

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
    public void deleteTeacher(long id) {
        teacherRepository.delete(id);
    }

    @Override
    public Teacher getTeacherById(long id) {
        return teacherRepository.findOne(id);
    }

    @Override
    public Set<Groups> getGroupsOfTeacher(long id) {
        return teacherRepository.findOne(id).getGroups();
    }

}
