$(function(){
	$(".link").mouseover(function(){
		$(this).css("color","#FF3030")
	})
	$(".link").mouseout(function(){
		$(this).css("color","#080808")
	})
	
})
//收录文章
function accept(aid,title,collectNum,size){
	$.post(basePath+"/accept.action",
			{aid:aid,
			title:title},
			function(data){
				if(data == "success"){
					$("#"+aid).empty()
					$("#"+aid).text("已收录")	
				}
			})
}
//拒绝文章
function object(aid,title){
	$.post(basePath+"/object.action",
			{aid:aid,
			title:title,},
			function(data){
				if(data == "success"){
					$("#"+aid).empty()
					$("#"+aid).text("已拒绝")
				}
			})
}
//进入文章
function article(id,isPerson){
	location.href = basePath + "/common/article.action?id="+id+"&isPerson="+isPerson
}