package org.mainacad.accGoods.register.service;

import org.mainacad.accGoods.register.domain.Teacher;

public interface ServiceTeacher {
    Iterable<Teacher> listAllTeachers();

    Teacher saveTeacher(Teacher teacher);

    void deleteTeacher(int id);

    Teacher getTeacherById(int id);

}
