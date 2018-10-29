package cn.guxiangfly.singeton;



/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/26/18
 * @desc : JavaHomeWork
 */
public class Singleton001 {

    private static Singleton001 singleton001 = new Singleton001();

    public static Singleton001 getSingleton01() {
        return singleton001;
    }
}
