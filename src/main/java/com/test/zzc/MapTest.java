package com.test.zzc;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author le
 * @date 2018/3/30
 */
public class MapTest {
    public static String StrToBinstr(String str) {
        char[] strChar=str.toCharArray();
        String result="";
        for(int i=0;i<strChar.length;i++){
            result +=Integer.toBinaryString(strChar[i])+ " ";
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(StrToBinstr("123"));
        System.out.println(Integer.toBinaryString('1'));



        Map<Integer,Integer> map = new LinkedHashMap<>();
        map.put(540,112);
        map.put(560,11963);
        map.put(580,219351);
        map.put(600,50234813);
        map.put(620,27053108);
        map.put(640,5046478);
        map.put(660,2403053);
        map.put(680,1499284);
        map.put(700,1051053);
        map.put(720,781669);
        map.put(740,606178);
        map.put(760,483998);
        map.put(780,1983745);
        System.out.println(map.values().stream().mapToInt(v -> v).sum());


        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+"==="+entry.getValue());
        }


    }



}
