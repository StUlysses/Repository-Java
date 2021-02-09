$(function(){
		//初始化界面
		if(m == 'l'){
			isLogin()
		}else if(m == 'r'){
			isRegister()
		}
		$(".link").mouseover(function(){
			$(this).css("color","#FF3030")
		})
		$(".link").mouseout(function(){
			$(this).css("color","#EEB422")
		})
		
		$("#registerL").mouseup(function(){
			isRegister()
		})
		$("#loginL").mouseup(function(){
			isLogin()
		})
		//显示登录界面
		function isLogin(){
			$("#registerD").css("display","none")
			$("#loginD").css("display","block")
		}
		//显示注册界面
		function isRegister(){
			$("#loginD").css("display","none")
			$("#registerD").css("display","block")
		}
		//用户名密码提示信息
		$("#name1").blur(function(){
			var con = $("#name1").val()
			if(con == null || con == ''){
				$("#ns1").text("用户名不能为空")
			}else{
				$("#ns1").text("")
			}
		})
		$("#name2").blur(function(){
			var con = $(this).val()
			if(con == null || con == ''){
				$("#ns2").text("用户名不能为空")
			}else{
				$("#ns2").text("")
			}
		})
		$("#word1").keyup(function(){
			var con = $(this).val()
			if(con.length < 6){
				$("#ws1").text("密码长度必须大于5位")
			}else{
				$("#ws1").text("")
			}
		})
		$("#word2").keyup(function(){
			var con = $(this).val()
			if(con.length < 6){
				$("#ws2").text("密码长度必须大于5位")
			}else{
				$("#ws2").text("")
			}
		})
		$("#word22").keyup(function(){
			var con = $(this).val()
			var word = $("#word2").val()
			if(con == word){
				$("#ws22").text("")
			}else{
				$("#ws22").text("请输入相同密码")
			}
		})
	
	})