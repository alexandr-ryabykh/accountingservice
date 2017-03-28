package org.mainacad.register.service;

import org.mainacad.register.domain.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by genich on 27.03.17.
 */
public interface ServiceStudent  {
    Iterable<Student> listAllStudent();

    Student saveStudent(Student student);

    void deleteStudent(long id);

    Student getStudentById(long id);
}
