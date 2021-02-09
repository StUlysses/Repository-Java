$(function(){
	if(img == null || img == ""){
		$("#img1").attr("src",basePath+"/image/default.jpg")
	}else{
		$("#img1").attr("src",basePath+"/image/"+img)
	}
	if(sex == "男"){
		$("#man").attr("checked",true)
	}
	if(sex == "女"){
		$("#woman").attr("checked",true)
	}
})