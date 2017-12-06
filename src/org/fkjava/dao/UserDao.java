package org.fkjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.fkjava.bean.User;

public class UserDao {

	public User login(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得连接                                               协议 ：子协议 ：////本地数据库
		Connection con = DriverManager.getConnection("jdbc:mysql:///bookapp", "root", "root");
		//3.准备sql语句
		StringBuffer sql = new StringBuffer();
		sql.append("select * from tb_user where name = ? and password = ?");
		//4.执行sql
		PreparedStatement psmt = con.prepareStatement(sql.toString());
		psmt.setObject(1, name);
		psmt.setObject(2, password);
		//executeQuery 只用于查询操作
		ResultSet rs = psmt.executeQuery();
		User user =new User();
		//如果有数据
		if(rs.next()){
			//获取数据
			String uname=rs.getString("name");
			String upassword=rs.getString("password");
			//封装数据到user对象
			user.setName(uname);
			user.setPassword(upassword);
		}
		return user;
		
	}



}
