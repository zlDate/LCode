package com.test.lintcode.binaryOperation;

/**
 * Created by le on 2017/4/10.
 * 140 快速幂
 * 计算a^n % b  其中a、b和n都是32位的整数
 * 2^31 % 3 =2
 * 100^1000 % 1000 = 0
 * (a * b) % p = (a % p * b % p) % p
 * 所以 a^n % b = (a^n/2 % b)*(b^n/2 % b) % b
 */
public class FastPowerTest {

    public int fastPower(int a, int b, int n) {
        if(n==0) return 1%b;
        if(n==1) return a%b;
        long tmp = fastPower(a,b,n/2);
        long result = (tmp*tmp)%b;
        //如果n是基数  a^n = a^(n-1)*a;
        if(n%2==1){
            result = (result*(a%b))%b;
        }
        return (int) result;
    }

}
