package org.ougen.springbootdemo.aop;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Author: OuGen
 * Discription:
 * Date: 13:48 2019/7/17
 */
@Component
@Aspect
public class UserTimeAop {
    private Logger logger = LoggerFactory.getLogger(UserTimeAop.class);
    @Pointcut("execution(* org.ougen.springbootdemo.jpaservice.Service1.*(..))")
    @Order(1)
    public void getStratTime(){
    }

    @Pointcut("target(org.ougen.springbootdemo.jpaservice.Service1)")
    @Order(2)
    public void getEndTime(){
    }


    @Pointcut("execution(* org.ougen.springbootdemo.jpaservice.Service1.findByName(..))")
    @Order(1)
    public void around(){}


    @Before("getStratTime()||getEndTime()")
    public void befireRun(JoinPoint joinPoint){
        System.out.println("切面开始");
        Signature signature = joinPoint.getSignature();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String url = request.getRequestURL().toString();
        Class declaringType = signature.getDeclaringType();
        String declaringTypeName = signature.getDeclaringTypeName();

        String kind = joinPoint.getKind();
//        joinPoint.getSourceLocation().getFileName();
        joinPoint.getStaticPart();
        Object target = joinPoint.getTarget();
        int modifiers = signature.getModifiers();
        String name = signature.getName();
        logger.info("匹配拦截类方法{}",declaringTypeName+":"+name);
        logger.info("请求的url为：{}",url);
        Object[] args = joinPoint.getArgs();
        Gson gson = new Gson();
        String gson_string = gson.toJson(args);
        System.out.println(gson_string);
    }

    @AfterReturning("getEndTime()")
    public void afterRun(JoinPoint joinPoint){
        logger.info("匹配拦截类方法{}",joinPoint.getSignature().getDeclaringTypeName()+":"+joinPoint.getSignature().getName());
        System.out.println("切面结束");
    }
//    @Around(value = "execution(* org.ougen.springbootdemo.jpaservice.Service1.findByName(..))")
//    public void around(ProceedingJoinPoint proceed){
//        logger.info(proceed.getSignature().getDeclaringTypeName()+"被拦截了");
//        logger.info("around切面开始");
//        long start = System.currentTimeMillis();
//        Object o ;
//        try {
//            o = proceed.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        long endtime = System.currentTimeMillis();
//        logger.info("around切面结束,用时time{}",endtime-start);
//        System.out.println();
//    }
}
