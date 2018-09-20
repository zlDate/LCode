package com.test.lintcode.greedy;

/**
 * Created by le on 2017/4/13.
 * 82 落单的数
 * 给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 */
public class SingleNumberTest {

    //相同的数异或等于0,到最后结果一定是落单的数
    public int singleNumber(int[] A) {
        int result=0;
        for(int i=0;i<A.length;i++){
            result ^= A[i];
        }
        return result;
    }

    //将每个数转换成32位二进制数 将位上的数求和  最后每位上的数 %2 结果得到落单的数
    public int singleNumber2(int[] A) {
        int[] results = new int[32];
        for(int i=0;i<A.length;i++){
            String tmp = intToBinaryString(A[i]);
            for(int j=0;j<32;j++){
                results [j] = results[j] + tmp.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<32;i++){
            sb.append(results[i]%2);
        }
        return binaryStringToInt(sb.toString());
    }

    private static String intToBinaryString(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append(num >> (31 - i) & 1);
        }
        return sb.toString();
    }
    //带符号位二进制字符串转换成int数
    private static int binaryStringToInt(String binaryString) {
        char sign = binaryString.charAt(0);
        if (sign == '0') {
            return Integer.parseInt(binaryString, 2);
        } else {  //负数
            //将除符号位的数求反+1得到绝对值
            StringBuilder numBinaryString = new StringBuilder();
            for (int i = 1; i < binaryString.length(); i++) {
                if (binaryString.charAt(i) == '0') {
                    numBinaryString.append('1');
                } else {
                    numBinaryString.append('0');
                }
            }
            return 0 - (Integer.parseInt(numBinaryString.toString(), 2) + 1);
        }
    }
}
