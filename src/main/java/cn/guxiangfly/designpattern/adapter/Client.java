package cn.guxiangfly.designpattern.adapter;

/**
 * Client
 *
 * @author guxiang
 * @date 2018/5/21
 */
public class Client {

    public void test1(Target target){
        target.handleRequest();
    }

    public static void main(String[] args) {
        Client c = new Client();
        Adaptee a = new Adaptee();
        Target t= new Adapter2(a);
        c.test1(t);
    }
}
