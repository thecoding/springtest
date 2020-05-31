package com.springtest.j2se;

import com.springtest.pojo.User;

import java.lang.reflect.Modifier;

/**
 * @author Mirko
 * @Description
 * @createTime 2020年05月31日 22:24:00
 */
public class J2seTest {


    public static void main(String[] args) throws ClassNotFoundException {
        modifierTest();
    }


    /**
     * !Modifier.isPublic(beanClass.getModifiers()) spring bean在實例化的時候会检测class对象是不是public，就是说class必须是public修饰
     * @throws ClassNotFoundException
     */
    public static void modifierTest() throws ClassNotFoundException {


        Class<?> userClazz = Class.forName("com.springtest.pojo.PrivateUser");
        System.out.println(userClazz.getModifiers());
        System.out.println(Modifier.isPublic(userClazz.getModifiers()));
    }
}
