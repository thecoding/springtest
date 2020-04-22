package com.springtest.conditionalOnClass;


/**
 * @author Mirko
 * @Description
 * @createTime 2020年02月29日 15:52:00
 */
public class DevilHitter implements Hitter {
    @Override
    public void hit() {
        System.out.println("devil hitter");
    }
}
