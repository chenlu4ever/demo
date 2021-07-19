package com.example.demo.service.impl;

import com.example.demo.dao.TblDictMapper;
import com.example.demo.service.TblDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TblDictServiceImpl implements TblDictService {

    @Autowired
    TblDictMapper tblDictMapper;

    @Override
    @Cacheable(value = "all_dict")
    public Map<String,String> queryAllDict(){
        List<Map> list = tblDictMapper.queryAllDict();
        Map map = new HashMap<>();
        for (Map codeMap:
             list) {
            map.put(codeMap.get("code"),codeMap.get("name"));
        }
        return map;
    }

    @Override
    /**
     * 数据字典翻译
     */
    @Cacheable(value = "data_dict")
    public Map<String, String> queryDataDict() {
        List<Map> list = tblDictMapper.queryDataDict();
        Map map = new HashMap<>();
        for (Map codeMap:
                list) {
            map.put(codeMap.get("code"),codeMap.get("name"));
        }
        return map;
    }
}
