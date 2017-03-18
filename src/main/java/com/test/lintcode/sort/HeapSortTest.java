package com.test.lintcode.sort;

/**
 * Created by le on 2017/3/18.
 * 堆排序   直接选择排序的一种优化
 * 堆是一种数据结构，可以被视为一颗完全二叉树  可以用数组存储
 * 假定数组索引i元素  如果它有子树 左子树的索引为 2i+1  右子树索引为2i+2  如果有父节点 索引为（i-1）/2
 * 分为最大（大顶堆）堆和最小堆（小顶堆） 最大堆即为任意子树跟节点都大于子节点，最小堆反之
 * 堆排序就是利用最大堆的特性，可以方便的每次从无序中选择最大元素
 * 1、所有元素建立最大堆
 * 2、将堆顶元素和最后一个元素交换
 * 3、建立除最后一个元素外的最大堆
 * 4、循环建堆、交换
 */
public class HeapSortTest {

    public static void main(String[] args) {

        int [] nums = new int[]{10,20,15,-6,6,7,2,1,-5,55,2};

        heapSort(nums);

        System.out.println(nums.length);
    }

    public static void heapSort(int[] nums){
        int length = nums.length;
        for(int i=0;i<length-1;i++){
            //建立最大堆   最大堆只能建立到最后两个元素 即length-1-i>=1
            maxHeap(nums,length-1-i);
            //将堆顶元素和末尾元素交换
            SortUtils.swap(nums,0,length-1-i);
        }

    }

    //建立从0到last的最大堆   最后一个元素一定是二叉树最下边和最右边的元素
    private static void maxHeap(int[] nums,int end){
        if(end==2) {
            System.out.println(1);
        }
        //从最后一个元素的父节点i开始   依次向上  比父节点i索引小的一定是i的父节点或左兄弟节点
        for(int i=(end-1)/2;i>=0;i--){
            //求子节点中的最大值的索引
            int biggerIndex = 2*i+1;
            if(2*i+2<=end && nums[2*i+2]>nums[2*i+1]){
                biggerIndex = 2*i+2;
            }
            if(nums[biggerIndex]>nums[i]){
                SortUtils.swap(nums,i,biggerIndex);
            }
        }


    }

}
