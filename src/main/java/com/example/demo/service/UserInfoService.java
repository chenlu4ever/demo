package com.example.demo.service;

import com.example.demo.model.TblUserInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
    List<TblUserInfo> queryUserList(Map<String, Object> requestMap);
}
