package com.test.lintcode.binaryOperation;

/**
 * Created by le on 2017/4/4.
 * 2 尾部的0
 * 设计一个算法 计算出n阶乘中尾部0的个数
 * 11！=39916800  返回2
 * http://m.blog.csdn.net/article/details?id=51168272
 */
public class TrailingZerosTest {

    public static void main(String[] args) {

        trailingZeros(105);

    }

    /**
     * 因式分解每个0都是由5和偶数相称所得 而且5的增长速度要慢于偶数 所以直接判断5的个数
     * 每有一个5就多一个0
     * @param n
     * @return
     * 时间复杂度太高
     */
    public static long trailingZeros(long n){
        long count = 0;
        long multiple;
        for(int i=5;i<=n;i+=5){
            count++;
            multiple = 25;
            //25=5*5 50=5*5*2 计算有多少个5 一个5前面已经+1了所以以5*5为基数
            while (i%multiple==0){
                count++;
                multiple *= 5;
            }
        }
        return count;
    }

    /**
     * 核心思想还是因数分解后统计5的个数
     * 将n-1中5的倍数提出来  5、10、15、20、25、50...=5*(1、2、3、4、5、6...)
     * 括号中有多少个数就有多少个5，然后将括号中的数接着提取5的倍数
     * @param n
     * @return
     */
    public static long trailingZeros2(long n){
        long count = 0;
        //计算有多少个5的倍数
        long tmp = n/5;
        while (tmp!=0){
            count += tmp;
            tmp /=5;
        }
        return count;
    }


}
