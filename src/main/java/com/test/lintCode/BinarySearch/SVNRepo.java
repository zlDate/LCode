package com.test.lintcode.BinarySearch;

import java.util.Random;

/**
 * Created by le on 2017/3/20.
 */
public class SVNRepo {

    //版本总数
    private static Integer n;
    //第一个开始坏的版本 x随机产生 不确定因素
    private static Integer x;

    public SVNRepo(Integer n) {
        x = new Random().nextInt(n)+1;
    }

    public static boolean isBadVersion(int k){
        if(k>=1) return true;
        return false;
    }

}
