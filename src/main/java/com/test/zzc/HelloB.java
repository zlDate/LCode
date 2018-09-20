package com.test.zzc;

/**
 * @author le
 * @date 2018/5/4
 */

public class HelloB extends HelloA{
    public HelloB(){
        System.out.println("hellob");
    }
    {
        System.out.println("i'm hellob");
    }
    static {
        System.out.println("static hellob");
    }

    public static void main(String[] args) {
        System.out.println("----- start main -----");
        new HelloB();
        System.out.println("-----end main------");
    }

}

class HelloA{
    public HelloA(){
        System.out.println("HelloA");
    }
    {
        System.out.println("i'm helloa");
    }
    static {
        System.out.println("static a");
    }

}
