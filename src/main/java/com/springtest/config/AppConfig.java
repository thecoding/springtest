package com.springtest.config;

import com.springtest.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

/**
 * @author Mirko
 * @Description
 * @createTime 2020年02月08日 14:24:00
 */
@ComponentScan(value="com.springtest")
//, excludeFilters = @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, classes = {TestConfiguration.class})
public class AppConfig {


//    @Bean
    public TestService testService(){
        return new TestService();
    }




}
