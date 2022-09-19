package com.example.demo.jdk8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 10450
 * @description | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
 * @date 2021/12/16 15:41
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> stringlist = new ArrayList<String>(){{add("A");add("D");add("N");add("C");add("I");add("E");add("B");add("Z");}};
        stringlist.stream().sorted().forEach((t)-> System.out.print(t));
        List stringlist2 = stringlist.stream().sorted().collect(Collectors.toList());
        System.out.println("=========================================");
        stringlist2.forEach(System.out::print);

//        List<RankVO> list = new ArrayList<RankVO>(){{
//            add(new RankVO("张三","T1",90));
//            add(new RankVO("李四","T1",100));
//            add(new RankVO("王五","T2",88));
//            add(new RankVO("陈六","T1",95));
//            add(new RankVO("许七","T2",95));
//            add(new RankVO("杨八","T2",84));
//            add(new RankVO("汪九","T2",99));
//        }};
//        jdk8TestList(list);
    }

    static void jdk8TestList(List<RankVO> list){
        //按照降序输出》90分同学的名字
         List<RankVO> list1 = list.stream().filter(rankVO -> rankVO.getScore()>90).sorted(Comparator.comparing(RankVO::getScore).reversed()).collect(Collectors.toList());
         list1.forEach((t)-> System.out.println(t.getName()+":"+t.getScore()));

        System.out.println("=========================================");
         //分组type有多少人
        Map<String, Long> map2 = list.stream().collect(Collectors.groupingBy(RankVO::getType, Collectors.counting()));
        map2.forEach((k,v)-> System.out.println(k+":"+v ));


        System.out.println("=========================================");

    }

    static class RankVO{
        private String name;
        private String type;
        private Integer score;

        RankVO(String name,String type,Integer score){
            this.name=name;
            this.score=score;
            this.type=type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }
    }
}
