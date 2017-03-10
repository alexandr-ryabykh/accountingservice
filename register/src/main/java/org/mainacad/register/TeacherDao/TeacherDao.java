package org.mainacad.register.TeacherDao;

import org.mainacad.register.Teacher.Teacher;

import java.util.List;

public interface TeacherDao {
    public List<Teacher> listTeacher();

    public void addTeacher(Teacher teacher);

    public void deleteTeacher(int id);

    public void editTeacher(Teacher teacher);

    public Teacher getTeacher(int id);

}
