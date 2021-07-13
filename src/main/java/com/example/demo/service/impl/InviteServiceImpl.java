package com.example.demo.service.impl;

import com.example.demo.dao.TblInviteInfoMapper;
import com.example.demo.dto.InviteInfoDto;
import com.example.demo.service.InviteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InviteServiceImpl implements InviteService {
    public  static Logger logger = LoggerFactory.getLogger(InviteServiceImpl.class);
    @Autowired
    TblInviteInfoMapper tblInviteInfoMapper;

    @Override
    public InviteInfoDto queryInviteDetail(Map<String, String> requestMap) {
        return tblInviteInfoMapper.queryInviteDetail(requestMap);
    }
}
