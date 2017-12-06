<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table{
		  border-collapse:collapse;
	}
</style>
</head>
<body>
	<center>
		欢迎[<font color="red">${user.name}</font>]光临
		<table border="1">
			
			<tr>
				<!-- th 表头设置 -->
				<th>封面</th>
				<th>书名</th>
				<th>作者</th>
				<th>价钱</th>
				<th>操作</th>
			</tr>
		
			<!-- c标签是需要导入 c:forEach是遍历集合数据 items是放置的集合数据 var是起别名 -->
			<c:forEach items="${list}" var="book">
				<tr>
					<td><img src="${pageContext.request.contextPath}/images/${book.image}" style="width:100px;height:100px"/></td>
					<td>${book.getName()}</td>
					<td>${book.author}</td>
					<td>${book.price}</td>
					<td>
						<a href="${pageContext.request.contextPath}/detail?id=${book.id}">查看</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/delete?id=${book.id}">删除</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/ToUpdate?id=${book.id}">修改</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>