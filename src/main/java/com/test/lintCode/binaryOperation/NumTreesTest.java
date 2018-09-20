package com.test.lintcode.binaryOperation;

/**
 * Created by le on 2017/4/10.
 * 163 不同的二叉查找树
 * 给出n 问由1...n为节点组成的不同的二叉查找树有多少种
 * 考虑不管如何变换根节点不变 左右子树分别分剩下的数 0 n-1,1 n-2,2 n-3...n-1 0
 * 将左右子树的所有可能性相乘  即  f(0)*f(n-1),f(1)*f(n-2),f(2)*f(n-3)....f(n-2)*f(1),f(n-1)*f(0)
 * f(n)=f(0)*f(n-1)+f(1)*f(n-2)+f(2)*f(n-3)+...+f(n-2)*f(1)+f(n-1)*f(0)
 */
public class NumTreesTest {

    public static void main(String[] args) {
        System.out.println(numTrees(3));

    }


    public static int numTrees(int n) {
        if(n==0) return 1;
        if(n==1) return 1;
        int sum =0;
        for(int i=0;i<n/2;i++){
            sum += numTrees(i)*numTrees(n-1-i);
        }
        sum *= 2;
        if(n%2!=0){
            sum += numTrees(n/2)*numTrees(n/2);
        }
        return sum;
    }

}
