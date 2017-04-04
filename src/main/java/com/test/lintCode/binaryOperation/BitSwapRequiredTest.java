package com.test.lintCode.binaryOperation;

/**
 * Created by le on 2017/3/22.
 * 181 将整数A转换成B
 * 如果要将整数A转换为B，需要改变多少个bit位
 * 如把31转换为14，需要改变2个bit位。
 * (31)10=(11111)2
 * (14)10=(01110)2
 * 异或运算 计算结果中有多少1就是要改变的bit位数
 */
public class BitSwapRequiredTest{

    public static void main(String[] args) {

//        bitSwapRequired2(31,14);

        String[] strs = "1000".split("1");

        System.out.println("1234".charAt(4));



    }


    private static int bitSwapRequired(int a, int b) {
        int count = 0;
        for(int i=a^b;i!=0;i>>>=1){
            count += i&1;
        }
        return count;
    }

    private static int bitSwapRequired2(int a, int b) {
        int num = a^b;
        String x = Integer.toBinaryString(num);
        int count = 0;
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }

}
