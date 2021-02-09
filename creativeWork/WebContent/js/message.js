$(function(){
	$(".link").mouseover(function(){
		$(this).css("color","#FF3030")
	})
	$(".link").mouseout(function(){
		$(this).css("color","#080808")
	})
	$("#myComment").mouseup(function(){
		location.href = basePath + "/myComment.action"
	})
	$("#myReview").mouseup(function(){
		location.href = basePath + "/myReview.action"
	})
	$("#sendComment").mouseup(function(){
		location.href = basePath + "/sendComment.action"
	})
	$("#sendReview").mouseup(function(){
		location.href = basePath + "/sendReview.action"
	})
	$("#systemMsg").mouseup(function(){
		location.href = basePath + "/systemMsg.action"
	})
})