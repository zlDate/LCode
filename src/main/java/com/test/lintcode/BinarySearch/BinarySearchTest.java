package com.test.lintcode.BinarySearch;

/**
 * Created by le on 2017/3/19.
 * 14 二分查找
 * 给定一个排序的整数数组（升序）和一个要查找的整数target，
 * 用O(logn)的时间查找到target第一次出现的下标（从0开始），
 * 如果target不存在于数组中，返回-1。
 * 在数组 [1, 2, 3, 3, 4, 5, 10] 中二分查找3，返回2
 *
 * 二分查找中 时间复杂度计算可以堪称while循环次数
 * 第一次循环查找区间为n第二次为n/2 第三次为 n/4 第k次为 n/2^k
 * 最后 n/2^k>=1所以 2^k=n  k=log(n)（以2为底）
 *
 */
public class BinarySearchTest {


    public int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        //因为当start=end时 target有可能在start处 导致死循环 所以循环条件是start<end
        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid]<target){
                start = mid+1;
            }else if(nums[mid]>target){
                end = mid-1;
            }else {
                //当找到target时不能确定是不是第一次出现  所以接着在mid左边寻找
                end = mid;
            }
        }
        if(nums[start]==target){
            return start;
        }
        return -1;
    }



}
