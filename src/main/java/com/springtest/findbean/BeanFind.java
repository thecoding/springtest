package com.springtest.findbean;

import com.springtest.pojo.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Mirko
 * @Description
 * @createTime 2020年04月21日 22:00:00
 */
@Configuration
public class BeanFind {


    @Bean(value = "user")
    public User getUser(){
        return new User("xx",12);
    }

    @Bean(value="objectFactory")
    public ObjectFactoryCreatingFactoryBean findFactory() {
        ObjectFactoryCreatingFactoryBean objectFactoryCreatingFactoryBean = new ObjectFactoryCreatingFactoryBean();
        objectFactoryCreatingFactoryBean.setTargetBeanName("user");
        return  objectFactoryCreatingFactoryBean;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanFind.class);

        // 延迟查找
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) applicationContext.getBean("objectFactory");
        System.out.println(objectFactory.getObject().toString());


        // 直接查找
        User user = (User) applicationContext.getBean("user");
        System.out.println(user.toString());
    }

}
