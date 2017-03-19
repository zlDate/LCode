package com.test.lintcode.IntArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by le on 2017/2/25.
 * 172 删除元素
 * 给定一个数组和一个值，在原地删除与值相同的数字，返回新数组的长度。
 * 元素的顺序可以改变，并且对新的数组不会有影响。
 * 给出一个数组 [0,4,4,0,0,2,4,4]，和值 4
 * 返回 4 并且4个元素的新数组为[0,0,0,2]
 */
public class RemoveElementTest {

    public int removeElement(int[] A, int elem) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            if(A[i]!=elem) list.add(A[i]);
        }
        for(int i=0;i<list.size();i++){
            A[i] = list.get(i);
        }
        return list.size();
    }

}
