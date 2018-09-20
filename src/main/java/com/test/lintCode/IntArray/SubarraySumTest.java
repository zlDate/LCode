package com.test.lintcode.IntArray;

import java.util.ArrayList;

/**
 * Created by le on 2017/2/25.
 * 138 子数组之和
 * 给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
 * 给出 [-3, 1, 2, -3, 4]，返回[0, 2] 或者 [1, 3]
 */
public class SubarraySumTest {

    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList list = new ArrayList();
        for(int i=0;i<nums.length;i++){
            int sum = nums[i];
            if(sum==0){
                list.add(i);
                list.add(i);
                return list;
            }
            for(int j=i+1;j<nums.length;j++){
                sum += nums[j];
                if(sum == 0){
                    list.add(i);
                    list.add(j);
                    return list;
                }
            }
        }
        return list;
    }

}
