package com.springtest.config;

import com.springtest.service.MyOrderService;
import com.springtest.service.OrderService;
import com.springtest.service.TestService;
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
public class TestConfiguration {

    public TestConfiguration() {
        System.out.println(" test configuration init ");
    }

    @Bean
    public MyOrderService gerService() {
        System.out.println(" order service init ");
        return new OrderService();
    }
}
