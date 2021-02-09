$(function(){
	//控制连接颜色变化
	$(".link0").mouseover(function(){
		$(this).css("color","#FF3030")
	})
	$(".link0").mouseout(function(){
		$(this).css("color","#EE7942")
	})
	//控制连接跳转
	$("#mainPage").mouseup(function(){
		location.href = basePath+"/common/creative.action"
	})
	$("#login").mouseup(function(){
		location.href = basePath+"/common/login.action?md=l&page="+beforePage
	})
	$("#register").mouseup(function(){
		location.href = basePath+"/common/login.action?md=r&page="+beforePage
	})
	//根据用户是否登录展示登录模块或者用户头像
	
	if(user == null || user == ""){
		$("#unlogin1").css("display","block")
		$("#unlogin2").css("display","block")
		$("#user").css("display","none")
	}else{
		$("#unlogin1").css("display","none")
		$("#unlogin2").css("display","none")
		$("#user").css("display","block")
	}
	if(img == null || img == ""){
		$("#headerImg").attr("src","/image/default.jpg")
	}else{
		$("#headerImg").attr("src","/image/"+img)
	}
	//鼠标移动头像显示窗口
	$("#user").mouseover(function(){
		$("#myDiv").css("display","block")
	})
	$("#user").mouseout(function(){
		$("#myDiv").css("display","none")
	})
	$("#myDiv").mouseover(function(){
		$("#myDiv").css("display","block")
	})
	$("#myDiv").mouseout(function(){
		$("#myDiv").css("display","none")
	})
	$("#mask").click(function(){
		$("#mask").css("display","none")
	})
	$("#searchDiv").keyup(function(e){
		if(e.keyCode == 13){
			var word = $(this).val()
			location.href = basePath+"/common/search.action?word="+word
		}
	})
})
//全局函数：弹出消息
function msg(con){
	$("#mask").css("display","block")
	$("#meg").text(con)
}
