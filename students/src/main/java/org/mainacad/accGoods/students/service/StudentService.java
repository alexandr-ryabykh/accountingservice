package org.mainacad.accGoods.students.service;

import org.mainacad.accGoods.students.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> listStudents();

    public Student addStudent(Student student);

    public void deleteStudent(int id);

    public Student getStudent(int id);
}
