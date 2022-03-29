package StackAndQueue;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

/**
 * @Date: 2022/3/28 15:46
 */

public class leetcode_42 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://144.34.186.17:3306/mysql_test?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
        String username="root";
        String password="hekaig24";
        Connection con= DriverManager.getConnection(url,username,password);
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String user=sc.nextLine();
        System.out.println("请输入密码：");
        String pwd=sc.nextLine();
        String sql="select * from index_demo where id=? and c1=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setObject(1, user);
        ps.setObject(2, pwd);

        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("id")+"   "+rs.getString("c1")+"   "+rs.getString("c2"));
        }
        rs.close();
        ps.close();
        con.close();
    }
//    public int trap(int[] height) {
//
//    }
}
