package com.test.lintcode.BinarySearch;

/**
 * Created by le on 2017/3/19.
 * 28 搜索二维矩阵
 * 写出一个高效的算法来搜索 m × n矩阵中的值。
 * 这个矩阵具有以下特性：
 * 每行中的整数从左到右是排序的。
 * 每行的第一个数大于上一行的最后一个整数。
 * [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * 给出 target = 3，返回 true
 */
public class SearchMatrixTest {

    public static void main(String[] args) {

        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(searchMatrix(nums, 9));


    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int start = 0;
        int end = matrix[0].length * matrix.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int element = getElement(matrix, mid);
            if (element < target) {
                start = mid + 1;
            } else if (element > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    //将二维数组看成一个数组   返回mid处索引的元素
    private static int getElement(int[][] matrix, int mid) {
        //行号
        int line = mid / matrix[0].length;
        //列号
        int row = mid - line * (matrix[0].length);
        return matrix[line][row];
    }

}
