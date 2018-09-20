package com.test.leetCode;

import java.util.HashMap;

/**
 * Created by le on 2017/7/15.
 */
public class TestLengthOfLongestSubstring {

    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");

    }


    private static int lengthOfLongestSubstring(String s){
        if (s.length()==0) return 0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        //i记录遍历位置的索引  j记录不重复的字母最近的索引   j保证当前计算的最长长度中没有重复的元素
        for (int i=0,j=0;i<s.length();++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }



}
