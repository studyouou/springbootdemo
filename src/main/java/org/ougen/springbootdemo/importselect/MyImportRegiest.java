package org.ougen.springbootdemo.importselect;

import org.ougen.springbootdemo.components.Car;
import org.ougen.springbootdemo.components.RegistModel;
import org.ougen.springbootdemo.importannotation.RegiestImport;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Author: OuGen
 * Discription:
 * Date: 22:28 2019/7/16
 */
public class MyImportRegiest implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean b = annotationMetadata.getAnnotationAttributes(RegiestImport.class.getName()).toString().contains("onlyCar");
        if (b){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
            rootBeanDefinition.setBeanClass(RegistModel.class);
            beanDefinitionRegistry.registerBeanDefinition(RegistModel.class.getName(),rootBeanDefinition);
        }
    }
}
