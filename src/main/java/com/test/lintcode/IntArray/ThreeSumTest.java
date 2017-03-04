package com.test.lintcode.IntArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by le on 2017/3/4.
 * 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
 * 在三元组(a, b, c)，要求a <= b <= c。 结果不能包含重复的三元组。
 * 如S = {-1 0 1 2 -1 -4}, 你需要返回的三元组集合的是：(-1, 0, 1) (-1, -1, 2)
 */
public class ThreeSumTest {

    public static void main(String[] args) {
        int[] numbers = new int[]{-2,-3,5,-1,-4,5,-11,7,1,2,3,4,-7,-1,-2,-3,-4,-5};
        threeSum(numbers);

    }

    //1053ms
    public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        Map<Integer,Integer> map;
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length;i++){
            map = new HashMap<>();
            //在i后面寻找和为-number[i]的两个元素
            for(int j=i+1;j<numbers.length;j++){
                if(map.containsKey(-numbers[i]-numbers[j])){
                    ArrayList<Integer> temp = new ArrayList<>();
                    //按顺序加入
                    temp.add(numbers[i]);
                    temp.add(map.get(-numbers[i]-numbers[j]));
                    temp.add(numbers[j]);
                    if(!isRepeat(result,temp)) {
                        result.add(temp);
                    }
                }

                map.put(numbers[j],numbers[j]);

            }
        }
        return result;
    }

    //判断是否是重复的结果
    private static boolean isRepeat(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list){
        for(int i=0;i<result.size();i++){
            ArrayList<Integer> temp = result.get(i);
            if(temp.get(0)==list.get(0) &&
                    temp.get(1)==list.get(1)){
                return true;
            }
        }
        return false;
    }

}
