package com.springtest.config;

import com.springtest.service.MyOrderService;
import com.springtest.service.OrderService;
import com.springtest.service.TestService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mirko
 * @Description
 * @createTime 2020年02月29日 15:24:00
 */
@Configuration
@AutoConfigureBefore(GameConfiguration.class)
public class TestConfiguration implements InstantiationAwareBeanPostProcessor {

    public TestConfiguration() {
        System.out.println(" test configuration init ");
    }

    @Bean
    public MyOrderService gerService() {
        System.out.println(" order service init ");
        return new OrderService();
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" postProcessBeforeInitialization  ");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" postProcessAfterInitialization ");
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println(" postProcessBeforeInstantiation ");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println(" postProcessAfterInstantiation ");
        return false;
    }
}
