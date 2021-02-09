<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录注册页</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>
	var m = "${md}"
		//判断表单是否提交
	function checkL(){
		var prompt = "同户名不能为空"
		if($("#name1").val() != null && $("#name1").val() != ""){
			prompt = "密码必须大于5位"
			if($("#word1").val().length >= 6){
				return true;
			}
		}
		msg(prompt)
		return false;
	}
	function checkR(){
		var prompt = "同户名不能为空"
		if($("#name2").val() != null && $("#name2").val() != ""){
			prompt = "密码必须大于5位"
			if($("#word2").val().length >= 6){
				prompt = "请输入相同密码"
				if($("#word2").val() == $("#word22").val()){
					return true;
				}
			}
		}
		msg(prompt)
		return false;
	}
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
<style>
	.link{
		color:#EEB422;
	}
</style>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<div style="width:40%;height:420px;margin-top:80px;margin-left:30%;margin-right:30%">
		
		<div style="width:100%;height:30%;text-align:center">
			<br/><br/>
			<font class="link" id="loginL" size="5">登录</font>·<font class="link" id="registerL" size="5">注册</font>
			<br/><br/><hr/>
		</div>
		<!-- 登录界面 -->
		<div id="loginD" style="width:100%;height:70%;display:block">
			<form action="${pageContext.request.contextPath}/common/loginUser.action" method="post" style="width:100%;height:100%" onsubmit="return checkL()">
				<table style="width:100%;height:100%">
					<tr height="30%">
						<td style="width:40%;text-align:right">
							用户名:
						</td>
						<td style="width:60%;text-align:left">
							<input type="text" name="username" value="${username}" id="name1" style="border-radius:9px">
							<span id="ns1">${loginMsg }</span>
						</td>
					</tr>
					<tr height="40%">
						<td style="width:30%;text-align:right">
							密    码:
						</td>
						<td style="width:60%;text-align:left">
							<input type="password" name="password" id="word1" style="border-radius:9px">
							<span id="ws1"></span>
						</td>
					</tr>
					<tr height="30%">
						<td style="width:100%;text-align:center" colspan="2">
							<input type="submit" value="登录">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<!-- 注册界面 -->
		<div id="registerD" style="width:100%;height:70%;display:none;">
			<form action="${pageContext.request.contextPath}/common/registerUser.action" method="post" style="width:100%;height:100%" onsubmit="return checkR()">
				<table style="width:100%;height:100%">
					<tr height="20%">
						<td style="width:40%;text-align:right">
							用户名:
						</td>
						<td style="width:60%;text-align:left">
							<input type="text" name="username" id="name2" style="border-radius:9px">
							<span id="ns2"></span>
						</td>
					</tr>
					<tr height="20%">
						<td style="width:40%;text-align:right">
							密码:
						</td>
						<td style="width:60%;text-align:left">
							<input type="password" name="password" id="word2" style="border-radius:9px">
							<span id="ws2"></span>
						</td>
					</tr>
					<tr height="20%">
						<td style="width:40%;text-align:right">
							确认密码:
						</td>
						<td style="width:60%;text-align:left">
							<input type="password" id="word22" style="border-radius:9px">
							<span id="ws22"></span>
						</td>
					</tr>
					<tr height="30%">
						<td style="width:100%;text-align:center" colspan="2">
							<input type="submit"  value="注册">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>