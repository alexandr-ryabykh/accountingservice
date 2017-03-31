package org.mainacad.db.register.service;


import org.mainacad.db.register.domain.Student;

/**
 * Created by genich on 27.03.17.
 */
public interface ServiceStudent  {
    Iterable<Student> listAllStudent();

    Student saveStudent(Student student);

    void deleteStudent(long id);

    Student getStudentById(long id);
}
