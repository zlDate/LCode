package com.test.lintcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by le on 2017/4/15.
 * 184 最大数
 * 给出一组非负整数，重新排列他们的顺序把他们组成一个最大的整数。
 * 给出 [1, 20, 23, 4, 8]，返回组合最大的整数应为8423201。
 */
public class LargestNumberTest {
    public static void main(String[] args) {
        int[] num = new int[]{1,20,23,4,8};
//        System.out.println(largestNumber(num));

        System.out.println("232".compareTo("2023"));
    }

    public static String largestNumber(int[] num) {
        for (int i = 1; i < num.length; i++) {
            int tmp = num[i];
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (maxPosition(tmp, num[j])) {
                    swap(num, index, j);
                    index--;
                } else break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num.length;i++){
            sb.append(num[i]);
        }
        if(sb.toString().charAt(0)=='0'){
            return "0";
        }
        return sb.toString();
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    /**
     * 比较两个数谁应该在前面   直接比较两种结果 从最高位开始
     * 注意  [20,203]   [20,201]
     * @param a
     * @param b
     * @return 如果a在前面返回true b在前面返回false
     */
    private static boolean maxPosition(int a, int b) {
        String A = "" + a + b;
        String B = "" + b + a;
        //compareTo方法会依次比较A、B中每个字符的unicode值  大于0表示A大
        if(A.compareTo(B)>0){
            return true;
        }
        return false;
    }

    //
    public static String largestNumber2(int[] num){
        String[] strNum = new String[num.length];
        for(int i=0;i<num.length;i++){
            strNum[i] = num[i]+"";
        }
        Arrays.sort(strNum,new StringComparator());
        if(strNum[0].charAt(0)=='0'){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strNum.length;i++){
            sb.append(strNum[i]);
        }
        return sb.toString();
    }
}
//定义字符串比较器  倒序比较
class StringComparator implements Comparator<String>{
    //如果o1大于o2 返回负数
    @Override
    public int compare(String o1, String o2) {
        return (o2+o1).compareTo(o1+o2);
    }
}