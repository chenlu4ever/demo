package com.example.demo.leetcode;

import com.alibaba.druid.sql.visitor.functions.Char;
import org.junit.platform.commons.util.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author 10450
 * @description leetcode 算法
 * @date 2022/7/12 9:53
 */
public class Solution {
    public static void main(String[] args) {
//        int[] nums = {1,1,2};
//        removeDuplicates(nums);


//        int[][] indices = {{0,1},{1,1}};
//        oddCells(2,3,indices);

//        strStr("baa", "aa");

//        System.out.println(""+multiply(2, 10));


    }

    /**
     * 递归实现乘法
     * @param A
     * @param B
     * @return
     */
    public static int multiply(int A, int B) {
        System.out.println(A+"*"+B);
        if(A==0 || B ==0){
            return 0;
        }
        if(A==1){
            return B;
        }
        if (B==1){
            return A;
        }

        if(A<B){
            A--;
            return B + multiply(A, B);
        }else{
            B--;
            return A + multiply(B, A);
        }
    }


    //返回位置
    public static int strStr(String haystack, String needle) {
        char[] sourceStr = haystack.toCharArray();
        int sourceC = sourceStr.length;
        char[] targetStr = needle.toCharArray();
        int targetC = targetStr.length;

        int offset = 0;
        int maxLenth = sourceC - targetC +1;
        for(int i = 0; i<maxLenth; i++){
            if(sourceStr[i] == targetStr[0]){
               for(int j=0; j<targetC; j++){
                   if(sourceStr[i+offset]==targetStr[0+offset]){
                       offset++;
                   }else{
                       break;
                   }
               }
               if(offset == targetC){
                   return i;
               }else{
                   offset=0;
               }
            }
        }
        return -1;
    }

    public static int oddCells(int m, int n, int[][] indices) {
        int[][] arryNum = new int[m][n];
        int count = 0;
        for(int i=0; i< indices.length; i++){
            int[] xy =  indices[i];
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    if(xy[0]==j){
                        arryNum[j][k] = arryNum[j][k]+1;
                    }
                    if(xy[1]==k){
                        arryNum[j][k] = arryNum[j][k]+1;
                    }
                    if(i==indices.length-1){
                        System.out.println(arryNum[j][k]+":"+arryNum[j][k]%2);
                        if(arryNum[j][k]%2!=0){
                            count++;
                        }
                    }
                }
                System.out.println(Arrays.toString(arryNum[j]));
            }
            System.out.println("------------");
        }

        return count;
    }

    /**
     * 升序排列 的数组 nums ，请你 原地 删除重复出现的元素
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0 ;
        for(int num : nums){
            if(i == 0 ){
                i++;
            }
            if(i == 0  ||  nums[i-1] != num){
                nums[i] = num;
                i++;
            }

        }
        System.out.println(i+","+Arrays.toString(nums));
        return i;
    }


//    //给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
//    //请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。
//    public static String reformat(String s) {
//
//        try {
//            Double.parseDouble(str);
//            return true;
//        } catch(Exception e){
//            return false;
//        }
//    }

}
