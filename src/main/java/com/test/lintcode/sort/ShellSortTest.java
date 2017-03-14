package com.test.lintcode.sort;

/**
 * Created by le on 2017/3/14.
 * 希尔排序   直接插入排序的一种优化
 * 对一个无序数组进行从小到大的排序，但是数组的最后一个位置的数是最小的，
 * 我们要把它挪到第一个位置，其他位置的都要往后移动，要是这个数组非常大，那么直接插入排序的开销就非常大
 *
 * 先从array[0]开始，以incrementNum为增量的进行直接插入排序，直到数组末尾，然后从array[1]开始重复：
 * 以incrementNum为增量的进行直接插入排序; 然后从array[1]开始重复......一直到array[n]。
 * 然后取一个小于上一步增量的新的增量（比如设置为incrementNum/2）,对前一个步骤的结果array进行遍历，直接插入排序....
 * 再取小于上一步增量的新的增量，重复进行：遍历，直接插入排序
 * 直到新的增量小于1之后再退出循环
 */
public class ShellSortTest {

    public static void main(String[] args) {
        int [] nums = new int[]{10,20,15,0,6,7,2,1,-5,55,3};

        shellSort(nums);

        System.out.println(nums.length);
    }

    private static void shellSort2(int[] nums){
        int j = 0;
        int temp = 0;
        //每次将步长缩短为原来的一半
        for (int increment = nums.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < nums.length; i++) {
                temp = nums[i];
                for (j = i; j >= increment; j -= increment) {
                    if(temp < nums[j - increment])//如想从小到大排只需修改这里
                    {
                        nums[j] = nums[j - increment];
                    }
                    else break;
                }
                nums[j] = temp;
            }

        }
    }

    private static void shellSort(int[] nums){
        if(nums == null || nums.length <= 1) return;

        int incrementNum = nums.length/2;

        while (incrementNum>=1){
            //从增量处开始，每一次都和上一个增量值比较，相当于插入排序  确认前面的都有序
            for(int i=incrementNum;i<nums.length;i++){

                for(int j=i;j>=incrementNum;j-=incrementNum){
                    if(nums[j]<nums[j-incrementNum]){
                        SortUtils.swap(nums,j,j-incrementNum);
                    }
                }
            }
            incrementNum /= 2;
        }
    }

}
