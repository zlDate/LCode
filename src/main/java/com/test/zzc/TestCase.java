package com.test.zzc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author le
 * @date 2018/5/9
 */
public class TestCase {

    public static int sumSubarrayMins2(Integer[] A) {
        final int MODULO = 1000000007;
        int length = A.length;
        List<int[]> stack = new ArrayList<int[]>();
        int curSum = 0;
        long res = 0;
        for (int i = 0; i < length; i++) {
            if (!stack.isEmpty() && A[i] >= stack.get(0)[0]) {
                curSum += A[i];
                int[] array = new int[2];
                array[0] = A[i];
                array[1] = 1;
                stack.add(0, array);
            } else {
                int count = 1;
                while (!stack.isEmpty() && stack.get(0)[0] > A[i]) {
                    count += stack.get(0)[1];
                    curSum -= stack.get(0)[1] * stack.get(0)[0];
                    stack.remove(0);
                }
                int[] array = new int[2];
                array[0] = A[i];
                array[1] = count;
                stack.add(0, array);
                curSum += count * A[i];
            }
            res += curSum;
        }
        return (int) (res % MODULO);
    }

    public static int sumSubarrayMins(Integer[] A) {
        int l = A.length;
        final int mod = 1000000007;
        long res = 0;
        List<Integer> tmpList = new ArrayList();
        for (int i=0;i<l;i++){
            tmpList.add(A[i]);
            res += sumSubarray(tmpList);
        }
        return (int)(res % mod);
    }

    private static long sumSubarray(List<Integer> list){
        int s = list.size();
        if (s==1){
            return list.get(0);
        }else{
            int minVal = list.get(s-1);
            long sum = minVal;
            for (int i = s-2;i>=0;i--){
                if (list.get(i)<minVal){
                    minVal = list.get(i);
                }
                sum += minVal;
            }
            return sum;
        }

    }

    public static void main(String[] args) throws IOException {
        List<Integer> list = readList();
        Integer[] ints = list.toArray(new Integer[]{});


        long t1 = new Date().getTime();
        System.out.println(sumSubarrayMins(ints));
        long t2 = new Date().getTime();
        System.out.println(t2-t1);

        System.out.println(sumSubarrayMins2(ints));
        long t3 = new Date().getTime();
        System.out.println(t3-t2);

    }

    private static List<Integer> readList() throws IOException {
        List<Integer> list=  new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("/Users/zengle/ideaWorkspace/java/LintCode/src/main/java/com/test/zzc/test"));
        String line;
        while ((line=br.readLine())!=null){
            list.add(Integer.parseInt(line));
        }
        br.close();
        return list;
    }

}
