package cn.guxiangfly.designpattern.adapter;

/**
 * Adapter
 * (类适配器方式)
 * 适配器本身
 *
 * @author guxiang
 * @date 2018/5/21
 */
public class Adapter2  implements Target {

   private   Adaptee adaptee ;

    @Override
    public void handleRequest() {
        adaptee.request();
    }

    public Adapter2(Adaptee adaptee){
        super();
        this.adaptee = adaptee;
    }
}
