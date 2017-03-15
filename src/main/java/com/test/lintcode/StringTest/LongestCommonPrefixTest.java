package com.test.lintcode.StringTest;

/**
 * Created by le on 2017/2/24.
 * 给k个字符串，求出他们的最长公共前缀(LCP)
 *
 * 在 "ABCD" "ABEF" 和 "ACEF" 中,  LCP 为 "A"
 * 在 "ABCDEFG", "ABCEFG", "ABCEFA" 中, LCP 为 "ABC"
 */
public class LongestCommonPrefixTest {

    public static void main(String[] args) {
        String[] strs = new String[]{"ABCDEFG","ABCEFG","ABCEFA"};
        System.out.println(longestCommonPrefix2(strs));
    }

    //1691  1808  1853
    public static String longestCommonPrefix(String[] strs) {
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

    public static String longestCommonPrefix2(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];
        //找出长度最短的字符串   有一样短的随便选一个
        String shortest=strs[0];
        for(String str:strs){
            if(shortest.length()>str.length())shortest = str;
        }

        int length = 0;
        boolean flag=true;
        for(int i=0;i<shortest.length();i++){
            int index = 0;
            char tmp = shortest.charAt(i);

            for(int j=0;j<strs.length;j++){
                if(tmp!=strs[j].charAt(i)){
                    break;
                }else index++;

            }

            if(index!=strs.length) {
                length= i;
                flag=false;
                break;
            }

        }

        String result = flag?shortest.substring(0,length+1):shortest.substring(0,length);

        return result;
    }

}
