$(function(){
	$(".link").mouseover(function(){
		$(this).css("color","#FF3030")
	})
	$(".link").mouseout(function(){
		$(this).css("color","#080808")
	})
	//根据登录者的UID和查询对象的UID判断当前是否为登陆者的主页
	if(luid == uuid){
		$(".rightSize").css("display","block")
		$("#pd1").css("display","none")
		$("#pd2").css("display","block")
	}else{
		$(".rightSize").css("display","none")
		$("#pd1").css("display","block")
		$("#pd2").css("display","none")
	}
	//根据是否已关注该作者显示不同div
	if(isFollow == "true"){
		$("#followed").css("display","block")
		$("#unFollow").css("display","none")
	}else{
		$("#followed").css("display","none")
		$("#unFollow").css("display","block")
	}
	//关注作者时先登录
	$("#unFollow").mouseup(function(){
		if(luid == null || luid == ""){
			msg("请先登录")
		}else{
			$.post(basePath+"/followAuthor.action",
					{uuid:uuid},
					function(data){
						if(data == "followed" ){
							msg("关注成功")
							$("#followed").css("display","block")
							$("#unFollow").css("display","none")
						}
					});
		}
	})
	//取消关注
	$("#followed").mouseup(function(){
		$.post(basePath+"/cancelFollow.action",
				{uuid:uuid},
				function(data){
					if(data == "cancel"){
						msg("已取消")
						$("#followed").css("display","none")
						$("#unFollow").css("display","block")
					}
				})
	})
	//留言
	$("#comment").mouseup(function(){
		if(luid == null || luid == ""){
			msg("请先登录")
		}else{
				var con = prompt("请输入你的留言:")
				if(con != null && con != ""){
					$.post(basePath+"/addComment.action",
							{uuid:uuid,
							uname:uname,
							content:con},
							function(){})
			}
		}
	})
	//进入读者列表
	$("#readerList").mouseup(function(){
		location.href = basePath + "/readerList.action"
	})
	//进入关注列表
	$("#followList").mouseup(function(){
		location.href = basePath + "/followList.action"
	})
	//进入草稿列表
	$("#draftList").mouseup(function(){
		location.href = basePath + "/draftList.action"
	})
	//进入收藏列表
	$("#collectList").mouseup(function(){
		location.href = basePath + "/collectList.action"
	})
	//前往创建专题
	$("#createTheme").mouseup(function(){
		location.href = basePath + "/toCreateTheme.action"
	})
})
//进入文章
function article(id,isPerson){
	location.href = basePath + "/common/article.action?id="+id+"&isPerson="+isPerson
}
//进入文集列表
function corpus(coid){
	location.href = basePath + "/corpusList.action?coid="+coid
}
//进入专题
function enterTheme(tid){
	location.href = basePath + "/common/theme.action?tid="+tid
}