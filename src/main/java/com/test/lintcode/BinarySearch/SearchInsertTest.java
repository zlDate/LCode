package com.test.lintcode.BinarySearch;

/**
 * Created by le on 2017/3/19.
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。
 * 你可以假设在数组中无重复元素。
 * [1,3,5,6]，5 → 2
 * [1,3,5,6]，2 → 1
 * [1,3,5,6]， 7 → 4
 * [1,3,5,6]，0 → 0
 */
public class SearchInsertTest {

    public static void main(String[] args) {

        int[] A = new int[]{1, 10, 1001, 201, 1001, 10001, 10007};
        searchInsert(A, 10008);

    }

    public static int searchInsert(int[] A, int target) {
        int start = 0;
        int end = A.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        //结束循环时start肯定大于等于end   不管target应该插入头部还是尾部都应该取相应大的值
        //当插入头部时start为0 end为-1   当插入尾部时start为A.length end为A.length-1
        return start;
    }

}
