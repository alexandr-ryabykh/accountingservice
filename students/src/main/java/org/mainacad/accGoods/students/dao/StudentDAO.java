package org.mainacad.accGoods.students.dao;

import org.mainacad.accGoods.students.model.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> listStudents();

    public Student addStudent(Student student);

    public void deleteStudent(long id);

    public Student getStudent(long id);

}
