package com.test.lintCode.binaryOperation;

/**
 * Created by le on 2017/4/4.
 * 142 O(1)时间检测2的幂次
 * 2的幂次数的二进制表示中 只有第一位是1其余全部为0
 * 1--1  2--10  4--100  8--1000 16-10000
 * 而2的幂次数-1后 除了第一位变为0其余位都是1
 * 两者与运算结果一定是0
 */
public class CheckPowerOf2Test {


    public boolean checkPowerOf2(int n){

        return n>0&&(n&(n-1))==0;
    }

}
