package com.example.demo.jtest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author 10450
 * @description
 * @date 2021/12/19 13:02
 */
@Component
public class SpringBeanService implements InitializingBean {

    @Autowired
    private SpringBeanServiceTwo springBeanServiceTwo;

    private SpringBeanVO springBeanVO;

    @PostConstruct
    public void postConstructFunction() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
