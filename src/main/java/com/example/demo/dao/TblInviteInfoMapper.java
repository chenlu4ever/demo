package com.example.demo.dao;

import com.example.demo.dto.InviteInfoDto;
import com.example.demo.model.TblInviteInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

public interface TblInviteInfoMapper {
    /**
     *
     * @mbg.generated 2021-03-04
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2021-03-04
     */
    int insert(TblInviteInfo record);

    /**
     *
     * @mbg.generated 2021-03-04
     */
    int insertSelective(TblInviteInfo record);

    /**
     *
     * @mbg.generated 2021-03-04
     */
    TblInviteInfo selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2021-03-04
     */
    int updateByPrimaryKeySelective(TblInviteInfo record);

    /**
     *
     * @mbg.generated 2021-03-04
     */
    int updateByPrimaryKeyWithBLOBs(TblInviteInfo record);

    /**
     *
     * @mbg.generated 2021-03-04
     */
    int updateByPrimaryKey(TblInviteInfo record);

    InviteInfoDto queryInviteDetail(Map<String, String> requestMap);
}