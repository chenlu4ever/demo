package com.example.demo.service.impl;

import com.example.demo.Exception.DemoRuntimeException;
import com.example.demo.constants.DemoConstants;
import com.example.demo.dao.TblUserInfoMapper;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.TblUserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.util.DemoStringUtil;
import com.example.demo.util.EncryptedUtil;
import com.example.demo.util.ResponseUtil;
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
        tblUserInfo.setPassword(EncryptedUtil.generate(tblUserInfo.getPassword(),EncryptedUtil.getRandomSalt()));
        tblUserInfoMapper.insertSelective(tblUserInfo);
    }

    @Override
    public TblUserInfo checkUserLogin(Map<String,Object> paramMap) {
        String loginId = DemoStringUtil.safeToString(paramMap.get("loginId"));
        String password = DemoStringUtil.safeToString(paramMap.get("password"));
        TblUserInfo tblUserInfo = tblUserInfoMapper.queryByLoginId(loginId);
        if(tblUserInfo == null){
            throw new DemoRuntimeException(ResponseUtil.DATA_NOT_EXISTES,loginId+ResponseUtil.DATA_NOT_EXISTES_MSG);
        }
        if(!EncryptedUtil.verify(password,tblUserInfo.getPassword())){
            throw new DemoRuntimeException(ResponseUtil.PASSWORD_ERROR,ResponseUtil.PASSWORD_ERROR_MSG);
        }
        return tblUserInfo;
    }
}
