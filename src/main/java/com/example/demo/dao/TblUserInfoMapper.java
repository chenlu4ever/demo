package com.example.demo.dao;

import com.example.demo.model.TblUserInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

public interface TblUserInfoMapper {
    /**
     *
     * @mbg.generated 2021-07-13
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     *
     * @mbg.generated 2021-07-13
     */
    int insert(TblUserInfo record);

    /**
     *
     * @mbg.generated 2021-07-13
     */
    int insertSelective(TblUserInfo record);

    /**
     *
     * @mbg.generated 2021-07-13
     */
    TblUserInfo selectByPrimaryKey(Integer userId);

    /**
     *
     * @mbg.generated 2021-07-13
     */
    int updateByPrimaryKeySelective(TblUserInfo record);

    /**
     *
     * @mbg.generated 2021-07-13
     */
    int updateByPrimaryKey(TblUserInfo record);
}