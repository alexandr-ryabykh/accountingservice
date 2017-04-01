package org.mainacad.db.register.service;


import org.mainacad.db.register.domain.Student;

public interface ServiceStudent {
    Iterable<Student> listAllStudent();

    Student saveStudent(Student student);

    void deleteStudent(long id);

    Student getStudentById(long id);
}
