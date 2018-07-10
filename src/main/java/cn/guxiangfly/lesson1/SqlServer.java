package cn.guxiangfly.lesson1;

import java.sql.*;

public class SqlServer {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//数据库URL[即：是要连接那一个数据库]localhost--指定本机；integratedSecurity=true--指定windows验证模式连接数据库studentdb
        String dbURL = "jdbc:sqlserver://localhost:1433;integratedSecurity=true; DatabaseName=testDb";
        try {
            Class.forName(driver);  //加载驱动
            con = DriverManager.getConnection(dbURL);//建立连接，返回一个Connection con对象                   
            System.out.println("Connecting Successful!!!!!");//控制台输出Connecting Successful!!!!!           
            stmt = con.createStatement();//执行对象Statement负责执行SQL语句，由Connection对象产生
            rs = stmt.executeQuery("select * from studentInfo_table");//Statement对象stmt执行查询操作，返回结果集
            while (rs.next()) {       //rs.getInt("id");从结果集rs  的“id”列,获取int型的 值
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("sex"));

            }
        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

}