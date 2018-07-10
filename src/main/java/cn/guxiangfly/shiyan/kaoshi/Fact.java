package cn.guxiangfly.shiyan.kaoshi;

import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Fact
 *
 * @author guxiang
 * @date 2017/12/31
 */
public class Fact <T>{
    public static  <T> T getobjectByCeneric(Class<T> tClass,String username,String password) throws Exception {
        //Class<T> clazz = (Class<T>) t.getClass();
       Constructor<T> constructor = tClass.getConstructor(String.class,String.class);
        T t1 = constructor.newInstance(username,password);
        System.out.println(t1.toString());
        FileWriter fileWriter  = new FileWriter("D:\\IntellijIDEAWorkSpace\\JavaHomeWork\\src\\main\\resources\\test.txt");
        fileWriter.write(String.format("%s\t%s",username,password));
        fileWriter.close();

        Class<Person> personClass = Person.class;
        Constructor<Person> constructor1 = personClass.getConstructor(String.class, String.class);

        constructor1.newInstance(username,password);
        return t1;
    }



}
