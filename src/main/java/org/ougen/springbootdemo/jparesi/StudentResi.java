package org.ougen.springbootdemo.jparesi;

import org.ougen.springbootdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: OuGen
 * Discription:
 * Date: 9:52 2019/7/17
 */
public interface StudentResi extends JpaRepository<Student,Integer> {
    @Override
    Student getOne(Integer integer);

    @Override
    List<Student> findAll();

    Student findByName(String name);

    @Override
    public Student save(Student student);

    List<Student> findByCity(String city);

}
