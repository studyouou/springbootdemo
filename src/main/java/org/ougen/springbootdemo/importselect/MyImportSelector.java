package org.ougen.springbootdemo.importselect;

import org.ougen.springbootdemo.components.Car;
import org.ougen.springbootdemo.components.Person;
import org.ougen.springbootdemo.importannotation.EnableLogInfo;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Author: OuGen
 * Discription:
 * Date: 17:08 2019/7/16
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        String s = annotationMetadata.getAnnotationAttributes(EnableLogInfo.class.getName()).toString();
        if (s.contains("onlyCar")){
            return new String[]{Car.class.getName()};
        }
        return new String[]{Person.class.getName(),Car.class.getName()};
    }
}
