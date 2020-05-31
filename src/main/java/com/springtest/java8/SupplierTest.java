package com.springtest.java8;

import java.util.function.Supplier;

/**
 * @author Mirko
 * @Description
 * @createTime 2020年05月31日 22:52:00
 */
public class SupplierTest {

    public static void main(String[] args) {

    }


    public static Supplier<Integer> getSupplier(){
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return Math.round(10f);
            }
        };
        return supplier;
    }

   public static Supplier<Double> getSupplier1(){
        Supplier<Double> supplier =  Math::random;
        return supplier;
   }
}
