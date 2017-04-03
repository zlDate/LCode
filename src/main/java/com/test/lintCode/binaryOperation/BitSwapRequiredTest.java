package com.test.lintCode.binaryOperation;

/**
 * Created by le on 2017/3/22.
 * 181 将整数A转换成B
 * 如果要将整数A转换为B，需要改变多少个bit位
 * 如把31转换为14，需要改变2个bit位。
 * (31)10=(11111)2
 * (14)10=(01110)2
 */
public class BitSwapRequiredTest{

    public static void main(String[] args) {

        System.out.println(bitSwapRequired(1,2));
    }



    public static String bitSwapRequired(int a, int b) {
        String x = "a";
        try{
            x += "b";
            return x;
        }catch (Exception e){
            x += "d";
            return x;
        }finally {
            x+= "c";
        }
    }

}
