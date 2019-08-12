package org.ougen.springbootdemo.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: OuGen
 * Discription:
 * Date: 19:49 2019/7/17
 */
@Component
public class SchedulerTask {
    private int count=0;

    @Scheduled(cron = "6 * * * * *")//每分钟第6秒执行
    private void process(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }
}
