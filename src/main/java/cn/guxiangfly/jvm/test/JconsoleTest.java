package cn.guxiangfly.jvm.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 7/19/18
 * @desc : JavaHomeWork
 */
public class JconsoleTest {

    public byte[] b1 = new byte[128*1024];

    public static void main(String[] args) {
        while (true)
        try {
            Thread.sleep(5000);
            fill(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void fill(int i) {
        List<JconsoleTest> jconsoleTests = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            jconsoleTests.add(new JconsoleTest());
        }
    }
}
