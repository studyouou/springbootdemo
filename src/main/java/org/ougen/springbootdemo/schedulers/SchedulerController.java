package org.ougen.springbootdemo.schedulers;

import org.ougen.springbootdemo.model.Model;
import org.ougen.springbootdemo.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * Author: OuGen
 * Discription:
 * Date: 20:46 2019/7/17
 */
@RestController
public class SchedulerController {
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler ;

    private ScheduledFuture future;

    @Bean
    public ThreadPoolTaskScheduler newThreadPood(){
        return new ThreadPoolTaskScheduler();
    }

    @RequestMapping("/start")
    public Model startNow(){
        future = threadPoolTaskScheduler.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("可停止等nowtime："+new SimpleDateFormat("yyyy-MM-dd hh:mm:dd").format(new Date()));
            }
        },new CronTrigger("0/6 * * * * *"));
        return ModelUtil.getModel("开始",1,"0/6 * * * * *");
    }
    @RequestMapping("/stop")
    public Model stop(){
        if (future!=null) {
            future.cancel(true);
        }
        return ModelUtil.getModel("停止",2,"停止成功");
    }
}
