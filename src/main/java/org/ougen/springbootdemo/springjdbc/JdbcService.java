package org.ougen.springbootdemo.springjdbc;

import org.ougen.springbootdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 * Author: OuGen
 * Discription:
 * Date: 13:19 2019/7/18
 */
@Service
public class JdbcService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Student getStudent(){
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        Student student = jdbcTemplate.queryForObject("select * from student where student_id=?",rowMapper,7);
        return student;
    }
}
