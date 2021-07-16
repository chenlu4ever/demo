package com.example.demo.service;

import com.example.demo.dto.InviteInfoDto;

import java.util.Map;

public interface InviteService {
    InviteInfoDto queryInviteDetail(Map<String, String> requestMap);
}
