<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${logined.username}的关注列表</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>
	var basePath = "${pageContext.request.contextPath}"
</script>
<style>
	.link{color:#080808}
</style>
<script src="${pageContext.request.contextPath}/js/followList.js"></script>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	
	<div style="width:70%;height:675px;margin-left:15%;margin-right:15%;border:1px blue solid">
		<h3 style="text-align:center">关注列表</h3>
		<c:forEach items="${follows}" var="i">
			<div>
				<div style="width:60%;height:50px;line-height:50px;float:left" onclick="person(${i.uid})">
					&#8195;
					<img  style="border-radius:15px;width:40px;height:40px" src="${pageContext.request.contextPath}/image/${i.photo}">
					&#8195;
					<font class="link" size="4">${i.username}</font>
					&#8195;
					<font size="3">${i.info}</font>
				</div>
				<div style="width:30%;height:60px;line-height:60px;float:left">
					<font class="link" size="4">留言</font>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>