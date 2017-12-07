package org.fkjava.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * CRUD 增删改查
 * @author admin
 *
 */
public class CURD {

	public static void main(String[] args) throws Exception {
		//1.建表
		//createTable();
		//修改后要保存再运行java application
		
		
		//根据名字查询数据，sql注入
		selectData("'admin'"," or 1=1");

	}

	private static void selectData(String name,String str) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得连接                                               协议 ：子协议 ：////本地数据库
		Connection con = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
		//3.准备sql语句
		StringBuffer sql =new StringBuffer();
		//append用于连接字符串
		sql.append("select * from tb_user where name=").append(name).append(str);
		//执行sql
		Statement smt = con.createStatement();
		System.out.println("sql-->"+sql.toString());
		//执行查询 
		ResultSet rs = smt.executeQuery(sql.toString());
		//如果有数据
		while(rs.next()){
			int uid = rs.getInt("id");
			int aid=uid+10;
			String uname=rs.getString("name");
			System.out.println("uid："+uid+" 姓名："+uname);
			System.out.println("执行的sql："+sql.toString());
			StringBuffer sql1 =new StringBuffer();
			Connection con1 = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
			//append用于连接字符串，
			sql1.append(" update tb_user set name='").append(uname).append("' where id =").append(aid);
			System.out.println("执行的sql："+sql1.toString());
			Statement smt1 = con1.createStatement();
			//执行查询
			smt1.executeUpdate(sql1.toString());
			System.out.println("aid："+aid+" 姓名："+uname);
			
		}
	}

	private static void selectAll() throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得连接                                               协议 ：子协议 ：////本地数据库
		Connection con = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
		//3.准备sql语句
		StringBuffer sql =new StringBuffer();
		//append用于连接字符串
		sql.append("select * from tb_user ");
		//执行sql
		Statement smt = con.createStatement();
		//执行查询 
		ResultSet rs = smt.executeQuery(sql.toString());
		//如果有数据
		while(rs.next()){
			int id = rs.getInt("id");
			String name=rs.getString("name");
			System.out.println("id："+id+" 姓名："+name);
		}
			
			
	}

	private static void Selectone(int id) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得连接                                               协议 ：子协议 ：////本地数据库
		Connection con = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
		//3.准备sql语句
		StringBuffer sql =new StringBuffer();
		//append用于连接字符串，
		sql.append("select * from tb_user where id=").append(id);
		Statement smt = con.createStatement();
		//执行查询
		ResultSet rs = smt.executeQuery(sql.toString());
		//如果有数据
		if(rs.next()){
			//获取列值getInt：返回数值类型的值
			int uid = rs.getInt("id");
			int aid =uid+10;
			//获取名字getString("列名")
			String uname = rs.getString("name");
			System.out.println("id="+uid+" 姓名 ："+uname);	
			
		}
		
	}

	private static void updateData(String name,int id) throws Exception {
		// TODO Auto-generated method stub
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得连接                                               协议 ：子协议 ：////本地数据库
		Connection con = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
		//3.准备sql语句
		StringBuffer sql=new StringBuffer();
		//append（）用于连接字符串，下两句可即为update tb_user set name='name' where id='id'
		sql.append(" update tb_user set name='").append(name);
		sql.append("' where id =").append(id);
		//sql.append(" update tb_user set name='").append(name);
		//sql.append("' where id =").append(id);
		//执行sql
		Statement smt =con.createStatement();
		
		System.out.println("执行的sql："+sql.toString());
		//用count接收smt产生结果 返回的是影响行数
		int count = smt.executeUpdate(sql.toString());
		System.out.println("更新了"+count+"行");
	}

	private static void deletedata(int id) throws Exception {
		// TODO Auto-generated method stub
		//1.注册驱动
				Class.forName("com.mysql.jdbc.Driver");
				//2.获得连接                                               协议 ：子协议 ：////本地数据库
				Connection con = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
				//3.准备sql语句
				StringBuffer sql = new StringBuffer();
				sql.append(" delete from tb_user where id =").append(id);
				Statement smt = con.createStatement();
				int count = smt.executeUpdate(sql.toString());
				System.out.println("删除了"+count+"行");
				
	}

	private static void insertData(String name) throws Exception {
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得连接                                               协议 ：子协议 ：////本地数据库
		Connection con = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
		//3.准备sql语句
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into tb_user(name)values(");
		sql.append("'").append(name).append("')");
		//4.执行Sql
		Statement smt = con.createStatement();
		//执行后会返回影响行数
		int count = smt.executeUpdate(sql.toString());
		System.out.println("影响行数: "+count);
		
		//关闭连接
		smt.close();
		con.close();
	}

	//建表方法
	private static void createTable() throws Exception {
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得连接                                               协议 ：子协议 ：////本地数据库
		Connection con = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
		//3.准备sql语句
		StringBuffer sql = new StringBuffer();
		sql.append("CREATE TABLE tb_user(id INT PRIMARY KEY AUTO_INCREMENT,");
		sql.append("NAME VARCHAR(30))");
		//4.执行语句
		Statement smt = con.createStatement();
		//flag 为false,因为有结果集时才会返回true
		Boolean flag = smt.execute(sql.toString());
		//
		System.out.println("flag: "+flag);
	}

}
