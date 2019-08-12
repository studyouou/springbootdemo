package org.ougen.springbootdemo;

import org.ougen.springbootdemo.components.Car;
import org.ougen.springbootdemo.components.Person;
import org.ougen.springbootdemo.components.RegistModel;
import org.ougen.springbootdemo.components.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.http.HttpProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@ComponentScan("org.ougen")
@EnableScheduling
public class SpringbootdemoApplication {
    private static Logger logger = LoggerFactory.getLogger(SpringbootdemoApplication.class);
    public static void main(String[] args){
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootdemoApplication.class, args);
        run.getBean(User.class);
        logger.info("启动服务");
        logger.error("启动完成");
    }
}
