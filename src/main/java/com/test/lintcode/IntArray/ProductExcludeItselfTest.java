package com.test.lintcode.IntArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by le on 2017/2/26.
 * 给定一个整数数组A。
 * 定义B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]， 计算B的时候请不要使用除法。
 * 给出A=[1, 2, 3]，返回 B为[6, 3, 2]
 *
 * left[i] : 用来表示A[i]左边元素的乘积，不包括A[i].
 * right[i] : 用来表示A[i]右边元素的乘积，不包括A[i].
 * 则： B[i] = left[i] * right[i];
 */
public class ProductExcludeItselfTest {
    public static void main(String[] args) {
        int[] a = new int[]{0,0,9,9,1,2,3,4,901,55};
        ArrayList A = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            A.add(a[i]);
        }
        productExcludeItself(A);
    }

    public static ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> B = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            long left = 1;
            int indexLeft=i-1;
            while (indexLeft>=0){
                left = left*A.get(indexLeft);
                indexLeft--;
            }

            long right = 1;
            int indexRight = i+1;
            while(indexRight<A.size()){
                right = right*A.get(indexRight);
                indexRight++;
            }

            B.add(i,left*right);
        }
        return B;
    }

}
