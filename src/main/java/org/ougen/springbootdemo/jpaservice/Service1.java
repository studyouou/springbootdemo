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
@Service("service1")
public class Service1 {
    @Autowired
    private StudentResi studentResi;
    @Autowired
    private Service2 service2;
    @Autowired
    private Service1 service1;
    @Transactional(propagation = Propagation.REQUIRED,noRollbackFor = ArithmeticException.class)
    public void save1(){
        studentResi.save(new Student("oahu",3,3,"chengdu"));
//        service2.save1();
//        int i=1/0;
        service1.save2();
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save2(){
        studentResi.save(new Student("lk",12,3,"sahgnhai"));
        studentResi.save(new Student("mnc",33,3,"shandong"));
        studentResi.save(new Student("sdf",12,3,"qinghai"));
        int i=1/0;
    }
    public Student findByName(String name){
//        boolean b = true;
//        if (b){
//            throw new RuntimeException();
//        }
        return studentResi.findByName(name);
    }
    public Student getStudentById(int studentId){
        return studentResi.getOne(studentId);
    }
}
