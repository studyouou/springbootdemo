package org.ougen.springbootdemo.importannotation;

import org.ougen.springbootdemo.importselect.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Author: OuGen
 * Discription:
 * Date: 17:09 2019/7/16
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@Import(MyImportSelector.class)
public @interface EnableLogInfo {
    String name() default "onlyCar";
    String value() default "onlyPerson";
}
