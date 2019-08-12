package org.ougen.springbootdemo.importannotation;

import org.ougen.springbootdemo.importselect.MyImportRegiest;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Author: OuGen
 * Discription:
 * Date: 22:26 2019/7/16
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyImportRegiest.class)
public @interface RegiestImport {
    String value() default "onlyCar";
}
