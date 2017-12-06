<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<form action="${ctx }/bm/addBook.action" method="post"	class="form-horizontal" id="addBookForm"	style="padding:20px">
		<div class="form-group  col-xs-6">
			<div>
					<input id="name" name="book.name" type="text" class="btn btn-default" placeholder="书名">
			</div>	
		</div>
		
		<div class="form-group  col-xs-6">
			<div>
					<input id="author" name="book.author" type="text" class="btn btn-default" placeholder="作者">
			</div>	
		</div>
		<div class="form-group  col-xs-6">
			<div>
					<input id="published" name="book.published" type="text" class="btn btn-default" placeholder="出版社">
			</div>	
		</div>
		<div class="form-group  col-xs-6">
			<div>
					<input id="stock" name="book.stock" type="text" class="btn btn-default" placeholder="库存">
			</div>	
		</div>
		<div class="form-group	col-xs-6">
			<div>
				<textarea rows="3" cols="54" placeholder="备注" name="book.remark"></textarea>
			</div>
		</div>
		<div class="form-group	col-xs-12">
			<a id="btn_submit" class="btn btn-info">添加</a>
			<button type="reset" class="btn btn-danger">取消</button>
		</div>
	</form>
</div>
</body>
</html>