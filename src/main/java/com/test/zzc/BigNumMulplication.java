package com.test.zzc;

/**
 * @author le
 * @date 2018/5/10
 * 111111111111111   222222222222222
 * 24691358024691308641975308642
 * 24691358024691308641975308642
 * ab cd
 * (a*10**(len(str1)-mid1) + b)(c*10**(len(str2)-mid2) + d)
 * ac*10**(len(str1)+len(str2)-mid1-mid2) + ad*10**(len(str1)-mid1) + bc*10**(len(str2)-mid2) + bd
 */
public class BigNumMulplication {

    public static void main(String[] args) {
        System.out.println(add("00","0"));
        System.out.println(mutiplication("111111111111111","222222222222222"));
    }

    private static String mutiplication(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str1.charAt(0) == '0') {
            return "0";
        }
        if (str2 == null || str2.length() == 0 || str2.charAt(0) == '0') {
            return "0";
        }
        if (str1.length() == 1 && str2.length() == 1) {
            return String.valueOf(Integer.parseInt(str1) * Integer.parseInt(str2));
        }
        int mid1 = str1.length() / 2;
        int mid2 = str2.length() / 2;
        String a = str1.substring(0, mid1);
        String b = str1.substring(mid1);
        String c = str2.substring(0, mid2);
        String d = str2.substring(mid2);
        String ac = mutiplication(a, c) + zero(str1.length() + str2.length() - mid1 - mid2);
        String ad = mutiplication(a, d) + zero(str1.length() - mid1);
        String bc = mutiplication(c, b) + zero(str2.length() - mid2);
        String bd = mutiplication(d, b);
        return add(add(ac, ad), add(bc, bd));
    }

    private static String zero(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append("0");
        }
        return sb.toString();
    }

    private static String add(String str1, String str2) {
        char[] char1 = new StringBuilder(str1).reverse().toString().toCharArray();
        char[] char2 = new StringBuilder(str2).reverse().toString().toCharArray();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <Math.max(char1.length, char2.length); i++) {
            if (i >= char1.length) {
                sb.append((char2[i] - '0' + carry) % 10);
                carry = (char2[i] - '0' + carry) / 10;
                continue;
            }
            if (i >= char2.length) {
                sb.append((char1[i] - '0' + carry) % 10);
                carry = (char1[i] - '0' + carry) / 10;
                continue;
            }
            sb.append(((char1[i] - '0') + (char2[i] - '0') + carry) % 10);
            carry = ((char1[i] - '0') + (char2[i] - '0') + carry) / 10;
        }
        if (carry>0){
            sb.append(carry);
        }
        if (sb.charAt(sb.length()-1)=='0'){
            return "0";
        }
        return sb.reverse().toString();
    }

}
