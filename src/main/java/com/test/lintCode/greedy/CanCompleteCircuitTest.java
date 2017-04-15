package com.test.lintCode.greedy;

/**
 * Created by le on 2017/4/15.
 * 187 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油gas[i]，并且从第_i_个加油站前往第_i_+1个加油站需要消耗汽油cost[i]。
 * 你有一辆油箱容量无限大的汽车，现在要从某一个加油站出发绕环路一周，一开始油箱为空。
 * 求可环绕环路一周时出发的加油站的编号，若不存在环绕一周的方案，则返回-1
 *
 * 现在有4个加油站，汽油量gas[i]=[1, 1, 3, 1]，
 * 环路旅行时消耗的汽油量cost[i]=[2, 2, 1, 1]。
 * 则出发的加油站的编号为2。。
 */
public class CanCompleteCircuitTest {

    public static void main(String[] args) {
        int[] gas = new int[]{2,1,1,3};
        int[] cost = new int[]{1,3,1,1};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    //从头开始遍历 只要汽油量能到下一个站就能一直下去  不行就从下一个点开始
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++){
            //汽油剩余量
            int gasRemain = 0;
            //当前站
            int station = i;
            //跑了几站
            int count=0;
            for(int j=0;j<gas.length;j++){
                //加油
                gasRemain += gas[station];
                //耗油
                gasRemain -= cost[station];
                //油耗不够，从新开始
                if(gasRemain<0){
                    break;
                }
                station++;
                //环路
                if(station==gas.length){
                    station=0;
                }
                count++;
            }
            if(count==gas.length){
                return i;
            }
        }
        return -1;
    }

    public static int canCompleteCircuit2(int[] gas, int[] cost){
        int start = 0;
        int tmp = 0;
        int totalGas = 0;
        int totalCost = 0;
        for(int i=0;i<gas.length;i++){
            tmp += gas[i];
            tmp -= cost[i];
            totalGas += gas[i];
            totalCost += cost[i];
            //当油耗不够时 从当前站的下一站开始  前面已经计算过的站不用从新计算一遍
            if(tmp<0){
                start = i+1;
                tmp=0;
            }
        }
        //只要总油耗不小于总消耗  一定能跑完
        if(totalGas>=totalCost){
            return start;
        }
        return -1;
    }

}
