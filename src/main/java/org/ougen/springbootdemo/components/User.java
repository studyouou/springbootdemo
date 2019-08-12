package org.ougen.springbootdemo.components;

import lombok.Data;
import org.springframework.boot.autoconfigure.http.HttpProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Author: OuGen
 * Discription:
 * Date: 12:10 2019/7/16
 */
@Data
@ConfigurationProperties(prefix = "ower")
public class User implements Serializable {
    private String username;
    private String password;
    private int age;
    private String birthday;
    private String scop;
    private List<String> frient;
}
