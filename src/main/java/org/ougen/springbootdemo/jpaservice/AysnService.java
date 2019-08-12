package org.ougen.springbootdemo.jpaservice;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Author: OuGen
 * Discription:
 * Date: 14:35 2019/7/22
 */
@Service
public class AysnService {
    @Async
    public void asyncAdd(){
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程"+Thread.currentThread().getId()+"正在为您处理");
        }
    }
}
