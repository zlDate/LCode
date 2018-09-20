package com.test.lintcode.sort;

/**
 * Created by le on 2017/3/13.
 */
public class SortUtils {

    //交换数组中i和j的位置
    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
