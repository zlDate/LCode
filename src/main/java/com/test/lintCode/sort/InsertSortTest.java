package com.test.lintcode.sort;

/**
 * Created by le on 2017/3/13.
 * 插入排序
 * <ul>
 * <li>从第一个元素开始，该元素可以认为已经被排序</li>
 * <li>取出下一个元素，在已经排序的元素序列中从后向前扫描</li>
 * <li>如果该元素（已排序）大于新元素，将该元素移到下一位置</li>
 * <li>重复步骤3，直到找到已排序的元素小于或者等于新元素的位置</li>
 * <li>将新元素插入到该位置中</li>
 * <li>重复步骤2</li>
 * </ul>
 */
public class InsertSortTest {


    public static void main(String[] args) {

        int [] nums = new int[]{10,20,15,0,6,7,2,1,-5,55};

        insertSort(nums);

        System.out.println(nums.length);

    }


    private static void insertSort(int[] nums){
        for(int i=1;i<nums.length;i++){
            int tmp = nums[i];
            int tmpIndex = i;
            for(int j=i-1;j>=0;j--){
                if(tmp<nums[j]){
                    SortUtils.swap(nums,tmpIndex,j);
                    tmpIndex = j;
                }
            }
        }
    }


}
