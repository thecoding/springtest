package com.springtest.bean.def;

import com.springtest.pojo.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Mirko
 * @Description
 * @createTime 2020年04月22日 22:57:00
 */
public class BeanDefinitionTest {

    public static void main(String[] args) {

        //方式一
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("name", "xiaoming").addPropertyValue("age","22");

        //方式二
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("name", "xiaowang");
        propertyValues.addPropertyValue("age", 1);
        genericBeanDefinition.setPropertyValues(propertyValues);

        //如何使用？
        //如果设置好BeanDefinition信息就可以往Spring注册中心去注册了


        //Bean命名 BeanNameGenerator bean name 生成器


    }
}
