<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
</head>
<body>
	<center>
		<!-- action是提交到那个资源处理 ，method是提交的方式 -->
		<form action="update" method="post">
			<input type="hidden" name="id" value="${book.id }" />
			
			<p>书名:<input type="text" name="name" value="${book.name }" /></p>
			<p>作者:<input type="text" name="author" value="${book.author }" /></p>
			<p>价钱:<input type="text" name="price" value="${book.price }" /></p>
			<p>图片名:<input type="text" name="image" value="${book.image }" /></p>
			<p>
				<input type="submit" value="修改"/>
				<input type="button" value="取消"	 onclick="location='main'"/>
			</p>
		</form>
	</center>

</body>
</html>