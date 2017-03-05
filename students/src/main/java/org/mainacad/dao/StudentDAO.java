package org.mainacad.dao;

import org.mainacad.model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
}
