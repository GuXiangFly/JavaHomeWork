package cn.guxiangfly.algorithm;

/**
 * DoubleNode
 *
 * @author guxiang
 * @date 2018/12/19
 */
public class DoubleNode {

    DoubleNode pre = this;
    DoubleNode next = this;

    int data;

    public DoubleNode(int data) {
        this.data = data;

    }

    public void after(DoubleNode node) {
        DoubleNode nextNext = next;
        this.next = node;
        node.pre = node;
    }
}
