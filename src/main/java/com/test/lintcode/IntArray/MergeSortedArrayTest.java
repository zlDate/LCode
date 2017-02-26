package com.test.lintcode.IntArray;

/**
 * Created by le on 2017/2/26.
 * 合并两个排序的整数数组A和B变成一个新的数组。
 * 你可以假设A具有足够的空间（A数组的大小大于或等于m+n）去添加B中的元素。
 * 给出 A = [1, 2, 3, empty, empty], B = [4, 5]
 * 合并之后 A 将变成 [1,2,3,4,5]
 */
public class MergeSortedArrayTest {

    public static void main(String[] args) {
        int [] A = new int[]{1,2,3};
        int [] B = new int[]{4,5};
        mergeSortedArray(A,3,B,2);

    }

    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int [] a = new int[m+n];
        for(int i=0;i<a.length;i++){
            if(i<m){
                a[i] = A[i];
            }else{
                a[i] = B[i-m];
            }
        }
        //TODO: java无法实现  java数组长度不可变
        A = a;
    }

}
