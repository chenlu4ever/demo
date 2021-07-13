package com.example.demo.test;

import java.util.List;

/**
 * @author 10450
 * @description TODO
 * @date 2021/3/12 11:33
 */
public class MenuModel {

    private Long id;

    private String code;

    private String name;

    private String parentCode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
}
