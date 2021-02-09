$(function(){
	$(".link").mouseover(function(){
		$(this).css("color","#FF3030")
	})
	$(".link").mouseout(function(){
		$(this).css("color","#080808")
	})
	$("#removeCorpus").mouseup(function(){
		var warn = confirm("确认删除文集吗？\n此操作不会删除集内的文章")
		if(warn){
			location.href = basePath + "/removeCorpus.action?coid="+coid
		}
	})
})
//进入文章
function article(id,isPerson){
	location.href = basePath + "/common/article.action?id="+id+"&isPerson="+isPerson
}
//从文集中移除文章
function removeCorpusContent(aid,coid){
	var warn = confirm("确认删除此文章吗?")
	if(warn){
		location.href = basePath + "/removeCorpusContent.action?aid="+aid+"&coid="+coid
	}
}