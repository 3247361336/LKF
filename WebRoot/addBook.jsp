<%@page import="java.util.Date"%>
<%@page import="org.fkjava.dao.BookDao"%>
<%@page import="org.fkjava.bean.Book"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 接收来自addBuyForm.jsp传递的参数 -->
	<!-- 
      	   	  	id INT PRIMARY KEY AUTO_INCREMENT,
			    buytime DATE,
			    brand VARCHAR(20),
			    CODE VARCHAR(10),
			    color VARCHAR(10),
			    employee VARCHAR(50),
			    ENGINE VARCHAR(30),
			    price DOUBLE,
			    origin VARCHAR(20),
			    VERSION VARCHAR(20)
      	   	   -->
	<%
		//第一步，编码转换
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String publication = request.getParameter("publication");
		double price=Integer.valueOf(request.getParameter("price"));
		String image=request.getParameter("image");
		String remark = request.getParameter("remark");
	
		//要把数据存入到对象中
		Book book = new Book();
		//时间
		
		book.setAuthor(author);
		book.setName(name);
		book.setPrice(price);
		book.setPublication(publication);
		book.setRemark(remark);
		book.setImage(image);
		//调用dao里面的add(buy)
		BookDao dao = new BookDao();
		dao.add(book);//存储车辆对象
		
		//提示
		request.setAttribute("tip", "添加车辆成功");
		//跳转到车辆信息输入页面
		request.getRequestDispatcher("/addBookForm.jsp").forward(request, response);
		
	%>
</body>
</html>