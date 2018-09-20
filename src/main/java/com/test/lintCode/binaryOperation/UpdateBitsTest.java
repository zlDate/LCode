package com.test.lintcode.binaryOperation;

/**
 * Created by le on 2017/4/5.
 * 179 更新二进制位
 * 给出两个32位的整数N和M，以及两个二进制位的位置i和j。写一个方法来使得N中的第i到j位等于M（M会是N中从第i为开始到第j位的子串）
 * 给出N = (10000000000)2，M = (10101)2， i = 2, j = 6
 * 返回 N = (10001010100)2
 */
public class UpdateBitsTest {

    public static void main(String[] args) {

        System.out.println(intToBinaryString(331));

        System.out.println(Integer.toBinaryString(21));

        updateBits(0, 0, 2, 6);
//        String i = "11111111111111111111111111111111";

//        System.out.println(intToBinaryString(Integer.MIN_VALUE));

    }

    //将n的第i到j位全部变为0  然后把m左移i位   然后m和n做或运算就行了
    private static int updateBits2(int n, int m, int i, int j) {
        for (int x = i; x <= j; x++) {
            //逐位变成0
            n &= ~(1 << x);
        }
        m <<= i;
        return n | m;
    }


    private static int updateBits(int n, int m, int i, int j) {
        //n的二进制字符串
        String nBinary = intToBinaryString(n);
        //m的二进制字符串
        String mBinary = Integer.toBinaryString(m);
        if (mBinary.length() < j - i + 1) {
            StringBuilder zero = new StringBuilder();
            //m的二进制字符串长度不足替换段  前面补0
            for (int x = 0; x < j - i + 1 - mBinary.length(); x++) {
                zero.append('0');
            }
            mBinary = zero.toString() + mBinary;
        }
        //前缀
        String prefix = nBinary.substring(0, nBinary.length() - j - 1);
        //后缀
        String suffix = nBinary.substring(nBinary.length() - i, nBinary.length());
        return binaryStringToInt(prefix + mBinary + suffix);
    }

    //int转换成32位二进制字符串
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
