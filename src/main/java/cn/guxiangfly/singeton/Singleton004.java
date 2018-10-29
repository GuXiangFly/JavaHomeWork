package cn.guxiangfly.singeton;


/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/26/18
 * @desc : JavaHomeWork
 */


public class Singleton004 {

    private static Singleton004 singleton004;


    public static  Singleton004 getSingleton004() {
        synchronized (singleton004) {
            if (singleton004 == null) {
                synchronized (Singleton004.class) {
                    singleton004 = new Singleton004();
                }
            }
            return null;
        }
    }


}
