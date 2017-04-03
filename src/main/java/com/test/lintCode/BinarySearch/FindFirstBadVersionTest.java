package com.test.lintCode.BinarySearch;

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * Created by le on 2017/3/20.
 * 74 第一个错误的代码版本
 * 代码库的版本号是从 1 到 n 的整数。某一天，有人提交了错误版本的代码，
 * 因此造成自身及之后版本的代码在单元测试中均出错。请找出第一个错误的版本号。
 * 你可以通过 isBadVersion 的接口来判断版本号 version 是否在单元测试中出错，具体接口详情和调用方法请见代码的注释部分。
 * 给出 n=5
 * 调用isBadVersion(3)，得到false
 * 调用isBadVersion(5)，得到true
 * 调用isBadVersion(4)，得到true
 * 此时我们可以断定4是第一个错误的版本号
 *
 */
public class FindFirstBadVersionTest {

    public static void main(String[] args) {

        findFirstBadVersion(31);
    }

    public static int findFirstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start<end){
            int mid = start + (end-start)/2;
            if(SVNRepo.isBadVersion(mid)){
                if(!SVNRepo.isBadVersion(mid-1)){
                    return mid;
                }
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

}
