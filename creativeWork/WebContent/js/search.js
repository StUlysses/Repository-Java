$(function(){
	$(".link").mouseover(function(){
		$(this).css("color","#FF3030")
	})
	$(".link").mouseout(function(){
		$(this).css("color","#080808")
	})
	$("#clear").mouseup(function(){
		var con = confirm("确定清空历史记录吗?")
		if(con){
			$.post(basePath+"/common/clearHistory.action",
					{},
					function(data){
						if(data == "success"){
							$("#divH").empty()
						}
					})
		}
	})
})
//进入用户主页
function person(uid){
	location.href = basePath + "/common/person.action?suid="+uid
}
//进入文章页面
function article(id){
	location.href = basePath + "/common/article.action?id="+id
}
//搜索该关键字
function search(word){
	location.href = basePath+"/common/search.action?word="+word
}
//进入专题
function theme(tid){
	location.href = basePath + "/common/theme.action?tid="+tid
}