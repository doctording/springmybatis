package com.example.demo.spi;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author mubi
 * @Date 2023/9/9 15:11
 */
@Configuration
public class AppConfig2 {

//    @Bean
//    public A a(){
//        return new A();
//    }
//
    @Bean
    public B b(){
        return new B();
    }
}
