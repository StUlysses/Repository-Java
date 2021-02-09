<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${logined.username}的个人创作</title>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>
	var basePath = "${pageContext.request.contextPath}"
</script>
<script src="${pageContext.request.contextPath}/js/creating.js"></script>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/publishArticle.action" method="post" onsubmit="return checkIsEmpty()">
	<table style="width:70%;height:675px;margin-left:15%;margin-right:15%">
		<tr height="50px">
			<td width="50%">
			</td>
			<td width="50%" style="text-align:right">
				<font>字号:</font>
				<select id="fontSize">
					<option value="20">20</option>
					<option value="25">25</option>
					<option value="30">30</option>
					<option value="35">35</option>
					<option value="40">40</option>
				</select>
				<span onclick="saveArticle()">保存草稿</span>
				保存到
				<select id="corpusList"></select>
				
				<input type="submit" value="发布" />
			</td>
		</tr>
		<tr height="50px">
			<td colspan="2" style="text-align:center">
				<textarea rows="1" name="title" id="title" style="width:100%;height:100%;font-size:35px;line-height:40px;text-align:center"><c:if test="${keepEdit == 'yes'}">${arti.title}</c:if></textarea>
			</td>
		</tr>
		<tr height="525px">
			<td colspan="2" width="100%">
				<textarea name="content" id="content" style="width:100%;height:100%;font-size:20px;line-height:40px"><c:if test="${keepEdit == 'yes'}">${arti.content }</c:if></textarea>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>