<%@page import="org.springframework.http.HttpRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>
	var basePath = "${pageContext.request.contextPath}"
	var user = "${logined}"
	var img = "${logined.photo}"
	var suid = "${logined.uid}"
	var beforePage = location.href
</script>
<script src="${pageContext.request.contextPath}/js/header.js"></script>
<style>
	.link0{color:#EE7942}
	a{text-decoration:none}
</style>
</head>
<body>
	<table style="width:100%;height:45px">
		<tr height="100%">
			<td style="width:35%;text-align:left">
				<font id="mainPage" size="6px" color="#EE7600">创点</font>
			</td>
			<%
			String word = request.getParameter("search");
			if(word == null){
				word = "";
			}
			%>
			<td style="width:55%;text-align:lift">
				<!-- <input style="border-radius:9px" size="30" type="text" value="搜索"> -->
				<input type="text" id="searchDiv"style="border-radius:9px;width: 400px" value="<%=word%>"></input>
			</td>
			<!-- 未登录时展示模块 -->
			<td width="5%">
				<div style="width:100%;color:#EE7942;font-size:20px;text-align:center" id="unlogin1">
					<font id="login">登陆</font>
				</div>
			</td>
			<td width="5%">
				<div style="width:100%;color:#EE7942;font-size:20px;text-align:center" id="unlogin2">
					<font id="register">注册</font>
				</div>
			</td>
			<!-- 已登录时展示模块 -->
			<td></td>
			<td id="user">
				<div style="width:100%;height:100%">
					<img id="headerImg" style="border-radius:25px;width:50px;height:50px"/> 
				</div>
			</td>
		</tr>
	</table>
	<div id="myDiv" style="position:absolute;left:1450px;top:1;width:80px;height:150px;border:1px blue solid;display:none">
						<table style="width:100%;height:150px">
							<tr height="20px">
								<td style="width:100%;text-align:center">
									<a href="${pageContext.request.contextPath}/creating.action?keepEdit=no"><font class="link0">创作</font></a>
								</td>
							</tr>
							<tr height="20px">
								<td style="width:100%;text-align:center">
									<a href="${pageContext.request.contextPath}/myComment.action"><font class="link0">消息</font></a>
								</td>
							</tr>
							<tr height="20px">
								<td style="width:100%;text-align:center">
									<a href="${pageContext.request.contextPath}/common/person.action?suid=${logined.uid}"><font class="link0">主页</font></a>
								</td>
							</tr>
							<tr height="20px">
								<td style="width:100%;text-align:center">
									<a href="${pageContext.request.contextPath}/personSetting.action"><font class="link0">设置</font></a>
								</td>
							</tr>
							<tr height="20px">
								<td style="width:100%;text-align:center">
									<a href="${pageContext.request.contextPath}/exitUser.action"><font class="link0">退出</font></a>
								</td>
							</tr>
						</table>
	</div>
	<div id="mask" style="width:100%;height:600px;position:absolute;left:0;top:0;display:none;z-index:1">
		<div style="width:30%;height:100px;position:absolute;left:35%;top:300px;border-radius:10px;
	background-color:#9AC0CD;font-size:27px;text-align:center;line-height:95px;z-index:2" id="meg"></div>
	</div>
	
</body>
</html>