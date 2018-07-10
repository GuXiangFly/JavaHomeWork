package cn.guxiangfly.jvm.test;

/**
 * Demo02
 *
 * @author guxiang
 * @date 2018/1/13
 */
public class Demo02 {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        System.out.println(System.getProperty("java.class.path"));

        for (int i = 0; i <100000000 ; i++) {
            new StringBuilder();
        }
    }
}
