package org.mainacad.dao.impl;

import org.mainacad.dao.StudentDAO;
import org.mainacad.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
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
