package dao;

import entity.LoginInfo;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 登录功能类
 * @author TZQ
 *
 */

public class LoginInfoDao {

    public static LoginInfo login(String account, String password) {
        String sql="select * from login_info where account="+"'"+account+"'"+" and password="+"'"+password+"'"+";";

        LoginInfo user=new LoginInfo();
        try {
            Connection conn= DBUtil.getConnection();
            PreparedStatement pStatement=conn.prepareStatement(sql);
            ResultSet resultSet=pStatement.executeQuery();
            if(resultSet.next()) {
                user.setAccount(resultSet.getString("account"));
                user.setPassword(resultSet.getString("password"));
                System.out.println(user+"登录成功！");
            }
            else {
                System.out.println("用户名或密码错误！");
            }
            resultSet.close();
            pStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return user;
    }

    public static void register(LoginInfo user) {
        String sql="insert into login_info(account,password) values(?,?);";
        try {
            Connection conn= DBUtil.getConnection();
            PreparedStatement pStatement=conn.prepareStatement(sql);
            pStatement.setString(1, user.getAccount());
            pStatement.setString(2, user.getPassword());
            pStatement.executeUpdate();
            pStatement.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
