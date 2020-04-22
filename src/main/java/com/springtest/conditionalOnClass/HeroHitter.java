package com.springtest.conditionalOnClass;

/**
 * @author Mirko
 * @Description
 * @createTime 2020年02月29日 15:51:00
 */
public class HeroHitter implements Hitter {
    @Override
    public void hit() {
        System.out.println("hero hitter");
    }
}
