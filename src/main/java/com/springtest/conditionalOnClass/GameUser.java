package com.springtest.conditionalOnClass;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Mirko
 * @Description
 * @createTime 2020年02月29日 15:47:00
 */
public class GameUser {

    @Autowired
    Hitter hitter;


    public void userHitter(){
        hitter.hit();
    }


    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> cls = Class.forName(DevilHitter.class.getName());

    }
}
