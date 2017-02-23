package com.test.lintcode.StringTest;

import java.util.Arrays;

/**
 *
 * 写出一个函数 anagram(s, t) 判断两个字符串是否可以通过改变字母的顺序变成一样的字符串。
 * Created by le on 2017/2/19.
 *
 */
public class AnagramTest {

    public static void main(String[] args) {
        System.out.println(anagram2("",""));
    }

    public static boolean anagram(String s, String t) {
        if(s==null || t==null || s.length()!=t.length())return false;
        else {
            char[] ss = s.toCharArray();
            char[] ts = t.toCharArray();
            Arrays.sort(ss);
            Arrays.sort(ts);
            for (int i=0;i<ss.length;i++){
                if(ss[i] != ts[i]) return false;
            }
        }
        return true;
    }

    public static boolean anagram2(String s,String t){
        //初始化26个字母数组 数组初始默认都是0   每一位代表一个字母字符
        int [] ints = new int[26];
        if(s==null || t==null || s.length()!=t.length()) return  false;
        else{
            char[] ss = s.toCharArray();
            char[] ts = t.toCharArray();

            //记录每一位（字母字符）出现次数
            for(int i=0;i<ss.length;i++){
                ints[ss[i] - 'a']++;
            }
            for(int i=0;i<ts.length;i++){
                ints[ts[i] - 'a']--;
            }
            for(int i=0;i<ints.length;i++){
                if(ints[i]!=0) return false;
            }

        }

        return true;
    }
}
