package com.example.demo.jtest;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.controller.InviteController;
import com.example.demo.service.TblDictService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * @author 10450
 * @description 测试
 * @date 2021/7/15 17:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class EhcacheTest {
    public  static Logger logger = LoggerFactory.getLogger(InviteController.class);
    @Autowired
    TblDictService tblDictService;

    @Test
    public void testSave() {
        logger.info("test1111111111111");
        Map map =   tblDictService.queryAllDict();
        System.out.println(JSONObject.toJSONString(map));

        Map map2 =   tblDictService.queryAllDict();
        System.out.println(JSONObject.toJSONString(map2));
    }

}
