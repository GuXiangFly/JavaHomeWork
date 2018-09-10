package cn.guxiangfly.testng.groups;

import org.testng.annotations.Test;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 8/17/18
 * @desc : JavaHomeWork
 */
@Test(groups = "student")
public class GroupOnClass1 {

    public void studentTest1(){
        System.err.println(" group student  test1 running");
    }

    public void studentTest2(){
        System.err.println(" group student  test2 running");
    }
}
