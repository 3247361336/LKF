<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="dtree.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="dtree.js"></script>
</head>

<body bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<table width="90%" border="0" cellspacing="1" cellpadding="2" align="center">
<div class="dtree">
  <script type="text/javascript">
    a=new dTree('a');/*dTree('a')的'a'要与a相同，否侧人员管理的文件夹折叠不能展开子文件*/

    a.add('01','-1','信息管理系统');
    a.add('0101','01','人员管理');
    a.add('010101','0101','人员列表','${pageContext.request.contextPath}/sublist/SublistServlet','','right');

    a.add('010102','0101','新增人员','#','','right');
    a.add('010103','0101','test','#','','right');
    a.add('0102','01','商品管理');
    a.add('010201','0102','商品列表','#','','right');

    a.add('010202','0102','新增商品','#','','right');
    a.add('010203','0102','test','#','','right');
    a.add('0103','01','订单管理');
    a.add('010301','0103','订单列表','#','','right');

    a.add('010302','0103','新增订单','#','','right');
    a.add('010303','0103','test','#','','right');
    document.write(a);
  </script>
</div>
</table>

</body>
</html>
