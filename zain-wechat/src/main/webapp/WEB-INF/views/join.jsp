<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>招募令</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <jsp:include page="/commons/common.jsp"></jsp:include>
</head>
<body>
	<!-- 导航栏 -->
	<jsp:include page="/head/nav.jsp"></jsp:include>
    
    <!-- 全局部分 -->
    <div class="" style="margin-top: -25px;">
        
        <!-- 展示图 -->
        <div class="col-xs-12 bg-primary" style="border:1px solid white; height: 70px; padding-top: 25px;">
            <span>展示图</span>
        </div>
        
        <!-- 标题 -->
        <div class="col-xs-12" style="height: 50px; padding: 10px;">
            <span>艺人展示表</span>
        </div>
        
        <!-- 表单 -->
        <div class="col-xs-12">
            <form role="form">
            
              <!-- 真实姓名 -->
			  <div class="form-group">
			    <label for="exampleInputEmail1">真实姓名</label>
			    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="姓名">
			  </div>
			  
			  <!-- 性别 -->
			  <div class="form-group">
                <div>
                    <label for="exampleInputPassword1">性别</label>
                </div>
                <label class="radio-inline">
				  <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                                男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2" checked>
				   女
				</label>
              </div>
			  
			  <!-- 年龄 -->
			  <div class="form-group">
                <label for="exampleInputEmail1">年龄</label>
                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="年龄">
              </div>
              
              <!-- 身高 -->
              <div class="form-group">
                <label for="exampleInputEmail1">身高(cm)</label>
                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="身高">
              </div>
              
              <!-- 体重 -->
              <div class="form-group">
                <label for="exampleInputEmail1">体重(kg)</label>
                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="体重">
              </div>
              
              <!-- 影视作品 -->
              <div class="form-group">
                <label for="exampleInputEmail1">影视作品</label>
                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="影视作品">
              </div>
              
              <!-- 爱好特长 -->
              <div class="form-group">
                <label for="exampleInputEmail1">爱好特长</label>
                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="爱好特长">
              </div>
              
              <!-- 联系方式 -->
              <div class="form-group">
                <label for="exampleInputEmail1">联系方式</label>
                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="联系方式">
              </div>
              
              <!-- 短视频上传 -->
              <div class="form-group">
                <label for="exampleInputEmail1">短视频上传</label>
                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="请上传大小不超过10MB时长不超过1分钟的文件">
                <button class="btn btn-default">上传</button>
              </div>
              
              <!-- 个人照（请上传三张个人照片） -->
              <div class="form-group">
                <label for="exampleInputEmail1">个人照(请上传三张个人照片)</label>
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
              
			  <!-- 所在城市 -->
              <div class="form-group">
                <label for="exampleInputEmail1">所在城市</label>
                <div class="row">
                
                    <div class="col-xs-1"></div>
                    
		            <div class="btn-group ">
		              <button class="btn btn-primary btn-sm dropdown-toggle" type="button" data-toggle="dropdown">
		                          省 <span class="caret"></span>
		              </button>
		              <ul class="dropdown-menu" role="menu">
		                <li><a>1</a></li>
		                <li><a>2</a></li>
		                <li><a>3</a></li>
		              </ul>
		            </div>
		            
		            <div class="btn-group ">
		              <button class="btn btn-info btn-sm dropdown-toggle" type="button" data-toggle="dropdown">
		                            市 <span class="caret"></span>
		              </button>
		              <ul class="dropdown-menu" role="menu">
		                <li><a>1</a></li>
		                <li><a>2</a></li>
		                <li><a>3</a></li>
		              </ul>
		            </div>
		            
		        </div>
              </div>
              
              <!-- 提交按钮 -->
			  <button type="submit" class="btn btn-info col-xs-12">提交</button>
			</form>
        </div>
    
    </div>
 

</body>
</html>