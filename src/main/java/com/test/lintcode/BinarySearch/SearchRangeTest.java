package com.test.lintcode.BinarySearch;

/**
 * Created by le on 2017/3/21.
 * 61 搜索区间
 * 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。
 * 如果目标值不在数组中，则返回[-1, -1]
 * 给出[5, 7, 7, 8, 8, 10]和目标值target=8,
 * 返回[3, 4]
 */
public class SearchRangeTest {

    public static void main(String[] args) {
        int[] A = new int[]{1};

        searchRange(A,1);

    }

    public static int[] searchRange(int[] A, int target) {
        //搜寻第一个target出现的位置
        int firstStart = 0;
        int firstend = A.length-1;
        //搜寻最后一个target出现的位置
        int lastStart = 0;
        int lastEnd = A.length-1;
        //target第一个和最后一个索引
        int firstIndex=-1;
        int lastIndex=-1;
        while(firstStart<=firstend || lastStart<=lastEnd){
            //搜索第一个target
            if(firstStart<=firstend){
                int firstMid = firstStart+(firstend-firstStart)/2;
                if(A[firstMid]<target){
                    firstStart = firstMid+1;
                }else if(A[firstMid]>target){
                    firstend = firstMid-1;
                }else {
                    firstIndex = firstMid;      //记录出现位置
                    firstend = firstMid-1;    //在左边继续搜索
                }
            }
            //搜索最后一个target
            if(lastStart<=lastEnd){
                int lastMid;
                if((lastEnd-lastStart)%2==0){
                    lastMid = lastStart+(lastEnd-lastStart)/2;
                }else {
                    lastMid = lastStart+(lastEnd-lastStart+1)/2;
                }
                if(A[lastMid]<target){
                    lastStart = lastMid+1;
                }else if(A[lastMid]>target){
                    lastEnd = lastMid-1;
                }else {
                    lastIndex = lastMid;        //记录出现位置
                    lastStart = lastMid+1;    //在右边继续搜索
                }
            }
        }
        return new int[]{firstIndex,lastIndex};
    }

}
