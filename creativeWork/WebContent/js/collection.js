$(function(){
	$(".link").mouseover(function(){
		$(this).css("color","#FF3030")
	})
	$(".link").mouseout(function(){
		$(this).css("color","#080808")
	})
})

function article(id){
	location.href = basePath + "/common/article.action?id="+id
}