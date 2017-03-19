package com.test.lintcode.IntArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by le on 2017/2/26.
 * 100 删除排序数组中的重复数字
 * 给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次，并且返回新的数组的长度。
 * 不要使用额外的数组空间，必须在原地没有额外空间的条件下完成
 * 给出数组A =[1,1,2]，你的函数应该返回长度2，此时A=[1,2]。
 */
public class RemoveDuplicatesTest {

    public static void main(String[] args) {
        int [] nums = new int[]{-14,-14,-13,-13,-13,2,2,};
        removeDuplicates2(nums);
    }

    public int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(!list.contains(nums[i])) list.add(nums[i]);
        }
        for(int i=0;i<list.size();i++){
            nums[i] = list.get(i);
        }
        return list.size();
    }

    public static int removeDuplicates2(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length-count;j++){
                if(nums[i]==nums[j]){
                    removeElem(nums,j);
                    j--;
                    count++;
                }

            }


        }

        return nums.length-count;
    }
    //删除索引元素
    private static void removeElem(int[] nums,int index){
        if(nums.length>index){
            for(int i=index;i<nums.length-1;i++){
                nums[i] = nums[i+1];
            }
        }
    }

}
