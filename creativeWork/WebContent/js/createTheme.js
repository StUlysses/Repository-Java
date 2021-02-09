$(function(){
	$("#tname").keyup(function(){
		var con = $(this).val()
		$.post(basePath+"/tnameTest.action",
				{tname:con},
				function(data){
					if(data == "yes"){
						$("#prompt").text("该名称可用")
					}
					if(data == "no"){
						$("#prompt").text("该名称不可用")
					}
				})
	})
})
function checkTname(){
	var con = $("#prompt").text()
	if(con == "该名称可用"){
		return true
	}else{
		return false
	}
}