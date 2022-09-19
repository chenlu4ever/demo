package com.example.demo.thread.pool;

import com.example.demo.vo.UserTestVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 10450
 * @description TODO
 * @date 2021/12/24 11:24
 */
public class ThreadPoolMain {


    public static void main(String[] args) {
        List<UserTestVO> userlist = new ArrayList<UserTestVO>();
        userlist.add(new UserTestVO(1,"张三",10));
        userlist.add(new UserTestVO(2,"李四",10));
        userlist.add(new UserTestVO(3,"王五",11));
        userlist.add(new UserTestVO(4,"吴六",12));
        userlist.add(new UserTestVO(7,"陈七",14));
        userlist.add(new UserTestVO(8,"许八",12));
        userlist.add(new UserTestVO(1,"张三",10));
        userlist.add(new UserTestVO(1,"张三",10));
        userlist.add(new UserTestVO(3,"王五",11));
        userlist.add(new UserTestVO(4,"吴六",12));
        userlist.add(new UserTestVO(1,"张三",10));
        userlist.add(new UserTestVO(8,"许八",12));
        userlist.add(new UserTestVO(1,"张三",10));
        userlist.add(new UserTestVO(2,"李四",10));
        userlist.add(new UserTestVO(3,"王五",11));
        userlist.add(new UserTestVO(4,"吴六",12));
        userlist.add(new UserTestVO(1,"张三",10));
        Map repeadMap =  new HashMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<List<UserTestVO>> submit = executorService.submit(new Callable<List<UserTestVO>>() {
            @Override
            public List<UserTestVO> call() throws Exception {
                return null;
            }
        });


    }



}
