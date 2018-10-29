package cn.guxiangfly.singeton;


/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/26/18
 * @desc : JavaHomeWork
 */


public class Singleton003 {

    private static Singleton003 singleton003;


    public static Singleton003 getSingleton003() {
        if (singleton003==null){
            singleton003 = new Singleton003();
        }
        return null;
    }
}
