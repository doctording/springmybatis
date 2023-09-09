package com.example.demo.spi;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author mubi
 * @Date 2023/9/9 14:39
 */
@Component
public class ApplicationContextBean implements ApplicationContextAware, InitializingBean {

    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextBean.applicationContext = applicationContext;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            String name2 = applicationContext.getBean(name).getClass().getName();
            if(name2.startsWith("com.example.demo")) {
                System.out.println("spring bean name：" + name + " " + System.currentTimeMillis());
            }
        }
//        System.out.println("------Bean total:" + applicationContext.getBeanDefinitionCount());
    }

}
