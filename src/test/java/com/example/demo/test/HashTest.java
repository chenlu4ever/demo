package com.example.demo.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author 10450
 * @description hash散列
 * @date 2021/12/16 17:35
 */
public class HashTest {
    public static void main(String[] args) {
        HashVO vo1 = new HashVO(10,"我是10");
        HashVO vo2 = new HashVO(5,"我是5");
        HashVO vo3 = new HashVO(7,"我是7");
        HashVO vo4 = new HashVO(14,"我是14");

        List list = new ArrayList<HashVO>(){{add(vo1);add(vo2);add(vo3);add(vo4);}};

        list.forEach((t)-> System.out.println(t.toString()));

    }

    static class HashVO {
        int id;
        String name;

        HashVO(int id,String name){
            this.id=id;
            this.name=name;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "HashVO{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (getClass() != object.getClass()) {
                return false;
            }
            HashVO other = (HashVO) object;
            if (id != other.id) {
                if (other.name != null) {
                    return false;
                }
            } else if (!name.equals(other.name)) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int result = id/2;
            return result;
        }
    }
}
