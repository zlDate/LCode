package com.test.lintcode.sort;

/**
 * Created by le on 2017/3/14.
 * 归并排序
 * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
 * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 */
public class MergeSortTest {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 20, 15, 0, 6, 7, 2, 1, -5, 55};

        mergeSort(nums, 0, nums.length - 1);

        System.out.println(nums.length);
    }

    //将数组分成两半  然后分别递归调用
    private static void mergeSort(int[] nums, int start, int end) {
        int mid = (end + start) / 2;
        if (start < end) {
            mergeSort(nums, start, mid);  //左边数组
            mergeSort(nums, mid + 1, end);  //右边数组
            merge(nums, start, mid, end);
        }


    }

    //将数组a按从start到mid和从mid到end排序  假定start到mid和mid到end都是有序的
    private static void merge(int[] a, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start;  //左边数组指针  包含mid
        int j = mid + 1;  //右边数组指针
        int k = 0;      //临时数组指针

        //归并左右两边数组
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        //左数组多余的填充tmp
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        //右数组多余的填充tmp
        while (j <= end) {
            tmp[k++] = a[j++];
        }
        //将排好序的tmp回填至a
        for (int x = 0; x < tmp.length; x++) {
            a[start + x] = tmp[x];
        }
    }
}
