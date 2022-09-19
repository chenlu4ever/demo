package com.example.demo.sql;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author 10450
 * @description TODO
 * @date 2021/12/21 9:45
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();

        //传统
        String name = "tom";
        List<Map> list1 = sqlSession.selectList("com.demo.mapper.UserMapper.getUserByName",name);

        //这里不再调用SqlSession 的api，而是获得了接口对象，调用接口中的方法。
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Map> list2 = mapper.getUserByName("tom");

    }
}
