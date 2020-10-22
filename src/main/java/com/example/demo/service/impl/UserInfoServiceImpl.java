package com.example.demo.service.impl;

import com.example.demo.dao.TblUserInfoMapper;
import com.example.demo.model.TblUserInfo;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    TblUserInfoMapper tblUserInfoMapper;
    @Override
    public List<TblUserInfo> queryUserList(Map<String, Object> requestMap) {
        return tblUserInfoMapper.queryUserList(requestMap);
    }
}
