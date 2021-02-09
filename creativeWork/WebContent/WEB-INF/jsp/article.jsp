<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${arti.title }</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>
	var basePath = "${pageContext.request.contextPath}"
	var lid = "${logined.uid}"
	var lname = "${logined.username}"
	var aid = "${arti.uid}"
	var artId = "${arti.id}"
	var title = "${arti.title}"
	var isPerson = "${isPerson}"
	var isCollect = "${isCollect}"
	var draftId = "${draftId}"
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/article.js"></script>
<style>
	.link{color:#080808}
	.com{
		width:100%;
		height:30px;
		line-height:30px;
		text-align:left
	}
</style>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<table style="width:70%;height:675px;margin-left:15%;margin-right:15%">
		<tr height="30px">
			<td style="text-align:center">
				<font size="10px">${arti.title }</font>
			</td>
		</tr>
		<tr height="20px">
			<td >
				<div style="margin-left:70%" onclick="person(${arti.uid})">
					<font class="link" size="5px">${arti.username }</font>
				</div>
				<br/>
				<br/>
			</td> 
		</tr>
		<tr height="400px">
			<td width="100%">
				<div style="width:1000px;height:100%;font-size:18px;line-height:40px;word-wrap:break-word">
				${arti.content }
				</div>
			</td>
		</tr>
		<!-- 被哪些专题收录 -->
		<tr height="30px">
			<td style="width:100%;text-align:right">
				<c:forEach items="${beforTheme}" var="i">
					<span style="font-size:16px" onmouseup="theme(${i.tid})">${i.tname}</span>
				</c:forEach>
			</td>
		</tr>
		<tr height="30px">
			<td style="width:100%">
				<div id="logined" style="margin-left:80%">
					<font class="link" id="drop" size="4px" style="float:left;display:none">删除&#8195;</font>
					<font class="link" id="edit" size="4px" style="float:left">&#8195;编辑&#8195;</font>
					<font class="link" id="submit" size="4px" style="float:left;display:none">&#8195;投稿&#8195;</font>					
					<font class="link" id="collect" size="4px">&#8195;收藏</font>
					<font class="link" id="unCollect" size="4px">&#8195;取消收藏</font>
				</div>
			</td>
		</tr>
		<!-- 评论 -->
		<tr>
			<td>
				<div style="width:70%;height:40px;margin-left:30%;text-align:left">
					<c:if test="${logined.username != null}">${logined.username}</c:if>
					<c:if test="${logined.username == null}">游客</c:if>
					:<input type="text" id="comment" style="border-radius: 9px;width:400px">
				</div>
				<div id="comDiv" style="width:70%;;margin-left:30%;text-align:center">
					<c:forEach items="${comments}" var="i">
						<div class='com'>
							<span onmouseup='person(${i.sid})'>${i.sname }</span>:${i.content}
						</div>
					</c:forEach>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>