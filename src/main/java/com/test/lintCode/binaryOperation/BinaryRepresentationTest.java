package com.test.lintCode.binaryOperation;

/**
 * Created by le on 2017/4/12.
 * 180 二进制表示
 * 给定一个数将其转换为二进制（均用字符串表示），如果这个数的小数部分不能在 32 个字符之内来精确地表示，则返回 "ERROR"。
 * n = "3.72", 返回 "ERROR"
 * n = "3.5", 返回 "11.1"
 */
public class BinaryRepresentationTest {

    public static void main(String[] args) {

        binaryRepresentation("0.5");
    }


    private static String binaryRepresentation(String n) {
        StringBuilder result = new StringBuilder();
        String[] ns = n.split("\\.");
        //整数部分
        long num = Integer.parseInt(ns[0]);
        if(num!=0){
            int count = 32;
            if (num > Integer.MAX_VALUE) count = 64;
            for (int i = count - 1; i >= 0; i--) {
                result.append((num >> i) & 1);
            }
        }else{
            result.append(0);
        }
        //小数部分
        if (ns.length >= 2) {
            double decimal = Double.parseDouble(ns[1]);
            decimal = decimal * Math.pow(10, -1 * ns[1].length());
            if(decimal!=0){
                result.append(".");
            }
            int i=0;
            while (decimal!=0 && i<=32) {
                decimal *= 2;
                if(decimal>=1){
                    result.append(1);
                    decimal -= 1;
                }else {
                    result.append(0);
                }
                i++;
            }
            if(i==33){
                return "ERROR";
            }
        }
        //去掉整数前面的0
        if(num!=0){
            int i=0;
            while (result.charAt(i)=='0'){
                i++;
            }
            return result.toString().substring(i,result.length());
        }
        return result.toString();
    }

}