package cn.guxiangfly.shiyan.project02;


import java.util.ArrayList;

/**
 * Test1
 *
 * @author guxiang
 * @date 2017/10/19
 */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("马六");
        names.add("赵七");

        for (int i = 0; i < names.size(); i++) {
            System.out.println("位置"+i + "--- " + names.get(i));
        }

        System.out.println("集合大小为："+names.size());
        System.out.println("删除的第3个元素内容为："+names.get(2));
        names.remove(2);
        System.out.println("删除操作后，集合的第3个元素内容为："+names.get(2));
        System.out.println("删除操作后，集合的大小为"+names.size());

    }
}
