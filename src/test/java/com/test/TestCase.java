package com.test;

import org.junit.Test;

import java.util.*;

/**
 * Created by le on 2017/8/15.
 */
public class TestCase {

    @Test
    public void a(){
        System.out.println(letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

    @Test
    public void b(){
        Map<List,String> map = new HashMap<>();
        List l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        List l2 = new ArrayList<>();
        l2.add(1);
//        l2.add(2);
        map.put(l1,"a");
        map.put(l2,"b");
        System.out.println(map.size());


    }

    @Test
    public void c(){
        Set<Character> set = new HashSet<>();
        System.out.println(set.add('a'));
        System.out.println(set.add('a'));
        System.out.println(set.add('b'));

    }

}
