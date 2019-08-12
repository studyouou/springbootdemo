package org.ougen.springbootdemo.util;

import org.ougen.springbootdemo.model.Model;

/**
 * Author: OuGen
 * Discription:
 * Date: 10:59 2019/7/16
 */
public class ModelUtil <T>{
    public static <T> Model getModel(String msg,int code,T t){
        Model<T> tModel = new Model<T>();
        tModel.setCode(code);
        tModel.setMsg(msg);
        tModel.setData(t);
        return tModel;
    }
}
