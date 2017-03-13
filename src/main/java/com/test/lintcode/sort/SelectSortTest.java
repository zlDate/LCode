package com.test.lintcode.sort;

import java.io.FileNotFoundException;

/**
 * Created by le on 2017/3/9.
 * 选择排序
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止
 */
public class SelectSortTest {

    public static void main(String[] args) throws FileNotFoundException {
        int [] nums = new int[]{10,20,15,0,6,7,2,1,-5,55};
        selectSort(nums);
        System.out.println(nums.length);

    }


    private static void selectSort(int[] nums){
        if(nums.length<=0) return;

        for(int i=0;i<nums.length;i++){
            int min = nums[i];
            int minIndex = i;
            for(int j=i;j<nums.length;j++){
                if(min>nums[j]){
                    min = nums[j];
                    minIndex = j;
                }
            }
            SortUtils.swap(nums,i,minIndex);
        }


    }


}
