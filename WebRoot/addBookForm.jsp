<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>商品添加</h3>
<!--先上传图片，在根据输入相同图片名显示图片  -->
	<br />
	<br />
	<form method="post" action="UploadServlet" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="uploadFile" />
    <br/><br/>
    <input type="submit" value="上传" />
</form>
	<form  action="addBook.jsp" method="post">
		<table style="font-size: :16px">
			<tr>
				<td>书名：</td>
				<td><input type="text" value="${book.name }" name="name" /></td>
			</tr>
			<tr>
				<td>作者：</td>
				<td><input type="text" value="${book.author }" name="author" /></td>
			</tr>
			<tr>
				<td>出版社：</td>
				<td><input type="text" value="${book.publication }" name="publication" /></td>
			</tr>
			<tr>
				<td>价钱：</td>
				<td><input type="text" value="${book.price }" name="price" /></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td><input type="text" value="${book.remark }" name="remark" /></td>
			</tr>
			<tr>
			<td>输入图片文件名:</td>
    		<td><input type="text"  value="${book.image }" name="image" /></td>
  			</tr>
			<tr>
			
				<td align="right">
				<input type="submit" value="添加" /> &nbsp;&nbsp;<a href="javascript:history.go(-1)">退回 </a>
			</tr>
		</table>
	</form>
</body>
</html>