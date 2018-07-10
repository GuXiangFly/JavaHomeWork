package cn.guxiangfly.annotation;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * AnnotationJdbcUtil
 *
 * @author guxiang
 * @date 2017/11/4
 */
public class AnnotationJdbcUtil {


    /**
     * 读取这里的注解信息，然后用这些注解信息去链接数据库
     *
     * @return
     * @throws Exception
     */
    @DbInfo(driverClass = "com.mysql.jdbc.Driver", username = "root", password = "root", url = "jdbc:mysql:///test")
    public Connection getConnection() throws Exception {

        Class<?> clazz = Class.forName("cn.guxiangfly.annotation.AnnotationJdbcUtil");

        Method getConnectionMethod = clazz.getMethod("getConnection", null);

        //判断方法是否在getconnection方法上
        boolean isPresent = getConnectionMethod.isAnnotationPresent(DbInfo.class);

        if (!isPresent){
            return null;
        }
        //如果进来，表明注解在当前方法上
        DbInfo annotation = getConnectionMethod.getAnnotation(DbInfo.class);
        String driverClass = annotation.driverClass();
        String username = annotation.username();
        String password = annotation.password();
        String url = annotation.url();
        Class.forName(driverClass);

        return DriverManager.getConnection(url,username,password);
    }
}
