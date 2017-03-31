package org.mainacad.db.register.service;


import lombok.Setter;

import org.mainacad.db.register.domain.Student;
import org.mainacad.db.register.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by genich on 27.03.17.
 */
@Service
public class ServiceStudentImpl implements ServiceStudent{

    @Autowired
    @Setter
    private StudentRepository studentRepository;

    @Override
    public Iterable<Student> listAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.delete(id);
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findOne(id);
    }
}
