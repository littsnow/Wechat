<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>演员详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <jsp:include page="/commons/common.jsp"></jsp:include>
</head>
<body>
    <!-- 导航栏 -->
    <jsp:include page="/head/nav.jsp"></jsp:include>
    
    <!-- 全局部分 -->
    <div class="container-fluid" style="padding-top:5px">
        
        <!-- 图片部分 -->
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
		  <!-- Indicators -->
		  <ol class="carousel-indicators">
		    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
		  </ol>
		
		  <!-- Wrapper for slides -->
		  <div class="carousel-inner" role="listbox">
		    <div class="item active">
		      <img src="/zain-wechat/imgs/222.png" alt="1">
		      <div class="carousel-caption">
		      </div>
		    </div>
		    <div class="item">
              <img src="/zain-wechat/imgs/222.png" alt="2">
              <div class="carousel-caption">
              </div>
            </div>
            <div class="item">
              <img src="/zain-wechat/imgs/222.png" alt="3">
              <div class="carousel-caption">
              </div>
            </div>
		  </div>
		
		  <!-- Controls -->
		  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
        
        <!-- 用户信息部分 part1 -->
        <div class="main">
            <!-- 名字 -->
            <div>
                <span>艾希</span>
            </div>
            <!-- 性别 -->
            <div>
                <span>女</span>
            </div>
            <!-- 身高/体重 -->
            <div>
                <span>165cm/44kg</span>
            </div>
            <!-- 所在城市 -->
            <div>
                <span>天津市 西青区</span>
            </div>
        </div>
    
        <!-- 用户信息部分 part2 -->
        <div style="text-align: left;">
            <!-- 影视作品 -->
            <div>
                        影视作品：
              <div>
                          《甄嬛传》中饰演华妃娘娘；
              </div>
            </div>
            <!-- 爱好特长 -->
            <div>
                        爱好特长：
              <div>
                          吃饭睡觉打豆豆
              </div>
            </div>
        </div>
        
        <!-- 用户信息部分 part3 -->
        <div style="padding-top: 10px;">
            <!-- 短视频 -->
            <div style="text-align: left;">
                            短视频：
                <div>
                    <video src="/zain-wechat/movies/oceans.mp4" controls="controls" width="100%">
					 短视频
					</video>
                </div>
            </div>
        </div>
    
        <!-- 加载更多部分 -->
        <div style="padding-top: 10px;">
            <button class="btn btn-info col-xs-12" >立即预约</button>
        </div>
    </div>

</body>

</html>