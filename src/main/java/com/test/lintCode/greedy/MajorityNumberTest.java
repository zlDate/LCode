package com.test.lintCode.greedy;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/14.
 * 46 主元素
 * 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一
 * 给出数组[1,1,1,1,2,2,2]，返回 1
 */
public class MajorityNumberTest {

    public static int majorityNumber(ArrayList<Integer> nums) {
        int tmp=0;
        int count=0;
        for(Integer i:nums){
            //当count为0时 取新的元素遍历
            if(count==0) tmp = i;
            if(tmp!=i) count--;
            else count++;
        }
        return tmp;
    }


}
