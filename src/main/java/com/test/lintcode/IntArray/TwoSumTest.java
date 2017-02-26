package com.test.lintcode.IntArray;

/**
 * Created by le on 2017/2/26.
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 1 到 n，不是以 0 开头
 * 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [1, 2].
 */
public class TwoSumTest {

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

}
