package com.test.lintcode.BinarySearch;

/**
 * Created by le on 2017/3/19.
 * 计算并返回x的平方根
 * sqrt(3) = 1
 * sqrt(4) = 2
 * sqrt(5) = 2
 * sqrt(10) = 3
 */
public class SqrtTest {

    public static void main(String[] args) {
        sqrt(4187);
    }

    public static int sqrt(int x) {
        if (x <= 1) return x;
        int start = 1;
        int end = x - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //不能使用mid*mid 会溢出
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        //最后结束while时一定是end<start 所以返回end
        return end;
    }

}
