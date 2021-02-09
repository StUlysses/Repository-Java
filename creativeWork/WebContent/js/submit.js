$(function(){
	$(".link").mouseover(function(){
		$(this).css("color","#FF3030")
	})
	$(".link").mouseout(function(){
		$(this).css("color","#080808")
	})
	//进入文章
	$("#article").mouseup(function(){
		location.href = basePath + "/common/article.action?id="+aid
	})
	//回车搜素
	$("#word").keyup(function(e){
		if(e.keyCode == 13){
			var con = $(this).val()
			location.href = basePath+"/searchTheme.action?tname="+con
		}
	})
})
//进入专题
function theme(tid){
	location.href = basePath + "/common/theme.action?tid="+tid
}
//投稿
function submit(tid,tname){
	msg(tid+"......"+tname)
	$.post(basePath + "/submit.action",
			{tid:tid,
			tname:tname},
			function(data){
				if(data == "success"){
					msg("投稿成功，请等待系统通知")
				}
				if(data == "fail"){
					msg("请勿重复投稿")
				}
			})
}