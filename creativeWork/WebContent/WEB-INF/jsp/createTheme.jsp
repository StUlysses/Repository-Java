<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新建专题</title>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	var basePath = "${pageContext.request.contextPath}"
</script>
<script src="${pageContext.request.contextPath}/js/createTheme.js"></script>
<style>
	.in{
		border-radius:9px;
		width:70%
	}
	.title{
		width:30%;
		text-align:right
	}
</style>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/createTheme.action" method="post" onsubmit="return checkTname()">
		<table style="width:40%;height:440px;margin-left:30%;margin-right:30%;border:1px black solid">
			<tr height="120px">
				<td class="title">专题名:</td>
				<td>
					<input id="tname" class="in" type="text" name="tname"/><span id="prompt"></span>
				</td>
			</tr>
			<tr height="140px">
				<td class="title">简介:</td>
				<td>
					<textarea rows="5" class="in" name="info"></textarea>
				</td>
			</tr>
			<tr height="140px">
				<td class="title">公告:</td>
				<td>
					<textarea rows="5" class="in" name="bulletin"></textarea>
				</td>
			</tr>
			<tr height="40px">
				<td colspan="2" style="text-align:center">
					<input type="submit" value="创建">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>