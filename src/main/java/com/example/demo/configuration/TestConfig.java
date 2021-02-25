package com.example.demo.configuration;

import com.example.demo.model.UserModel;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "testconfig")
public class TestConfig {
    private String id;
    private String  test_name;
    private int num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Bean
    public UserModel UserModel(){
        UserModel model = new UserModel();
        model.setUserName(test_name);
        model.setPassword(id);
        return model;
    }
}
