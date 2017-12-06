package org.fkjava.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		            //1.连接驱动
              Class.forName("com.mysql.jdbc.Driver");
              //2.获取链接
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
              
              System.out.println(con);
              
	}

}
