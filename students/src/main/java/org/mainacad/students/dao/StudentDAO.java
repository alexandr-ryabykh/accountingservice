package org.mainacad.students.dao;

import org.mainacad.students.model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
}
