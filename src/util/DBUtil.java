package util;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import service.LoginInfoService;
import service.impl.LoginInfoServiceImpl;
import entity.LoginInfo;

/**
 * MySQL连接工具类
 * @author TZQ
 *
 */

public class DBUtil {
    private static String url="jdbc:mysql://localhost:3306/javaweb?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";  //连接地址
    private static String userName="root";  //连接用户名
    private static String password="123456";  //连接密码
    private static Connection conn=null;  //连接驱动

    public static Connection getConnection() {
        if(conn==null) {
            try {
                //com.mysql.jdbc.Driver是 mysql-connector-java 5版本中的
                //com.mysql.cj.jdbc.Driver是 mysql-connector-java 6版本及以上中的
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn=DriverManager.getConnection(url,userName,password);
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return conn;
    }


    //测试
    public static void main(String[] args) {
        System.out.println(getConnection());
        LoginInfoService loginInfoService=new LoginInfoServiceImpl();
        LoginInfo user=new LoginInfo();
        user.setAccount("1");
        user.setPassword("2");
        loginInfoService.register(user);

        String account="1";
        String password="2";
        LoginInfo user1=loginInfoService.login(account, password);
        System.out.println(user1.toString());
    }
}