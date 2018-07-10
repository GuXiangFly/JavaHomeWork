package cn.guxiangfly.designpattern.iterator;

/**
 * Client
 *
 * @author guxiang
 * @date 2018/5/22
 */
public class Client {

    public static void main(String[] args) {
        ConcreteMyAggregate cma = new ConcreteMyAggregate();
        cma.addObject("aa");
        cma.addObject("bb");
        cma.addObject("cc");

        MyIterator iterator = cma.createIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.getCurrentObj());
            iterator.next();
        }
    }
}
