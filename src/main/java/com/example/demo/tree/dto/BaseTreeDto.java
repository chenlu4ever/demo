package com.example.demo.tree.dto;

import com.example.demo.service.impl.InviteServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author 10450
 * @description 树对象
 * @date 2022/9/15 9:37
 */
public class BaseTreeDto<T extends BaseTreeDto<T>> {
    public  static Logger logger = LoggerFactory.getLogger(BaseTreeDto.class);

    //维度聚合连接常量
    public static final String KEY_CONN = "<key_conn>";

    public static final String UNDEFINED = "未定义";

    @JsonProperty("dimensionFullKey")
    private String dimensionFullKey;

    @JsonProperty("col_Dim_Value")
    private String colDimValue;

    @JsonIgnore
    private String currentDepth;

    @JsonIgnore
    private String currentDim;

    @JsonIgnore
    private T parent;

    @JsonProperty("children")
    private List<T> children;


}