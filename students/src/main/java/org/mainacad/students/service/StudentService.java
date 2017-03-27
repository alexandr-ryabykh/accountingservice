package org.mainacad.students.service;

import org.mainacad.students.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    public Iterable<Student> listStudents();

    public Student addStudent(Student student);

    public void deleteStudent(long id);

    public Student getStudent(long id);
}
