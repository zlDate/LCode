package com.test.lintCode.sort;

/**
 * Created by le on 2017/3/5.
 * 冒泡排序
 * <li>比较相邻的元素。如果第一个比第二个大，就交换他们两个。</li>
 * <li>对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。</li>
 * <li>针对所有的元素重复以上的步骤，除了最后一个。</li>
 * <li>持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。</li>
 *
 */
public class BubbleSortTest {

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,3,2,1};
        bubble(nums);
    }

    //从最右边开始排
    private static void bubble(int[] nums){
        for(int i=nums.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    SortUtils.swap(nums,j,j+1);
                }
            }
        }
    }
    //从最左边开始排
    private static void bubble2(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    SortUtils.swap(nums,j,i);
                }
            }
        }


    }


}
