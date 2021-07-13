package com.example.demo.test;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 10450
 * @description TODO
 * @date 2021/3/12 11:32
 */
public class MenuTreeTest {
    public static void main(String[] args) {
        List<MenuEO> olist  = new ArrayList();  //假设这是数据库查询出来的 select id ... from menu表
        Map parent = new HashMap<>();
        List<MenuEO> childList  = new ArrayList();
        if(olist!=null && olist.size()>0){
            for (MenuEO model:  olist) {
                if(StringUtils.isEmpty(model.getParentCode())){
                    parent.put(model.getId(),model);
                }else{
                    childList.add(model);
                }
            }
        }

        for(MenuEO model : childList ){
            if(parent.get(model.getParentCode())!=null){
                MenuEO menuEO  = (MenuEO) parent.get(model.getParentCode());
                if(menuEO.getChildMenus()==null){
                    List childMenus = new ArrayList();
                    childMenus.add(model);
                    menuEO.setChildMenus(childMenus);
                }else{
                    List childMenus =menuEO.getChildMenus();
                    childMenus.add(model);
                }
            }
        }
    }
}
