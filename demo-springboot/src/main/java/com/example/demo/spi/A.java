package com.example.demo.spi;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author mubi
 * @Date 2023/9/9 14:39
 */
public class A {

    public A() {
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){

        }
        System.out.println("A init");
    }
}
