package org.fkjava.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;





public class Preparedstatement {
	public static void main(String[] args) throws Exception {
		login("admin","123 'or' 1=1");
	}

	private static void login(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得连接
		Connection con =DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
		//3.准备sql语句
		StringBuffer sql =new StringBuffer();
		// "name=?"的?是占位符 占了位置的字符
		sql.append("select * from tb_user").append("where name=? and password = ?");
		System.out.println("sql-->"+sql.toString());
		//执行sql
		PreparedStatement pmst = con.prepareStatement(sql.toString());
		//给占位符设值
		pmst.setObject(1, name);
		pmst.setObject(2, password);
		ResultSet rs = pmst.executeQuery();
		if(rs.next()){
				int id=rs.getInt("id");
				String uname=rs.getString("name");
				String pass = rs.getString("password");
				System.out.println("id:"+id+" 姓名："+uname+" 密码："+pass);
				
		}
		
	}
}
