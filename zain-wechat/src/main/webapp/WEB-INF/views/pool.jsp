<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>人才库</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <jsp:include page="/commons/common.jsp"></jsp:include>
</head>
<body>
	<!-- 导航栏 -->
    <jsp:include page="/head/nav.jsp"></jsp:include>
	
	<!-- 全局部分 -->
    <div class="container-fluid" style="padding-top:5px">
        
        <!-- 筛选条件部分 -->
        <div class="row">
            <div class="col-xs-3">
            <div class="btn-group ">
			  <button class="btn btn-primary btn-sm dropdown-toggle" type="button" data-toggle="dropdown">
			      筛选条件1 <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu">
			    <li><a>1</a></li>
                <li><a>2</a></li>
                <li><a>3</a></li>
			  </ul>
			</div>
			</div>
			
			<div class="col-xs-3">
			<div class="btn-group ">
              <button class="btn btn-info btn-sm dropdown-toggle" type="button" data-toggle="dropdown">
                            筛选条件2 <span class="caret"></span>
              </button>
              <ul class="dropdown-menu" role="menu">
                <li><a>1</a></li>
                <li><a>2</a></li>
                <li><a>3</a></li>
              </ul>
            </div>
            </div>
            
            <div class="col-xs-3">
            <div class="btn-group ">
              <button class="btn btn-warning btn-sm dropdown-toggle" type="button" data-toggle="dropdown">
                            筛选条件3 <span class="caret"></span>
              </button>
              <ul class="dropdown-menu" role="menu">
                <li><a>1</a></li>
                <li><a>2</a></li>
                <li><a>3</a></li>
              </ul>
            </div>
            </div>
            
            <div class="col-xs-3">
                <button class="btn btn-success btn-sm">查询</button>
            </div>
            
        </div>
        
        <!-- 图片展示部分 -->
        <div class="main">
            <div class="row">
                <div class="col-xs-4 ">
                <img class="img-thumbnail" alt="图片" 
                     src="/zain-wechat/imgs/111.png" 
                     data-holder-rendered="true" style="width: 120px; height: 150px;">
                </div>
                <div class="col-xs-4 ">
                <img class="img-thumbnail" alt="图片" 
                     src="/zain-wechat/imgs/111.png" 
                     data-holder-rendered="true" style="width: 120px; height: 150px;">
                </div>
                <div class="col-xs-4 ">
                <img class="img-thumbnail" alt="图片" 
                     src="/zain-wechat/imgs/111.png" 
                     data-holder-rendered="true" style="width: 120px; height: 150px;">
                </div>
            </div>
            <div class="row">
                <div class="col-xs-4 ">
                <img class="img-thumbnail" alt="图片" 
                     src="/zain-wechat/imgs/111.png" 
                     data-holder-rendered="true" style="width: 120px; height: 150px;">
                </div>
                <div class="col-xs-4 ">
                <img class="img-thumbnail" alt="图片" 
                     src="/zain-wechat/imgs/111.png" 
                     data-holder-rendered="true" style="width: 120px; height: 150px;">
                </div>
                <div class="col-xs-4 ">
                <img class="img-thumbnail" alt="图片" 
                     src="/zain-wechat/imgs/111.png" 
                     data-holder-rendered="true" style="width: 120px; height: 150px;">
                </div>
            </div>
            <div class="row">
                <div class="col-xs-4 ">
                <img class="img-thumbnail" alt="图片" 
                     src="/zain-wechat/imgs/111.png" 
                     data-holder-rendered="true" style="width: 120px; height: 150px;">
                </div>
                <div class="col-xs-4 ">
                <img class="img-thumbnail" alt="图片" 
                     src="/zain-wechat/imgs/111.png" 
                     data-holder-rendered="true" style="width: 120px; height: 150px;">
                </div>
                <div class="col-xs-4 ">
                <img class="img-thumbnail" alt="图片" 
                     src="/zain-wechat/imgs/111.png" 
                     data-holder-rendered="true" style="width: 120px; height: 150px;">
                </div>
            </div>
            <div class="row">
                <div class="col-xs-4 ">
                <img class="img-thumbnail" alt="图片" 
                     src="/zain-wechat/imgs/111.png" 
                     data-holder-rendered="true" style="width: 120px; height: 150px;">
                </div>
                <div class="col-xs-4 ">
                <img class="img-thumbnail" alt="图片" 
                     src="/zain-wechat/imgs/111.png" 
                     data-holder-rendered="true" style="width: 120px; height: 150px;">
                </div>
                <div class="col-xs-4 ">
                <img class="img-thumbnail" alt="图片" 
                     src="/zain-wechat/imgs/111.png" 
                     data-holder-rendered="true" style="width: 120px; height: 150px;">
                </div>
            </div>
        </div>
    
        <!-- 加载更多部分 -->
        <div>
            <button class="btn btn-info col-xs-12">加载更多...</button>
        </div>
    </div>

</body>

<script type="text/javascript">
$(function() {
	$(".img-thumbnail").on("click", function() {
        window.location.href = getBasePath() + "/web/intoPage/user_info.html";
	});
});

</script>


</html>