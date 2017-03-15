package org.mainacad.students.service;

import org.mainacad.students.dao.StudentDAO;
import org.mainacad.students.model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> listStudents() {
        return studentDAO.listStudents();
    }

    @Override
    public Student addStudent(Student student) {
        studentDAO.addStudent(student);
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }

    @Override
    public Student getStudent(int id) {
        return studentDAO.getStudent(id);
    }
}
