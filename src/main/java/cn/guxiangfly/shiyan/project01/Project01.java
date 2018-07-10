package cn.guxiangfly.shiyan.project01;

import java.lang.reflect.Field;

/**
 * project01
 *
 * @author guxiang
 * @date 2017/10/19
 */
public class Project01 {

    public static void main(String[] args) throws Exception {


        Class clazz= Class.forName("cn.guxiangfly.shiyan.project01.User");

        User guxiang =(User) clazz.newInstance();


        Field usernameField=clazz.getDeclaredField("username");
        Field passwordField=clazz.getDeclaredField("password");

        //暴力破解private
        usernameField.setAccessible(true);
        usernameField.set(guxiang,"guxiang");

        passwordField.setAccessible(true);
        passwordField.set(guxiang, "1234");

        System.out.println(guxiang);
    }
}
