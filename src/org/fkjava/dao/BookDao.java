package org.fkjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.fkjava.bean.Book;
import org.fkjava.util.ConnectionFactory;

import com.sun.corba.se.pept.transport.EventHandler;



public class BookDao {
	public void add(Book book){
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			// 2获取连接
			con = ConnectionFactory.getConnection();
			//准备Sql
			String sql = "insert into tb_book(name,author,publication,"
					+ "price,remark,publicationdate)values(?,?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			//给占位符赋值
			pstm.setObject(1, book.getName());
			pstm.setObject(2, book.getAuthor());
			pstm.setObject(3, book.getPublication());
			pstm.setObject(4, book.getPrice());
			pstm.setObject(5, book.getRemark());
			pstm.setObject(6, new Date());
			//执行sql
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(con, pstm, null);
		}
	}

	public List<Book> getAll() {
		//定义一个集合来装载查询出来的数据
		List<Book> list=new ArrayList<Book>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			//获得数据库连接
			con = ConnectionFactory.getConnection();
			//准备sql语句
			String sql="select * from tb_book";
			pstm = con.prepareStatement(sql);
 			//查询后会返回结果集
			rs=pstm.executeQuery();
			//判断
			while(rs.next()){
				Book book= new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setImage(rs.getString("image"));
				list.add(book);
;			}
			//返回结果数据
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally {
			ConnectionFactory.close(con, pstm, rs);
		}
		
	}

	public Book getByid(Integer id) {
		// TODO Auto-generated method stub
		//定义一个集合来装载查询出来的数据
	    Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			//获得数据库连接
			con = ConnectionFactory.getConnection();
			//准备sql语句
			String sql="select * from tb_book where id =?";
			pstm = con.prepareStatement(sql);
			//设置问号的值
			pstm.setObject(1, id);
 			//查询后会返回结果集
			rs=pstm.executeQuery();
			//判断
			if(rs.next()){
				Book book= new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setImage(rs.getString("image"));
				return book;
		}
			//返回结果数据
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally {
			ConnectionFactory.close(con, pstm, rs);
		}
		
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//获得数据库连接
			con = ConnectionFactory.getConnection();
			//准备sql语句
			String sql="delete  from tb_book where id =?";
			pstm = con.prepareStatement(sql);
			//设置问号的值
			pstm.setObject(1, id);
 			//查询后会返回结果集
		    pstm.executeUpdate(); 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			ConnectionFactory.close(con, pstm,null);
		}
		
	}

	public void update(String name, String author, Double price, Integer id) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			//获得数据库连接
			con=ConnectionFactory.getConnection();
			StringBuffer sql=new StringBuffer();
			sql.append(" update tb_book set name = ?,author = ?,price = ?");
			sql.append(" where id = ?");
			pstm=con.prepareStatement(sql.toString());
			pstm.setObject(1, name);
			pstm.setObject(2, author);
			pstm.setObject(3, price);
			pstm.setObject(4, id);
			//执行sql
			pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(con,pstm,null);
			
		}
	}

	
	

	

}
