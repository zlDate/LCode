package com.test.lintcode.StringTest;

/**
 * Created by le on 2017/2/23.
 * 79 最长公共子串
 * 给出两个字符串，找到最长公共子串，并返回其长度。
 * 给出A=“ABCD”，B=“CBCE”，返回 2
 */
public class LongestCommonSubstringTest {

    public static void main(String[] args) {

        System.out.println("abcd".contains("b"));
    }

    public static int longestCommonSubstring(String A,String B){
        for(int i=B.length();i>0;i--){  //子串长度

            for(int j=0;j<B.length();j++){  //截取子串起点

                if(i+j>B.length()) break;

                String b = B.substring(j,j+i);  //截取子串

                if(A.contains(b)) return i;
            }
        }
        return 0;
    }


}
