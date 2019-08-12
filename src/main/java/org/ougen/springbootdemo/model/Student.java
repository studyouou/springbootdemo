package org.ougen.springbootdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * Author: OuGen
 * Discription:
 * Date: 9:45 2019/7/17
 */
@Entity(name = "Student")
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Student implements Serializable {
    public Student() {
    }

    public Student(String name, int age, int classes, String city) {
        this.name = name;
        this.age = age;
        this.classes = classes;
        this.city = city;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message ="studentId不能为空")
    private int studentId;

    @Column
    @NotEmpty(message = "姓名不能为空")
    private String name;

    @Column
    @Max(value = 100,message = "年龄必须在1-100以内")
    @Min(value = 1,message ="年龄必须在1-100以内")
    private int age;

    @Column(name="class")
    private int classes;

    @Column
    @NotEmpty(message = "城市不能为空")
    private String city;

    @Email()
    private String email;
}
