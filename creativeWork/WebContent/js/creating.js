$(function(){
	openCorpusList()
	//根据选择改变字号
	$("#fontSize").change(function(){
		var s = this.value+"px"
		$("#content").css("font-size",s)
	})
	//根据选择保存或新建文集
	$("#corpusList").change(function(){
		var con = $(this).val()
		//创建文集
		if(con == "newCorpus"){
			var name = prompt("请输入文集名","new corpus")
			if(name != null && name != ""){
				$.post(basePath+"/newCorpus.action",
						{name:name},
						function(data){
							if(data == "success"){
								msg("创建成功")
								openCorpusList()
							}
							if(data == "fail"){
								msg("只能创建5个文集")
							}
							if(data == "error"){
								msg("创建失败，请稍后再试")
							}
						})
			}
			
		}
		//保存到文集
		if(con != "newCorpus" && con != ""){
			$.post(basePath+"/saveToCorpus.action",
					{coid:con},
					function(data){
						if(data == "success"){
							msg("保存成功")
						}
						if(data == "fail"){
							msg("草稿不能保存")
						}
						if(data == "nameError"){
							msg("该文章已经保存过了")
						}
						if(data == "error"){
							msg("保存失败，请稍后再试")
						}
					})
		}
	})
	$("#newCorpus").mouseup(function(){

	})
})
//保存草稿
function saveArticle(){
	var title = $("#title").val()
	var content = $("#content").val()
	if(checkIsEmpty()){
		$.get(basePath+"/saveDraft.action",
				{
					title:title,
					content:content
				},
				function(data){
					if(data == "success"){
						msg("保存成功")
					}
				});
	}else{
		msg("标题和内容都不能为空")
	}

}
//进入页面时查询文集
function openCorpusList(){
	$.get(basePath+"/findCorpus.action",
			{},
			function(data){
				$("#corpusList").html("<option value=''>-选择文集-</option>")
				$("#corpusList").append("<option value='newCorpus'>-新建文集-</option>")
				$(data).each(function(index,c){
					$("#corpusList").append("<option value='"+c.coid+"'>"+c.coname+"</option>")
				})
			},
			"json")
}
//检查内容是否为空
function checkIsEmpty(){
	var title = $("#title").val()
	var content = $("#content").val()
	if(title == null || title == ""){
		return false
	}
	if(content == null || content == ""){
		return false
	}
	return true
}