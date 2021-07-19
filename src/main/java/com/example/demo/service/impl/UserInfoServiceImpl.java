package com.example.demo.service.impl;

import com.example.demo.constants.DemoConstants;
import com.example.demo.dao.TblUserInfoMapper;
import com.example.demo.model.TblUserInfo;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    TblUserInfoMapper tblUserInfoMapper;

    @Override
    public List<TblUserInfo> queryUserList(TblUserInfo tblUserInfo) {
        return tblUserInfoMapper.queryUserList(tblUserInfo);
    }

    @Override
    public void addUser(TblUserInfo tblUserInfo) {
        tblUserInfo.setDataStatus(DemoConstants.DATA_STATUS_VALIDATE);
        tblUserInfo.setUserId(UUID.randomUUID().toString());
        tblUserInfoMapper.insertSelective(tblUserInfo);
    }
}
