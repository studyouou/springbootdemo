package org.ougen.springbootdemo.quartzs;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * Author: OuGen
 * Discription:
 * Date: 22:01 2019/7/17
 */
@Configuration
public class QuartzComponent {
    @Bean
    public Scheduler getScheduler(){
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(getJobDetail(),getTrigger());
            scheduler.start();
            System.out.println("定时任务已经启动");
            return scheduler;
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
    public Trigger getTrigger(){
         return TriggerBuilder.newTrigger().withIdentity("cronTrigger").withSchedule(CronScheduleBuilder.cronSchedule("0/6 * * * * ?")).build();
    }
    public JobDetail getJobDetail(){
        return JobBuilder.newJob(MyJob.class).withIdentity("job").build();
    }

}

