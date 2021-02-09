$(function(){
	$(".link").mouseover(function(){
		$(this).css("color","#FF3030")
	})
	$(".link").mouseout(function(){
		$(this).css("color","#080808")
	})
	
})
function article(id,isPerson){
	location.href = basePath+"/viewDraft.action?id="+id+"&isPerson="+isPerson
}