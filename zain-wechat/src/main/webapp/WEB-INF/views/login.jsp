<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <jsp:include page="/commons/common.jsp"></jsp:include>
</head>
<body>
	<!-- 导航栏 -->
    <jsp:include page="/head/nav.jsp"></jsp:include>
	
	<div id="login">
		<!-- 查询框 -->
	    <div class="container" style="padding-top:50px">
	    	<div class="" style="padding-top:10px">
	    		<div>
	    			<span class="" ><label>账户名</label><input type="text" class="keyclear" id="account" placeholder="请输入账户名"/></span>
	    		</div>
	    		<div style="padding-top:10px">
	    			<span class="" ><label>密&nbsp;&nbsp;&nbsp;码</label><input type="text" placeholder="请输入密码" id="password" class="laydate-icon keyclear" /></span>
	    		</div>
	    	</div>
	    	
	    </div>
		
		<div class="" style="padding-top:50px">
	        <button class="btn btn-success" id="register">注册</button>
	    </div>
    </div>
</body>

<script type="text/javascript">
$(function() {
	$("#register").click(function() {
		var account = $.trim($("#account").val());
		var password = $.trim($("#password").val());
		
		if(account == "" || password == "") {
			$(".keyclear").val('');
			alert("不能为空");
			return;
		}
		
		var param = {account : account, password : password};
		var result = sendAjax(param, "/web/register.do");
		if(!result.ok) {
			alert("失败!");
			return;
		}
		alert("成功!");
		$("#login").html("请返回微信继续操作~");
	});
});

</script>

</html>