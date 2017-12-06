<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆信息输入页面</title>
<link rel="stylesheet" href="${ctx }/resources/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="${ctx }/resources/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/jquery/jquery-migrate-1.2.1.min.js"></script>
<!-- 导入bootStrap的库 -->
<script type="text/javascript" src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/easyUI/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="${ctx}/resources/easyUI/easyui.css">
<!-- 导入时间控件组件 -->
<script type="text/javascript" src="${ctx}//resources/My97DatePicker/WdatePicker.js"></script>
<script>
	$(function(){
		//提示
		if("${tip}"){
			$.messager.defaults = { cancel:"继续添加",ok:"确认退出"};
			$.messager.confirm("操作提示","${tip}",function(data){
				if(data){
					parent.window.location = "${ctx}/cm/buy/list.jsp";
				}else{
					
				}
			})
		}
		
		$("#btn_submit").click(function(){
			//获取车牌号
			var code = $("#code");
			//获取购买人
			var employee = $("#employee");
			//获取价格
			var price = $("#price");
			var msg = "";//提示信息
			if($.trim(code.val()) == ""){
				msg = "车牌号不能为空";
				code.focus();
			}else if($.trim(employee.val()) == ""){
				msg = "购买人不能为空";
				employee.focus();
			}else if($.trim(price.val()) == ""){
				msg = "价格不能为空";
				price.focus();
			}
			
			//判断提示是否为空
			if(msg != ""){
				alert(msg);
			}else{
				$("#addBuyForm").submit();//否则提交页面
			}
		})
	})
</script>
</head>
<body>
	<!-- 因为表单是模态框，所以要用container -->
	<div class="container">
		<form action="${ctx}/cm/buy/addBuy.jsp" method="post" class="form-horizontal" id="addBuyForm" style="padding:20px">
			<div class="form-group  col-xs-6">
				<div>
					<input id="brand" name="brand" type="text" class="btn btn-default" placeholder="品牌">
				</div>
			</div>
			
			<div class="form-group col-xs-6">
				<div>
					<input id="code" name="code" type="text" class="btn btn-default" placeholder="车牌">
				</div>
			</div>
			
			<div class="form-group col-xs-6">
				<div>
					<input id="origin" name="origin" type="text" class="btn btn-default" placeholder="出产地">
				</div>
			</div>
			
			<div class="form-group col-xs-6">
				<div>
					<input id="engine" name="engine" type="text" class="btn btn-default" placeholder="发动机">
				</div>
			</div>
			
			<div class="form-group col-xs-6">
				<div>
					<input id="version" name="version" type="text" class="btn btn-default" placeholder="型号">
				</div>
			</div>
			
			<div class="form-group col-xs-6">
				<div>
					<input id="price" name="price" type="number" class="btn btn-default" placeholder="价格">
				</div>
			</div>
			
			<div class="form-group col-xs-6">
				<div>
					<input id="buytime" name="buytime" type="text" class="btn btn-default" placeholder="购买时间" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});">
				</div>
			</div>
			<div class="form-group col-xs-6">
				<div>
					<input id="employee" name="employee" type="text" class="btn btn-default" placeholder="购买人" >
				</div>
			</div>
			
			<div class="form-group col-xs-6">
				<div>
					<select name="color"  class="btn btn-default">
							<option value="黑色">黑色</option>
							<option value="蓝色">蓝色</option>
							<option value="白色">白色</option>
							<option value="红色">红色</option>
					    </select>
				</div>
			</div>
			
			<div class="form-group text-center  col-xs-12">
				<a id="btn_submit" class="btn btn-info">添加</a>
				<button type="reset" class="btn btn-danger">取消</button>
			</div>
		</form>
	
	</div>
</body>
</html>