package org.ougen.springbootdemo.controller;

import org.ougen.springbootdemo.components.User;
import org.ougen.springbootdemo.jparesi.StudentResi;
import org.ougen.springbootdemo.jpaservice.AysnService;
import org.ougen.springbootdemo.jpaservice.Service1;
import org.ougen.springbootdemo.model.Model;
import org.ougen.springbootdemo.model.Student;
import org.ougen.springbootdemo.redis.MyRedisTemplet;
import org.ougen.springbootdemo.util.ModelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Author: OuGen
 * Discription:
 * Date: 10:52 2019/7/16
 */
@RestController
@EnableAsync
public class CommonController {
    private static Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private AysnService aysnService;
    private int anInt=0;
    @Autowired
    private Service1 service1;
    @Autowired
    private User user;
    @Autowired
    private MyRedisTemplet myRedisTemplet;
    @Value("ower.username")
    private String username;
    @Value("${test.name}")
    private String names;
    /**
     * @Author: OuGen
     * @Discription:
     * @param method
     * @Data :11:08 2019/7/16
     */
    @RequestMapping(value = "/demo",params = "method=demoParams")
    public Model demoParams(@RequestParam("method") String method){
        anInt++;
        return ModelUtil.getModel("demoParams",1,"this is "+username+method+anInt);
    }
    @RequestMapping(value = "/demo")
    public Model demoNoParams(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        boolean b =false;
        for (Cookie cookie:cookies){
            if ("phone".equals(cookie.getName())){
                b=true;
            }
        }
        if (!b){
            Cookie cookie = new Cookie("phone","13981973370");
            cookie.setPath("/");
            cookie.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(cookie);
        }
        return ModelUtil.getModel("demo",1,user);
    }

    @RequestMapping("/jpaDemo/{studentId}")
    public Model jpaDemo(@RequestHeader("header")Map header, @CookieValue(value = "phone",
            required = false)String phone,@PathVariable("studentId")int studentId){
        if (!"".equals(phone)&&phone!=null){
            System.out.println(phone);
        }else {
            System.out.println("phone is null,pleas visit demo to add cookie");
        }
        System.out.println(names);
        Student student = null;
        System.out.println(header);
        if ((student= (Student) myRedisTemplet.getHash("studenthash","student:"+studentId))==null){
            try {
                student = service1.getStudentById(studentId);
                if (student.getStudentId()!=studentId){
                    return ModelUtil.getModel("jpa练习",1,"没有这个id");
                }
            }catch (Exception e){
                return ModelUtil.getModel("jpa练习",1,"没有这个id");
            }
            logger.info("没有redis缓存取数据");
            myRedisTemplet.putHash("studenthash","student:"+String.valueOf(student.getStudentId()),student);
        }
        return ModelUtil.getModel("jpa练习",1,student);

    }
    @RequestMapping("/student")
    public Model<Student> getStudent(@Validated Student student, BindingResult b){
        if (b.hasErrors()){
            List<FieldError> fieldErrors = b.getFieldErrors();
            for (FieldError error:fieldErrors){
                System.out.println(error.getField()+error.getDefaultMessage());
            }
            return ModelUtil.getModel("OK",1,"ERROE");
        }
        return ModelUtil.getModel("OK",1,student);
    }

    @RequestMapping("/anysAdd")
    @ResponseBody
    public Model anysAdd(){
        logger.info("当前请求线程是:"+Thread.currentThread().getId());
        aysnService.asyncAdd();
        return ModelUtil.getModel("异步线程处理",1,Thread.currentThread().getId());
    }
}
