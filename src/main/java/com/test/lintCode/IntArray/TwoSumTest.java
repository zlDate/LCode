package com.test.lintCode.IntArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by le on 2017/2/26.
 * 56 两数之和
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 1 到 n，不是以 0 开头
 * 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [1, 2].
 */
public class TwoSumTest {
    //1976ms
    public int[] twoSum(int[] numbers, int target) {
        int[] ints = new int[2];
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j]==target){
                    ints[0] = i+1;
                    ints[1] = j+1;
                    return ints;
                }

            }
        }
        return ints;
    }

    //1187ms
    public int[] twoSum2(int[] numbers, int target){
        int[] ints = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(numbers[i])){
                ints[0] = map.get(numbers[i]);
                ints[1] = i+1;
            }
            map.put(target-numbers[i],i+1);

        }

        return ints;
    }

}
