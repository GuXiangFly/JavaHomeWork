package cn.guxiangfly.shiyan.project01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Project02
 *
 * @author guxiang
 * @date 2017/10/19
 */
public class Project02 {

    public static void main(String[] args) throws Exception{



        Class clazz= Class.forName("cn.guxiangfly.shiyan.project01.User");

        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class, String.class);

        //调用构造
        User guxiang = (User) declaredConstructor.newInstance("guxiang", "12345");
        //调用方法
        Method getUsernameMethod = clazz.getDeclaredMethod("getUsername");

        System.out.println(getUsernameMethod.invoke(guxiang));;

    }
}
