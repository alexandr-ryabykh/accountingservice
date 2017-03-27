package org.mainacad.students.service;

import org.mainacad.students.repositories.StudentRepository;
import org.mainacad.students.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Iterable<Student> listStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.delete(id);
    }

    @Override
    public Student getStudent(long id) {
        return studentRepository.findOne(id);
    }
}
