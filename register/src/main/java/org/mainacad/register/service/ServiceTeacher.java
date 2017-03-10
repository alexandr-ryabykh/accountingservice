package org.mainacad.register.service;

import org.mainacad.register.teacher.Teacher;

import java.util.List;

public interface ServiceTeacher {
    public List<Teacher> listTeacher();

    public void addTeacher(Teacher teacher);

    public void deleteTeacher(int id);

    public void editTeacher(Teacher teacher);

    public Teacher getTeacher(int id);

}
