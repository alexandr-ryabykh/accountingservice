package org.mainacad.register.service;

import org.mainacad.register.domain.Groups;
import org.mainacad.register.domain.Teacher;

import java.util.Set;

public interface ServiceTeacher {
    Iterable<Teacher> listAllTeachers();

    Teacher saveTeacher(Teacher teacher);

    void deleteTeacher(long id);

    Teacher getTeacherById(long id);

    Set<Groups> getGroupsOfTeacher(long id);

}
