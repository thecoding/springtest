package com.springtest.bean.def;

import com.springtest.pojo.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

/**
 * @author Mirko
 * @Description
 * @createTime 2020年04月22日 23:45:00
 */
public class BeanDefinitionRegistryTest1 {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //registry 三种方式
        //第一种：通过注解@Bean 注册
        context.register(BeanDefinitionRegistryTest1.Config.class);
        //命名方式注册
        registryBeanDefinition(context, "user-2");
        //非命名方式注册
        registryBeanDefinition(context, null);

        context.refresh();

        System.out.println(context.getBeansOfType(User.class));
        context.close();
    }


    public static void  registryBeanDefinition(BeanDefinitionRegistry registry, String beanName){
        BeanDefinitionBuilder builder =  BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("name", "user-1")
                .addPropertyValue("age", 17);
        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
        }else{
            BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), registry);
        }
    }

    public static class Config {
        @Bean
        public User user(){
            User user = new User();
            user.setName("xiaoming");
            user.setAge(18);
            return user;
        }
    }
}
