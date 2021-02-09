<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href='${pageContext.request.contextPath }/css/bootstrap.min.css'>
<link rel="stylesheet" href='${pageContext.request.contextPath }/css/site.css'>
<style>
	.uploadpic{
	    border-radius: 50%;
	    overflow: hidden;
	    display: block;
	    -webkit-box-shadow: 
			0px 2px 5px rgba(0,0,0,0.7) inset, 
			0px 0px 0px 12px rgba(61,64,85,0.3);
	    -moz-box-shadow: 
			0px 2px 5px rgba(0,0,0,0.7) inset, 
			0px 0px 0px 12px rgba(61,64,85,0.3);
	    box-shadow: 
			0px 2px 5px rgba(0,0,0,0.7) inset, 
			0px 0px 0px 12px rgba(61,64,85,0.3);
		background-size: cover;
		background-color: #f0f0f0;
		background-repeat: no-repeat;
		background-position: center center;
		width:30%;
		height:30%;
		margin-left:35%
	}
</style>
</head>
<body>
<!--顶部消息弹框-->
    <div id="AlertDiv" class="alert alert-primary" role="alert" style="position:absolute;left:0px;top:0px;width:100%;opacity:0">...</div>
	<!--------------------- 提示模态框 ------------------------->
    <div class="modal fade" id="warnModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="PopModelLabel">...</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div id="PopModelContent" class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="Create()" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>
    <button type="button" id="PopModel" hidden="hidden" data-toggle="modal" data-target="#warnModal">
        Launch demo modal
    </button>
    <!-------------------- 提示模态框结束 ----------------------->
    
    <!------------------------ 输入模态框 ----------------->
    <div class="modal fade" id="textModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="InputModelLabel">...</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input id="InputModelText" type="text" class="form-control" />
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" onclick="Create()" data-dismiss="modal">保存</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
    <button type="button" id="inputModal" hidden="hidden" data-toggle="modal" data-target="#textModal">
        Launch input modal
    </button>
    <!------------------- 输入模态框结束 --------------------->
    <!------------------------ 图片模态框 ----------------->
    <div class="modal fade" id="ImageModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" style="text-align:center;width:450px;height:480px">
                    <img src="${pageContext.request.contextPath }/img/1.jpg" style="width:450px;height:450px" id="ImgModelView"/>
                </div>
            </div>
        </div>
    </div>
    <button type="button" id="ImgModal" hidden="hidden" data-toggle="modal" data-target="#ImageModal">
        Launch input modal
    </button>
    <!------------------- 图片模态框结束 --------------------->
    <!------------------ 文本模态框 ------------------>
    <form action="${pageContext.request.contextPath }/article/create.action" method="post" enctype="multipart/form-data">
    	<div class="modal fade" id="ArticleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	        <div class="modal-dialog modal-dialog-centered" role="document">
	            <div class="modal-content">
	                <div class="modal-header">
	                    <h5 id="ArticleModelTitle" class="modal-title">新增</h5>
	                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                        <span aria-hidden="true">&times;</span>
	                    </button>
	                </div>
	                <div class="modal-body" style="text-align:center">
	                    <img src="${pageContext.request.contextPath }/img/upload.jpg" class="uploadpic" id="sImg" onclick="$('#uploadImg').click()">
	                    <input type="file" name="uploadImg" id="uploadImg" hidden="hidden" onchange="showImg(this,'sImg')" accept="jpg"/>
	                    <br>
	                    <input class="form-control" name="describe" maxlength="50" placeholder="标题"></input>
	                    <br/>
	                    <textarea class="form-control" rows="4" name="content" placeholder="内容"></textarea>
	                </div>
	                <div class="modal-footer">
	                    <button type="button" onclick="$('#uploadBtn').click()" class="btn btn-success" data-dismiss="modal">保存</button>
	                    <input type="submit" id="uploadBtn" hidden="hidden"/>
	                    <button type="button" class="btn btn-danger"  data-dismiss="modal">取消</button>
	                </div>
	            </div>
	        </div>
	    </div>
    </form>
   	
    <!-- button -->
    <button type="button" id="ArticlePop" hidden="hidden" data-toggle="modal" data-target="#ArticleModal">
        Launch input modal
    </button>
    <!------------------- 文本模态框结束 --------------------->
</body>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
	    var mode = 'PC';//客户端类型
	    var basePath = "${pageContext.request.contextPath}";//根路径
	    //timeline:建立时间轴
	    //article:建立文章
	    var typeType = '';
	    //文章ID
	    var articleId = '';
	    $('[data-toggle="tooltip"]').tooltip()//注册气泡提示框
	    try {
	        if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
	            mode = 'phone';
	        } else {
	            mode = 'PC';
	        }
	    } catch (e) { }
		
	    //弹出提示模态框
	    function PopDialog(title, content) {
	        $('#PopModelLabel').text(title);
	        $('#PopModelContent').html(content);
	        $('#PopModel').click();
	    }
	    //弹出输入模态框
	    function InputDialog(title,type){
	    	$('#InputModelLabel').text(title);
	    	typeType = type;
	        $('#inputModal').click();
	    }
	    //弹出图片模态框
	    function ImageDialog(path){	    	
	    	$('#ImgModelView').attr("src","/image/"+path);
	        $('#ImgModal').click();
	    }
	    //弹出文本模态框
	    function TextDialog(title,type){
	    	$('#ArticleModelTitle').text(title);
	    	typeType = type;
	        $('#ArticlePop').click();
	    }
	    //顶部提示
	    function AlertMsg(msg) {
	        $('#AlertDiv').text(msg);
	        ByDegress('AlertDiv', 1);
	        setTimeout(ByDegress('AlertDiv', 0), 2000);
	    }
	    //模态框确认按钮
	    function Create(){
	    	switch(typeType){
	    		case 'timeline':
	    	    	let name = $('#InputModelText').val();
	    	    	$('#InputModelText').val('');
	    			window.location.href = basePath + '/timeline/create.action?name='+name;
	    		break;
	    		case 'delArticle':
	    			location.href = basePath + '/article/delete.action?aid='+articleId;
    			break;
	    		case 'authory':
	    	    	let key = $('#InputModelText').val();
	    	    	$('#InputModelText').val('');
	    			setAuth(key);
    			break;
	    	}
	    }
	    //预览图片
	    function showImg(fileObj,imgId) {
	    	console.log(fileObj)
	    	console.log(fileObj.file)
	        var file=fileObj.files[0];
               var r = new FileReader();
                    r.readAsDataURL(file);
                    $(r).on("load",function() {
                        $('#'+imgId).attr("src", this.result);
                })
	    }
	    //设置密码
	    function setAuth(auth){
	    	document.cookie = "auth="+auth;
	    }
	    //获取密码
	    function getAuth(){
	    	let coo = document.cookie;
	    	return coo.split(';')[0].split('=')[1];
	    }
	    //动画 id:主体ID type：模式——0：消失 1：显示 mode:类别 class
	    function ByDegress(id, type) {
	        let o = $('#' + id).css('opacity');
	        let opa = parseFloat(o);
	        switch (type) {
	            case 0:
	                if (opa > 0) {
	                    //console.log('0------------' + opa);
	                    setTimeout(function () {
	                        //不透明度-0.1
	                        opa -= 0.1;
	                        $('#' + id).css('opacity', opa);
	                        ByDegress(id, 0);//递归
	                    }, 100);
	                }
	                break;
	            case 1:
	                if (opa < 1) {
	                    //console.log('1------------' + opa);
	                    setTimeout(function () {
	                        //不透明度+0.1
	                        opa += 0.1;
	                        $('#' + id).css('opacity', opa);
	                        ByDegress(id, 1);//递归
	                    }, 100);
	                }
	                break;
	        }
	        return;
	    }
	</script>
</html>