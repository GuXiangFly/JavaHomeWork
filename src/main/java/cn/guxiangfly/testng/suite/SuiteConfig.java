package cn.guxiangfly.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 8/17/18
 * @desc : JavaHomeWork
 */
public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite() {
        System.err.println("before suite  run..");

    }

    @AfterSuite
    public void afterSuite() {
        System.err.println("before suite  run..");
    }

    @Test (enabled = false)
    public void ignoreTest() {
        System.err.println("ingore it ");

    }
}
