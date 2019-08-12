package org.ougen.springbootdemo.jpaservice;

import org.ougen.springbootdemo.jparesi.StudentResi;
import org.ougen.springbootdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: OuGen
 * Discription:
 * Date: 11:53 2019/7/17
 */
@Service
public class Service2 {
    @Autowired
    private StudentResi studentResi;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save1(){
        studentResi.save(new Student("lk",12,3,"sahgnhai"));
        studentResi.save(new Student("mnc",33,3,"shandong"));
        studentResi.save(new Student("sdf",12,3,"qinghai"));

    }
}
