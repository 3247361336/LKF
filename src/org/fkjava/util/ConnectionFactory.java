package org.fkjava.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
	private static final String DRIVER ="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql:///bookapp?useUnicode&characterEncoding=utf-8";
	private static final String USERNAME ="root";
	private static final String PASSWORD ="root";
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public static void close(Connection con,PreparedStatement pstm,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstm != null) pstm.close();
			if(con != null) con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
