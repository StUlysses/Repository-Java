$(function(){
	$(".link").mouseover(function(){
		$(this).css("color","#FF3030")
	})
	$(".link").mouseout(function(){
		$(this).css("color","#080808")
	})
	
})
function person(uid){
	location.href = basePath+"/common/person.action?suid="+uid
}