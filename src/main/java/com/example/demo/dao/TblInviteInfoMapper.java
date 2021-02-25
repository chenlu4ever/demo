/*
*
* TblInviteInfoMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2021-02-25
*/
package com.example.demo.dao;

import com.example.demo.model.TblInviteInfo;

public interface TblInviteInfoMapper {
    /**
     *
     * @mbg.generated 2021-02-25
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2021-02-25
     */
    int insert(TblInviteInfo record);

    /**
     *
     * @mbg.generated 2021-02-25
     */
    int insertSelective(TblInviteInfo record);

    /**
     *
     * @mbg.generated 2021-02-25
     */
    TblInviteInfo selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2021-02-25
     */
    int updateByPrimaryKeySelective(TblInviteInfo record);

    /**
     *
     * @mbg.generated 2021-02-25
     */
    int updateByPrimaryKeyWithBLOBs(TblInviteInfo record);

    /**
     *
     * @mbg.generated 2021-02-25
     */
    int updateByPrimaryKey(TblInviteInfo record);
}