package cn.guxiangfly.singeton;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/26/18
 * @desc : JavaHomeWork
 */
public class Singleton002 {

    private static Singleton002 singleton002;
    static {
        singleton002 = new Singleton002();
    }

    public static Singleton002 getSingleton002() {
        return singleton002;
    }
}

