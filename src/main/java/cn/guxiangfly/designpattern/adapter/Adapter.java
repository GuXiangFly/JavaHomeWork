package cn.guxiangfly.designpattern.adapter;

/**
 * Adapter
 * (类适配器方式)
 * 适配器本身
 *
 * @author guxiang
 * @date 2018/5/21
 */
public class Adapter extends Adaptee implements Target {



    @Override
    public void handleRequest() {
        super.request();
    }
}
