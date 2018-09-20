package com.test.lintcode.StringTest;

/**
 * Created by le on 2017/2/21.
 * 13 字符串查找
 * 对于一个给定的 source 字符串和一个 target 字符串，
 * 你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。
 * 如果不存在，则返回 -1。
 * KMP算法 o(n)
 * http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 */
public class strKmpTest {

    public static void main(String[] args) {

        System.out.println(kmp("tartarget","arget"));

    }

    //总耗时 1984 ms
    public static int strStr(String source, String target) {
        if(source==null || target==null || source.length()<target.length()) return -1;
        if(target.length()==0) return 0;

        char[] ss = source.toCharArray();

        for (int i=0;i<=ss.length-target.length();i++){
            if(ss[i]-target.charAt(0)==0){
                String x = source.substring(i,i+target.length());
                if(target.equals(x)) return i;
            }

        }
        return -1;
    }

    //kmp算法实现
    public static int kmp(String source, String target){
        if(source==null || target==null || source.length()<target.length()) return -1;
        if(target.length()==0) return 0;
        //求next数组  部分匹配表
        int[] next = new int[target.length()];
        for(int i=0;i<target.length();i++){
            next[i] = getMateValue(target.substring(0,i+1));
        }

        //算法实现
        char[] ss = source.toCharArray();
        char[] ts = target.toCharArray();
        int i = 0;
        int j = 0;
        while (i<ss.length){
            if(ss[i]==ts[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    i = i -j + j - next[j]; //j-next[j]为应该后移的位数
                }else{  //j=0表示与匹配串首字符不匹配  后移一位
                    i++;
                }
                j=0;
            }
            if(j==ts.length){
                return i-j;
            }
        }
        return -1;
    }

    //求字符串的部分匹配值    就是前缀和后缀的最长的共有元素长度  abcdefg
    private static int getMateValue(String str){
        for(int i=str.length()-1;i>0;i--){
            String head = str.substring(0,i);
            String tail = str.substring(str.length()-i,str.length());
            if(head.equals(tail)) return i;
        }
        return 0;
    }


    /**
     * TODO:BM算法实现
     * @param source
     * @param targer
     * @return
     */
    public static int bm(String source,String targer){


        return -1;
    }


}
