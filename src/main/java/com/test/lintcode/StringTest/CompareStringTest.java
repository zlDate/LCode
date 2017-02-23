package com.test.lintcode.StringTest;

/**
 * Created by le on 2017/2/21.
 * 比较两个字符串A和B，确定A中是否包含B中所有的字符。字符串A和B中的字符都是 大写字母
 * 在 A 中出现的 B 字符串里的字符不需要连续或者有序。
 *  样例
 给出 A = "ABCD" B = "ACD"，返回 true
 给出 A = "ABCD" B = "AABC"， 返回 false

 */
public class CompareStringTest {

    public static void main(String[] args) {
        System.out.println(CompareString("ABCS","ABSC"));
    }


    public static boolean CompareString(String A,String B){

        if (A==null || B==null || A.length()<B.length()) return false;

        char[] as = A.toCharArray();
        char[] bs = B.toCharArray();

        int[] ints = new int[26];
        for(int i=0;i<as.length;i++){
            ints[as[i]-'A']++;

        }

        for(int i=0;i<bs.length;i++){
            ints[bs[i]-'A']--;
        }
        for(int i=0;i<ints.length;i++){
            if(ints[i]<0) return false;
        }
        return true;
    }

}
