package com.test.lintCode.StringTest;

/**
 * Created by le on 2017/2/24.
 * 54 转换字符串到整数
 * 实现atoi这个函数，将一个字符串转换为整数。如果没有合法的整数，返回0。
 * 如果整数超出了32位整数的范围，返回INT_MAX(2147483647)如果是正整数，或者INT_MIN(-2147483648)如果是负整数
 * "10" =>10
 * "-1" => -1
 * "123123123123123" => 2147483647
 * "1.0" => 1
 */
public class AtoiTest {

    public static void main(String[] args) {
//        int a = -2147483648;
//        double i = 2147483647.0;
//        System.out.println((int)i*-1);

        atoi("-0");

    }

    public static int atoi(String str) {
        //去除空格
        str = str.trim();
        if(str.length()==0) return 0;
        //去除小数点后面的0
        if(str.contains(".")){
            int d = str.indexOf(".");
            for(int i=d+1;i<str.length();i++){
                if(str.charAt(i)!='0') return 0;
            }
            str = str.substring(0,d);
        }
        int index = 0;  //字符串索引
        boolean flag = true;    //正负数
        char sign = str.charAt(index);
        //判断正负
        if(sign=='-'){
            flag = false;
            index++;
        }else if(sign == '+'){
            index++;
        }
        //去除前面的0
        while(index < str.length() && str.charAt(index)=='0'){
            index++;
        }
        double sum = 0; //返回的值
        while (index<str.length()){
            char current = str.charAt(index);
            if(current>='0' && current<='9'){
                sum = sum*10 + (int)(current-'0');
                index++;
            }else index = str.length();
        }
        if(flag){
            if(sum<2147483647.0) return (int) sum;
            else return Integer.MAX_VALUE;
        }else{
            if(sum<2147483648.0) return (int) sum*(-1);
            else return Integer.MIN_VALUE;
        }
    }

}
