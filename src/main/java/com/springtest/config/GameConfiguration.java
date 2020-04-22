package com.springtest.config;

import com.springtest.conditionalOnClass.DevilHitter;
import com.springtest.conditionalOnClass.GameUser;
import com.springtest.conditionalOnClass.HeroHitter;
import com.springtest.conditionalOnClass.Hitter;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

/**
 * @author Mirko
 * @Description
 * @createTime 2020年02月29日 15:54:00
 */
@Configuration
public class GameConfiguration implements ApplicationContextAware, ResourceLoaderAware {

    private ApplicationContext applicationContext;
    private ResourceLoader resourceLoader;

    public GameConfiguration() {

        System.out.println( " game configuration init ");
    }

    @Bean
    @ConditionalOnClass(HeroHitter.class)
    public GameUser gameUser(){
        System.out.println(" game user init");
        return new GameUser();
    }



    @Bean
    @ConditionalOnMissingBean
    public Hitter getHero(){
        return new HeroHitter();
    }

    @Bean
    @ConditionalOnMissingBean
    public Hitter getDevil(){
        return new DevilHitter();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
