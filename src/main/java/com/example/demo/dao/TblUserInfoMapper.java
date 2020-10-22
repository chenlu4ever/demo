package com.example.demo.dao;

import com.example.demo.model.TblUserInfo;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;

public interface TblUserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(TblUserInfo record);

    int insertSelective(TblUserInfo record);

    TblUserInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(TblUserInfo record);

    int updateByPrimaryKey(TblUserInfo record);

    List<TblUserInfo> queryUserList(Map<String, Object> requestMap);
}