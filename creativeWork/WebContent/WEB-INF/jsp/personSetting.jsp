<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${logined.username}的个人设置</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>
	var basePath = "${pageContext.request.contextPath}"
	var img = "${logined.photo}"
	var sex = "${logined.sex}"
</script>
<script src="${pageContext.request.contextPath}/js/personSetting.js"></script>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/setting.action" method="post" enctype="multipart/form-data">
		<table style="width:40%;height:450px;margin-top:40px;margin-left:30%;margin-right:30%;border:1px blue solid">
			<tr>
				<td>头像:</td>
				<td>
					<img id="img1" style="border-radius:25px;width:50px;height:50px">
					<input type="file" name="photo1"/>
				</td>
			</tr>
			<tr>
				<td>性别:</td>
				<td>
					<input type="radio" name="sex1" id="man" value="男"/>男
					<input type="radio" name="sex1" id="woman" value="女"/>女
				</td>
			</tr>
			<tr>
				<td>简介:</td>
				<td>
					<textarea rows="5" style="border-radius:9px;width:300px" name="info1" maxlength="100">${logined.info}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center">
					<input type="submit" value="保存">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>