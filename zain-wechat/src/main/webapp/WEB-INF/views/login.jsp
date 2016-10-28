<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>职位列表查询</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
 
	 
	    <!-- bootstrap -->
		<link type="text/css" href="/lrj-web/bootstrap/css/bootstrap.css"  rel="stylesheet" >
	   
	    <!-- jquery -->
	    <script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
	    <!-- bootstrap -->
	    <script type="text/javascript" src="/lrj-web/bootstrap/js/bootstrap.js"></script>
		
		
	<style type="text/css">
		
/************** 覆盖原样式部分 start ******************/
		/* 全局 */
		body {
			height: 100%;
    		background-color: #333;
		    color: #fff;
		    text-align: center;
		    font-family: 'Microsoft YaHei';
		}
		
		/* 文字标签，内联的 */
		label {
			margin: 0px 10px;
		    display: inline-block;
		    max-width: 100%;
		    margin-bottom: 5px;
		    font-weight: bold;
		}
		
		/* 响应布局，栅格布局 */
		.col-lg-3 {
			padding: 0px;
		}
		.col-lg-6 {
			padding: 0px;
		}
		
		/* 输入框 */
		input {
			color: black;
		}
		
/************** 覆盖原样式部分 end ******************/		
	
	
/************** 自定义样式部分 start ******************/	
		/* 必填字段*样式 */
    	label .importFiled {
    		color:red;
    	}
    	
	
		/* 需要清除的输入框 */
		.keyclear {
			margin: 5px 0px;
		}
		
		.btn {
			margin: 10px;
		}
		
	</style>
     
</head>
<body>
	<!-- 导航栏 -->
    <nav class="navbar navbar-default navbar-inverse">
    	<div class="navbar-header">
	      	<a class="navbar-brand" href="/portal/page/index.html">路人甲</a>
   		</div>
    </nav>
	
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

function sendAjax(param, url) {
    var data;
    $.ajax({
        url: getBasePath() + url,
        dataType: "text",
        type: "post",
        data: param,
        async: false,
        success: function(result) {data = JSON.parse(result);},
        //error: error
    });
    return data;
}

function getBasePath() {
    var obj = window.location; //当前页面对象
    var contextPath = obj.pathname.split("/")[1];//获取项目名
    return obj.protocol+"//"+obj.host+"/"+contextPath;
}

</script>

</html>