package com.springtest.bean.def;

import com.springtest.pojo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author Mirko
 * @Description
 * @createTime 2020年04月22日 23:45:00
 */
@Import(Config.class)
public class BeanDefinitionRegistryTest2 {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanDefinitionRegistryTest2.class);
        context.refresh();

        System.out.println(context.getBeansOfType(User.class));
        context.close();
    }

}

class Config {
    @Bean
    public User user(){
        User user = new User();
        user.setName("xiaoming");
        user.setAge(18);
        return user;
    }
}