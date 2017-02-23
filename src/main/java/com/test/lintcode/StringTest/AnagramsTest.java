package com.test.lintcode.StringTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by le on 2017/2/23.
 * 给出一个字符串数组S，找到其中所有的乱序字符串(Anagram)。
 * 如果一个字符串是乱序字符串，那么他存在一个字母集合相同，但顺序不同的字符串也在S中。
 * 对于字符串数组 ["lint","intl","inlt","code"]
 * 返回 ["lint","inlt","intl"]
 */
public class AnagramsTest {

    public static void main(String[] args) {
        String[] strs = new String[2];
        strs[0]="";
        strs[1]="";

        anagrams(strs);

    }

    public static List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        List<Integer> exists = new ArrayList();
        boolean first = true;
        for(int i=0;i<strs.length;i++){
            if(exists.contains(i)){
                continue;
            }
            for(int j=i+1;j<strs.length;j++){
                if(AnagramTest.anagram2(strs[i],strs[j])){
                    if(first){
                        result.add(strs[i]);
                        first = false;
                    }
                    result.add(strs[j]);
                    exists.add(j);
                }

            }
            first=true;
        }
        return result;
    }
}
