package com.example.demo.dao;

import com.example.demo.model.TblHolding;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

public interface TblHoldingMapper {
    /**
     *
     * @mbg.generated 2022-09-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2022-09-16
     */
    int insert(TblHolding record);

    /**
     *
     * @mbg.generated 2022-09-16
     */
    int insertSelective(TblHolding record);

    /**
     *
     * @mbg.generated 2022-09-16
     */
    TblHolding selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2022-09-16
     */
    int updateByPrimaryKeySelective(TblHolding record);

    /**
     *
     * @mbg.generated 2022-09-16
     */
    int updateByPrimaryKey(TblHolding record);
}