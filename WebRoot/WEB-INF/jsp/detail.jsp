<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
</head>
<body>
	<center>
		欢迎[<font color="red">${user.name}</font>]光临
		<p><img src="${pageContext.request.contextPath}/images/${book.image}" style="width:100px;height:100px"/></p>
		<p>${book.name}</p>
		<p>${book.author}</p>
		<p>${book.price}</p>
		<br>
		<a href="${pageContext.request.contextPath}/main">返回主页</a>
	</center>
</body>
</html>