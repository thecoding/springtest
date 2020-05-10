package com.springtest;

import com.springtest.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


/**
 * @author Mirko
 * @Description
 * @createTime 2020年02月08日 14:19:00
 */
public class Application {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanDefinitionNames = application.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }




    }









    public static void test(){

        String a = "ABCDEFG";
        System.out.println(a.substring(3) + a.substring(3, 5));

        System.out.println(LocalDate.now().until(LocalDate.parse("2020-04-10"), ChronoUnit.DAYS));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_INSTANT));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_TIME));

        String[] url = new String[]{"http://localhost:8080/jenkins/getDefault"};

        for (String s : url) {
            if (!StringUtils.isEmpty(s)) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            String s1 = sendGet(s);
                            long l = System.currentTimeMillis();
                            System.out.printf("%d --收到%s请求，请求返回为：%s\n",l, s, s1);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        }
    }


    public static String sendGet(String url){
        BufferedReader bufferedReader = null;
        String line;
        StringBuffer sb = new StringBuffer();
        try {
            URL realUrl = new URL(url);
            URLConnection urlConnection = realUrl.openConnection();
            urlConnection.setConnectTimeout(3000);
            urlConnection.setRequestProperty("content-type", "charset=UTF-8");
            urlConnection.setRequestProperty("content-type", "application/json");
            urlConnection.setReadTimeout(60);
            urlConnection.connect();

           bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
