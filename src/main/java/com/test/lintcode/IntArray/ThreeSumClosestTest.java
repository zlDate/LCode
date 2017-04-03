package com.test.lintCode.IntArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by le on 2017/3/3.
 * 59 最接近的三数之和
 * 给一个包含 n 个整数的数组 S, 找到和与给定整数 target 最接近的三元组，返回这三个数的和。
 * 只需要返回三元组之和，无需返回三元组本身
 * 例如 S = [-1, 2, 1, -4] and target = 1. 和最接近 1 的三元组是 -1 + 2 + 1 = 2.
 */
public class ThreeSumClosestTest {

    public static void main(String[] args) {
        int[] test = new int[]{2,7,11,15};
        threeSumClosest(test,3);

        Map map = new HashMap<>();



    }

    public static int threeSumClosest(int[] numbers, int target) {
        if(numbers.length<=3){
            int sum =0;
            for(int i=0;i<numbers.length;i++){
                sum += numbers[i];
            }
            return sum;
        }
        Arrays.sort(numbers);
        //结果
        int res = 0;
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<numbers.length-2;i++){    //-2保证left不越界
            int left = i+1;
            int right = numbers.length-1;
            while (left<right){
                int sum = numbers[i]+numbers[left]+numbers[right];      //将每个元素和左边的所有元素中选两个组成三元组
                //Math.abs(sum-target)总距离
                if(Math.abs(sum-target)<diff){
                    res = sum;
                    diff = Math.abs(sum-target);
                }
                //总距离比target小 则要减少距离必须增大左边界
                if(sum<target) left++;
                else right--;
            }
        }
        return res;
    }

}
