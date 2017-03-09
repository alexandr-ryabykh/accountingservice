package org.mainacad.students.service;

import org.mainacad.students.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> listStudents();

    public Student addStudent(Student student);

    public void deleteStudent(int id);

    public Student editStudent(Student student);

    public Student getStudent(int id);
}
