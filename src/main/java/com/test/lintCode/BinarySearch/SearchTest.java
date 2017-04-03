package com.test.lintCode.BinarySearch;

/**
 * Created by le on 2017/3/20.
 * 62 搜索旋转排序数组
 * 假设有一个排序的按未知的旋转轴旋转的数组(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。
 * 给定一个目标值进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1。
 * 你可以假设数组中不存在重复的元素。
 * 给出[4, 5, 1, 2, 3]和target=1，返回 2
 * 给出[4, 5, 1, 2, 3]和target=0，返回 -1
 *
 */
public class SearchTest {

    public static void main(String[] args) {
        int[] A = new int[]{0,1,2,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1};
        search(A,-9);

    }

    public static int search(int[] A, int target) {
        int start = 0;
        int end = A.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(A[mid]==target){
                return mid;
            }else if(A[mid]<target){
                //当target大于A[mid]分三种情况
                // 1 2 3 mid target 6 7  -1 0  搜右边
//                if(A[mid]>A[0]){
//                    start = mid+1;
//                }
                //4 5 6 0 mid taret 3     搜右边
//                if(A[mid]<A[A.length-1] && target<A[A.length-1]){
//                    start = mid+1;
//                }
                //4 5 target 7 8 1 mid 3   搜左边
                if(A[mid]<A[0] && target>A[A.length-1]){  //当且仅当数组最小的元素在中间 target在大的一边 mid在小的一边
                    end = mid-1;
                }else{
                    start = mid + 1;
                }
            }else{
                // 1 2 target 4 mid 6 7   搜左边
                // 5  6  7  1 target mid 3  搜左边
                //  5  6  7  mid   1  target  3  4   搜右边
                if(A[mid]>A[A.length-1] && target<A[0]){    //当且仅当数组最小元素在中间 target在小的一边 mid在大的一边
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }

}
