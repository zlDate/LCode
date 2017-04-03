package com.test.lintCode.IntArray;

import java.util.Arrays;

/**
 * Created by le on 2017/3/30.
 * 实现从一个整型数组找出最大的连续子数组其和最大
 * 例如数组[1,-3,2,-7,8,7,-2,6,-3,-10,9]
 * 最大子数组为 8，7，-2，6  和为19最大
 */
public class MaxSubArraySumTest {

    public static void main(String[] args) {
        int[] nums = new int[]{1,-3,2,-7,8,7,-2,6,-3,-10,9};
        int[] a = maxSubArraySum3(nums);
        System.out.println(a.length);
    }

    /**
     * sum数组法
     * 先求出从0到n的所有子数组之和sum[n]   0-1,0-2...0-n
     * 如果假设从start-end的子数组和最大  则最大值为sumMax = sum[end]-sum[start]
     * 在end之前 sum[start]一定是最小的sum中最小的则从0-end中子数组start-end一定是最大的
     * @param nums 数组
     * @return 最大子数组
     */
    private static int[] maxSubArraySum(int[] nums){
        //构建sum数组
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i] = sum[i-1]+nums[i];
        }
        //从0开始
        int start = 0;
        int end = 0;
        int maxSum = sum[0];
        int min = 0;
        for(int i=1;i<nums.length;i++){
            //如果sum[i-1]比mix还小 则替换min
            if(sum[i-1]<min){
                min = sum[i-1];
                start = i;
            }
            //判断start-i间是不是最大子数组
            if(maxSum<sum[i]-min){
                maxSum = sum[i]-min;
                end = i;
            }
        }
        int[] result = new int[end-start+1];
        for(int i=0;i<result.length;i++){
            result[i] = nums[start];
            start++;
        }
        return result;
    }

    /**
     * 动态规划
     * 定义数组all和start
     * all数组的第i个元素是数组nums0-i个元素中最大子数组的和
     * start数组的第i个元素是数组nums0-i个元素中包含nums[i]的最大子数组的和
     * @param nums
     * @return
     * 时间复杂度为O(n)空间复杂度可以降低  all和start没有必要定义为数组  可以直接定义为一个整数
     */
    private static int[] maxSubArraySum2(int [] nums){
        int [] all = new int[nums.length];
        int [] start = new int[nums.length];
        //初始都是nums[0]
        all[0]=start[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            //start[i]必须包含nums[i],所以取start[i-1]+nums[i],nums[i]中最大的
            if(start[i-1]+nums[i]>nums[i]){
                start[i] = start[i-1]+nums[i];
            }else {
                start[i] = nums[i];
            }
            start[i] = Math.max(start[i-1]+nums[i],nums[i]);
            //all[i] 增加一个元素nunms[i]后 最大子数组要么包含nums[i]要么不包含  包含就是start[i]  不包含就是all[i-1]
            all[i] = Math.max(start[i],all[i-1]);
        }
        return null;
    }

    /**
     * 动态规划降低空间复杂度版本
     * @param nums
     * @return
     */
    private static int[] maxSubArraySum3(int [] nums){
        int all = nums[0];
        int start = nums[0];
        //记录start数组的起始和结束位置
        int begin=0,end=0;
        //记录all数组的起始和结束位置
        int begin2=0,end2=0;
        for(int i=1;i<nums.length;i++){
            if(start+nums[i]<nums[i]){
                start = nums[i];
                begin = i;
                end = i;
            }else {
                start = start + nums[i];
                end = i;
            }
            if(all<start){
                all = start;
                begin2 = begin;
                end2 = end;
            }
        }
        return Arrays.copyOfRange(nums,begin2,end2+1);
    }
}
