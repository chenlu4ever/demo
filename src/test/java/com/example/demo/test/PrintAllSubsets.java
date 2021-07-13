package com.example.demo.test;

import java.util.Arrays;

/**
 * @author 10450
 * @description TODO
 * @date 2021/3/10 17:35
 */
public class PrintAllSubsets {

    /** 设定一个目标值 */
    public static final int TARGET_SUM = 20;

    public void process(final int[] data, final int target) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("data不能为空");
        }

        int len = data.length;
        /**
         * 处理前先排序一下，这样有一个好处，如果一个数添加进去已经大于target了，
         * 那么该数后面的数添加进去都将大于target
         */
        Arrays.sort(data);
        this.processRecursion(data, 0, new int[len], 0, target);
    }

    private void processRecursion(final int[] data, int fromIndex,
                                  final int[] stack, final int stacklen, final int target) {
        if (target == 0) {
            /**
             * 如果符合条件，则输出符合条件的情况
             */
            printResult(Arrays.copyOf(stack, stacklen));
            return;
        }

        while (fromIndex < data.length && data[fromIndex] > target) {
            /**
             * 借助数组已经排序的好处，后面更大的数值，只要增加索引即可。
             */
            fromIndex++;
        }

        while (fromIndex < data.length && data[fromIndex] <= target) {
            /**
             * 当数据用完，或者当数值大于剩余想获取的目标值，结束循环
             */
            stack[stacklen] = data[fromIndex];
            processRecursion(data, fromIndex + 1, stack, stacklen + 1, target
                    - data[fromIndex]);
            fromIndex++;
        }
    }

    /**
     * 打印符合条件的结果，如 15 = 4+6+5
     */
    private void printResult(int[] copyOf) {
        StringBuilder sb = new StringBuilder();
        sb.append(TARGET_SUM).append(" = ");
        for (Integer i : copyOf) {
            sb.append(i).append("+");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }


    public static void main(String[] args) {
        PrintAllSubsets example = new PrintAllSubsets();
        int[] values = { 1, 4, 4, 4, 8, 6, 16, 20, 17 };
        example.process(values, PrintAllSubsets.TARGET_SUM);
    }
}