$(function(){
	$(".link").mouseover(function(){
		$(this).css("color","#FF3030")
	})
	$(".link").mouseout(function(){
		$(this).css("color","#080808")
	})
	if(tuid == uuid){//如果用户就是专题创建者
		$("#editTheme").css("display","block")
		$("#manager").css("display","none")
	}else{
		$("#editTheme").css("display","none")
		$("#manager").css("display","block")
	}
	//判断是否订阅
	if(isFol == "yes"){
		$("#unfollow").css("display","none")
		$("#followed").css("display","block")
	}else if(isFol =="no"){
		$("#unfollow").css("display","block")
		$("#followed").css("display","none")
	}
	//点击编辑按钮打开关闭菜单
	$("#edit").mouseup(function(){
		$("#menu").fadeToggle(500)
	})
	//进入来稿审核页面
	$("#review").mouseup(function(){
		location.href=basePath + "/reView.action?tname="+tname
	})
	//编辑公告
	$("#editBulletin").mouseup(function(){
		$("#menu").fadeOut(500)
		var pro = prompt("请输入新的公告")
		if(pro != "" && pro != null){
			$.post(basePath+"/editBulletin.action",
					{bulletin:pro,
					uid:tuid},
					function(data){
						if(data == "success"){
							msg("发布成功")
							$("#bulletin").text(pro)
						}
					})
		}		
	})
	//删除专题
	$("#removeTheme").mouseup(function(){
		$("#menu").fadeOut(500)
		var con = confirm("确认删除吗?")
		if(con){
			location.href = basePath+"/removeTheme.action?uid="+tuid
		}
	})
	//订阅专题
	$("#unfollow").mouseup(function(){
		if(uuid == null || uuid == ""){
			msg("请先登录")
		}else{
			$.post(basePath+"/followTheme.action",
					{uid:uuid},
					function(data){
						if(data == "success"){
							msg("订阅成功")
							$("#unfollow").css("display","none")
							$("#followed").css("display","block")
						}
					})
		}
	})
	//取消订阅专题
	$("#followed").mouseup(function(){
		$.post(basePath+"/cancelFollowTheme.action",
				{uid:uuid},
				function(data){
					if(data == "success"){
						msg("取消订阅")
						$("#unfollow").css("display","block")
						$("#followed").css("display","none")
					}
				})
	})
})
//进入文章
function article(id,isPerson){
	location.href = basePath + "/common/article.action?id="+id+"&isPerson="+isPerson
}