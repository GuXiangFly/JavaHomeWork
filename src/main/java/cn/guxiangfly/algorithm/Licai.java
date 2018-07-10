package cn.guxiangfly.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Licai
 *
 * @author guxiang
 * @date 2018/5/26
 */
public class Licai {
    public static void main(String[] args) {
        int all = 100;
        int a = 11;
        int b = 22;
        int c = 33;
        List<Bean> list = new ArrayList<>();

        for (int a1 = 0; a1 <10 ; a1++) {
            for (int b1 = 0; b1 <5 ; b1++) {
                for (int c1 = 0; c1 < 4; c1++) {
                    if (a1*a+b1*b+c1*c<=100){
                       list.add(new Bean(a1,b1,c1));
                    }
                }
            }
        }



    }
}
