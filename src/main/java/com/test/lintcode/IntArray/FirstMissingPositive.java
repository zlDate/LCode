package com.test.lintcode.IntArray;

import java.util.Arrays;

/**
 * Created by le on 2017/3/2.
 * 给出一个无序的正数数组，找出其中没有出现的最小正整数。
 * 如果给出 [1,2,0], return 3
 * 如果给出 [3,4,-1,1], return 2
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] A = new int[]{1,1};
        firstMissingPositive(A);

    }

    public static int firstMissingPositive(int[] A) {
        if(A.length==0) return 1;
        Arrays.sort(A);
        int index = 1;
        for(int i=0;i<A.length;i++){
            if(A[i]>0){
                if(A[i]>index){
                    return index;
                }else if(A[i]==index){
                    index++;
                }
            }
        }
        return index;
    }

}
