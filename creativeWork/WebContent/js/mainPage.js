$(function(){
	$(".link").mouseover(function(){
		$(this).css("color","#FF3030")
	})
	$(".link").mouseout(function(){
		$(this).css("color","#080808")
	})

	timeSet(0)
	
})
//进入文章
function article(id){
	location.href = basePath + "/common/article.action?id="+id
}
//广告动画效果
function timeSet(i){
	i = (i+1)%3+1
	setTimeout("showAd1("+i+")",5000)
}
function showAd1(i){
	$("#adImg").attr("src",basePath + "/ad/"+i+".jpg")
	$("#adImg").css("opactity","0")
	$("#adImg").css("width","0")
	
	$("#adImg").animate({
						width:'100%',
						opacity:'1'
						},2000,timeSet(i))
}
function showAd2(i){
	if(i == 3){
		i = 1;
	}else{i++}
	$("#adImg").attr("src",basePath + "/ad/"+i+".jpg")
	$("#adImg").css("opactity","0")
	$("#adImg").css("width","0")
	
	$("#adImg").animate({
						width:'100%',
						opacity:'1'
						},2000)
	setTimeout("timeSet()",2000)
}