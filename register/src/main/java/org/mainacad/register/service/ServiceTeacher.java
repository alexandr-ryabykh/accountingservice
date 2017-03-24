package org.mainacad.register.service;

import org.mainacad.register.domain.Teacher;

public interface ServiceTeacher {
    Iterable<Teacher> listAllTeachers();

    void saveTeacher(Teacher teacher);

    void deleteTeacher(Long id);

    Teacher getTeacherById(Long id);

}
