package com.test.lintcode.greedy;

/**
 * Created by le on 2017/4/17.
 * 116 跳跃游戏
 * 给出一个非负整数数组，你最初定位在数组的第一个位置。　　　
 * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。
 * 判断你是否能到达数组的最后一个位置。
 * 注意事项
 * 这个问题有两个方法，一个是贪心和 动态规划。
 * 贪心方法时间复杂度为O（N）。
 * 动态规划方法的时间复杂度为为O（n^2）。
 * 我们手动设置小型数据集，使大家阔以通过测试的两种方式。
 * 这仅仅是为了让大家学会如何使用动态规划的方式解决此问题。
 * 如果您用动态规划的方式完成它，你可以尝试贪心法，以使其再次通过一次。
 *
 * A = [2,3,1,1,4]，返回 true.
 * A = [3,2,1,0,4]，返回 false.
 */
public class CanJumpTest {

    public boolean canJump(int[] A) {
        int maxN = 0;   //记录能走的最大步数
        int i=0;        //记录当前走到第几个元素
        while (i<=maxN){
            maxN = Math.max(maxN,i+A[i]);   //更新能走的最大步数
            i++;                            //每次走一步
            if(maxN>=A.length-1){   //如果能走的最大步数比最后元素的索引还大 返回true
                return true;
            }
        }
        return false;
    }
}
