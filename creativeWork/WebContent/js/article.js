$(function(){
	$(".link").mouseover(function(){
		$(this).css("color","#ff3030")
	})
	$(".link").mouseout(function(){
		$(this).css("color","#080808")
	})
	//判断浏览者是否登录
	if(lid == null || lid == ""){
		$("#logined").css("display","none")
	}else if(aid == lid){//判断浏览者是否为作者本人
		if(draftId == "0"){
			$("#submit").css("display","block")
		}
		$("#edit").css("display","block")
		$("#collect").css("display","none")
		$("#unCollect").css("display","none")
		//判断是否从个人主页过来
		if(isPerson == "person"){
			$("#drop").css("display","block")
		}else{
			$("#drop").css("display","none")
		}
	}else{
		$("#edit").css("display","none")
		//判断是否已收藏
		if(isCollect == "collected"){
			$("#unCollect").css("display","block")
			$("#collect").css("display","none")
		}else{
			$("#collect").css("display","block")
			$("#unCollect").css("display","none")
		}
	}
	//编辑文章
	$("#edit").mouseup(function(){
		location.href = basePath + "/creating.action?keepEdit=yes"
	})
	//删除文章
	$("#drop").mouseup(function(){
		var bool = confirm("确认删除吗？")
		if(bool == true){
			location.href = basePath + "/dropArticle.action"
		}
	})
	//收藏
	$("#collect").mouseup(function(){
		$.get(basePath+"/collectArticle.action",
				{},
				function(data){
					if(data == "success"){
						msg("收藏成功")
						$("#collect").css("display","none")
						$("#unCollect").css("display","block")
					}
				});
	})
	//取消收藏
	$("#unCollect").mouseup(function(){
		$.get(basePath+"/cancelCollect.action",
				{},
				function(data){
					if(data == "success"){
						msg("取消收藏成功")
						$("#collect").css("display","block")
						$("#unCollect").css("display","none")
					}
				})
	})
	//投稿
	$("#submit").mouseup(function(){
		location.href = basePath + "/toSubmit.action"
	})
	//评论操作
	$("#comment").keyup(function(e){
		if(lid == null || lid == ""){
			msg("请先登录")
		}else if(e.keyCode == 13){
			var con = $(this).val()
			$(this).val(null)
			$("#comDiv").append("<div class='com'>"+"<span onclick='person("+lid+")'>"+lname+"</span>"+":"+con+"</div>")
			$('html,body').animate({scrollTop:$('#comDiv').offset().top}, 800)
			$.post(basePath + "/addReview.action",
					{
						sid:lid,
						sname:lname,
						content:con,
						lid:aid,
						belong:artId,
						title:title
					},
					function(){})
		}
	})
})
//跳转作者主页
function person(suid){
	location.href = basePath+"/common/person.action?suid="+suid
}
//进入专题
function theme(tid){
	location.href = basePath + "/common/theme.action?tid="+tid
}