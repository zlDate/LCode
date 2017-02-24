package com.test.lintcode.StringTest;

/**
 * Created by le on 2017/2/24.
 * 给k个字符串，求出他们的最长公共前缀(LCP)
 *
 * 在 "ABCD" "ABEF" 和 "ACEF" 中,  LCP 为 "A"
 * 在 "ABCDEFG", "ABCEFG", "ABCEFA" 中, LCP 为 "ABC"
 */
public class LongestCommonPrefixTest {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        //找出长度最短的字符串   有一样短的随便选一个
        String shortest=strs[0];
        for(String str:strs){
            if(shortest.length()>str.length())shortest = str;
        }

        int index = 0;
        for(int i=shortest.length();i>0;i--){
            String prefix = shortest.substring(0,i);
            for(String str:strs){
                if(!str.startsWith(prefix)) break;
                else index++;
            }
            if(index==strs.length) return prefix;
            index=0;
        }
        return "";
    }

}
