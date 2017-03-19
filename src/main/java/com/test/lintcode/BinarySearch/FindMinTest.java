package com.test.lintcode.BinarySearch;

/**
 * Created by le on 2017/3/19.
 * 159 寻找旋转排序数组中的最小值
 * 假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。
 * 你需要找到其中最小的元素。
 * 你可以假设数组中不存在重复的元素
 * 给出[4,5,6,7,0,1,2]  返回 0
 */
public class FindMinTest {

    public static void main(String[] args) {
        int[] nums = new int[]{6,1,2,3,4,5};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length;
        //如果数组是正常有序 直接返回第一个元素
        if(nums[start]<nums[end-1]) return nums[start];
        //如果不带=  则最后退出循环时 start>=end start处一定是最大的元素所以最后return时返回nums[start+1]
        while (start<=end){
            int mid = start+(end-start)/2;
            //如果mid处的元素比最后一个元素大  则最小元素一定在右边  否则在左边
            if(nums[mid]>nums[nums.length-1]){
                start = mid+1;
            }else{
                end = mid-1;
            }
            //如果mid处的元素大于下一个元素 则下一个元素一定是最小的
            if(mid+1<nums.length&&nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
        }
        return 0;
    }

}
