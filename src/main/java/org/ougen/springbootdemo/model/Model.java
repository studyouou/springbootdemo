package org.ougen.springbootdemo.model;

import lombok.Data;

/**
 * Author: OuGen
 * Discription:
 * Date: 10:53 2019/7/16
 */
@Data
public class Model<T> {
    private String msg;
    private int code;
    private T data;

}
