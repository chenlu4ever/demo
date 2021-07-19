package com.example.demo.dao;

import com.example.demo.model.TblDict;
import com.example.demo.model.TblDictKey;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

public interface TblDictMapper {
    /**
     *
     * @mbg.generated 2021-03-04
     */
    int deleteByPrimaryKey(TblDictKey key);

    /**
     *
     * @mbg.generated 2021-03-04
     */
    int insert(TblDict record);

    /**
     *
     * @mbg.generated 2021-03-04
     */
    int insertSelective(TblDict record);

    /**
     *
     * @mbg.generated 2021-03-04
     */
    TblDict selectByPrimaryKey(TblDictKey key);

    /**
     *
     * @mbg.generated 2021-03-04
     */
    int updateByPrimaryKeySelective(TblDict record);

    /**
     *
     * @mbg.generated 2021-03-04
     */
    int updateByPrimaryKey(TblDict record);

    List<Map> queryAllDict();

    List<Map> queryDataDict();
}