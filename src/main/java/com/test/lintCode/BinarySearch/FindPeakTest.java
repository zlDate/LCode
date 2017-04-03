package com.test.lintCode.BinarySearch;

/**
 * Created by le on 2017/3/19.
 * 75 寻找峰值
 * 你给出一个整数数组(size为n)，其具有以下特点：
 * 相邻位置的数字是不同的
 * A[0] < A[1] 并且 A[n - 2] > A[n - 1]
 * 假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置
 * 给出数组[1, 2, 1, 3, 4, 5, 7, 6]返回1, 即数值 2 所在位置, 或者6, 即数值 7 所在位置.
 * <p>
 * 使用二分查找来寻找  只要大于两边的值则这个位置就是峰值
 * 先从中间开始比较   如果不是峰值 则取上坡的一段继续二分比较必定会有峰值
 */
public class FindPeakTest {

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 10, 9, 5, 9, 5, 9, 5, 10, 9, 8, 7, 5};

        System.out.println(findPeak(A));

    }

    public static int findPeak(int[] A) {
        int start = 0;
        int end = A.length;
        //如果不带=则最后退出循环时start=end 且一定在峰值  最后返回start
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == 0) {
                start++;
                continue;
            }
            if (mid == A.length) {
                end--;
                continue;
            }
            if (A[mid] > A[mid - 1]) {
                if (A[mid] > A[mid + 1]) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else {
                end = mid - 1;
            }
        }
        //如果收敛条件不带= 则返回start
        return 0;
    }

}
