package com.test.lintcode.greedy;

/**
 * Created by le on 2017/4/16.
 * 182 删除数字
 * 给出一个字符串 A, 表示一个 n 位正整数, 删除其中 k 位数字, 使得剩余的数字仍然按照原来的顺序排列产生一个新的正整数。
 * 找到删除 k 个数字之后的最小正整数。
 * N <= 240, k <= N
 * 给出一个字符串代表的正整数 A 和一个整数 k, 其中 A = 178542, k = 4
 * 返回一个字符串 "12"
 */
public class DeleteDigitsTest {
    public static void main(String[] args) {

        System.out.println("0".substring(1,1));

    }

    /**
     * 贪心法  每次选取第一个出现的最小的字符拼接出来就是最小的数
     * @param A
     * @param k
     * @return
     */
    public static String DeleteDigits(String A, int k) {
        StringBuilder sb = new StringBuilder();
        int minIndex=-1;
        //循环次数 和结果字符串长度相等
        for(int i=0;i<A.length()-k;i++){
            //从上一个最小的索引+1处从新开始
            char min = A.charAt(minIndex+1);
            minIndex = minIndex+1;
            //第二层循环寻找第一个最小字符  从上一个最小字符索引+1开始一直到遍历到剩下的至少能构成结果处
            //假设j最大处索引为x，则  A.length-x = A.length-k-i(结果剩余长度) ===》x=k+i
            for(int j=minIndex+1;j<=k+i;j++){
                if(min>A.charAt(j)){
                    min = A.charAt(j);
                    minIndex=j;
                }
            }
            sb.append(min);
        }
        //去掉前面的0
        String result = sb.toString();
        while (result.charAt(0)=='0'){
            result = result.substring(1,result.length());
        }
        return result;
    }

}
