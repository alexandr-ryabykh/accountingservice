package org.mainacad.students.dao.impl;

import org.mainacad.students.dao.StudentDAO;
import org.mainacad.students.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    JdbcTemplate jdbcTemplate;


    private RowMapper<Student> studentRowMapper = (rs, rowNum) -> new Student(
            rs.getLong("student_id"),
            rs.getString("name"),
            rs.getString("surname"),
            rs.getString("email")
    );

    @Override
    public List<Student> findAll() {
        List<Student> students = jdbcTemplate.query("select * from students", studentRowMapper);
        return students;
    }
}
