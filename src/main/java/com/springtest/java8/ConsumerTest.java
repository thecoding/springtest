package com.springtest.java8;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Mirko
 * @Description
 * @createTime 2020年05月31日 22:41:00
 */
public class ConsumerTest {

    private static Stream<String> stringStream  = Stream.of("a", "b", "c");

    public static void main(String[] args) {
        stringStream.forEach(consumer1());

//        stringStream.forEach((s) -> {
//            System.out.println("this is " + s);
//        });
    }

    public static Consumer<String> consumer1(){
        Consumer<String> consumer = (s) -> {
            System.out.println(s);
        };
        return consumer;
    }

    public static Consumer<String> consumer2(){
        Consumer<String> consumer = System.out::println;
        return consumer;
    }

    public static Consumer<String> consumer3(){
        Consumer<String> consumer = new Consumer<String>(){
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        return consumer;
    }



}
