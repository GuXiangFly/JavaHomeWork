package cn.guxiangfly.shiyan.kaoshi;

import org.junit.Test;

import java.sql.*;

/**
 * JDBCTest
 *
 * @author guxiang
 * @date 2018/1/1
 */
public class JDBCTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        String sql;
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/shopbook?"
                + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
        conn= DriverManager.getConnection(url);
        sql="SELECT * FROM t_admin";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            String catalogName = metaData.getCatalogName(i + 1);
            int columnType = metaData.getColumnType(i + 1);
            String columnTypeName = metaData.getColumnTypeName(i + 1);

            System.out.println("columnName :" + catalogName +",columnType : "+ columnType +", columnTypeName: "+columnTypeName);
        }

    }

    @Test
    public void testupdate() throws Exception{
        Connection connection;
        String sql = "insert into t_admin (password, username) VALUES ('123456','xiaoming2')";

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/shopbook?user=root&password=root";
        connection = DriverManager.getConnection(url);
        PreparedStatement statement = connection.prepareStatement(sql);
        boolean execute = statement.execute();
        connection.close();
    }


}