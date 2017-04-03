package com.test.lintCode.IntArray;

import java.util.Arrays;

/**
 * Created by le on 2017/3/4.
 * 31 数组划分
 * 给出一个整数数组 nums 和一个整数 k。划分数组（即移动数组 nums 中的元素），使得：
 * 所有小于k的元素移到左边
 * 所有大于等于k的元素移到右边
 * 返回数组划分的位置，即数组中第一个位置 i，满足 nums[i] 大于等于 k。
 * 你应该真正的划分数组 nums，而不仅仅只是计算比 k 小的整数数，如果数组 nums 中的所有元素都比 k 小，则返回 nums.length。
 * 给出数组 nums = [3,2,2,1] 和 k = 2，返回 1.
 */
public class PartitionArrayTest {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=k){
                return i;
            }

        }
        return nums.length;
    }

    public static int partitionArray2(int[] nums, int k) {
        int start = 0;
        int end = nums.length-1;
        while (start<end){
            //依次循环比较两个 开头和结尾
            if(nums[start]>=k && nums[end]<k) swap(nums,start,end);
            if(nums[end]>=k) end--;
            if(nums[start]<k) start++;
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<k){
                count++;
            }
        }
        return count;
    }
    //a,b交换位置
    private static void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
