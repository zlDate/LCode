package com.test.lintcode.BinarySearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by le on 2017/3/21.
 * 183 木材加工
 * 有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为 k。
 * 当然，我们希望得到的小段越长越好，你需要计算能够得到的小段木头的最大长度`
 * 有3根木头[232, 124, 456], k=7, 最大长度为114
 *          2     1    4
 *  从某一值开始递减  直到数组中的每个元素除以这个值的商之和等于k
 *  可以确定最大长度一定小于等于 数组中每个元素除以k的商之和
 *  而且最大长度一定小于等于数组最大长度
 */
public class WoodCutTest {
    public static void main(String[] args) throws IOException {
        int[] L = new int[30000];
        BufferedReader br = new BufferedReader(new FileReader("G:\\ideaWorkspace\\LintCode\\src\\main\\resources\\2.in"));
        String tmp;
        while((tmp=br.readLine())!=null){
            String[] tmps = tmp.split(",");
            for(int i=0;i<tmps.length;i++){
                L[i] = Integer.valueOf(tmps[i]);
            }
        }
        br.close();
        woodCut(L,2500);
    }

    //如果取商的和来递减 最终结果应该是比较接近这个和的所以没有用二分
    public static int woodCut(int[] L, int k) {
        if(L.length==0) return 0;
        int quotientSum=0;
        int max=L[0];
        for(int i=0;i<L.length;i++){
            if(max<L[i]) max = L[i];
            quotientSum += L[i]/k;
        }
        //当所有的木材长度都小于k时quotientSum=0此时应该以最长木材长度递减
        if(quotientSum==0){
            quotientSum = max;
        }
        int maxK=0;
        while (quotientSum>0){
            maxK=0;
            for(int i=0;i<L.length;i++){
                maxK +=L[i]/quotientSum;
            }
            if(maxK>=k){
                break;
            }
            quotientSum--;
        }
        return quotientSum;
    }

}
