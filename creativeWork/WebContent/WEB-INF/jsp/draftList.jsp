<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${logined.username}的草稿</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>
	var basePath = "${pageContext.request.contextPath}"
</script>
<style>
	.link{color:#080808}
</style>
<script src="${pageContext.request.contextPath}/js/draftList.js"></script>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<div style="width:70%;height:675px;margin-left:15%;margin-right:15%;border:1px blue solid">
		<h3 style="text-align:center">草稿列表</h3>
		<div style="width:100%;height:600px">
			<c:forEach items="${drafts.list}" var="i">
			<div style="width:60%;height:50px;line-height:50px" onclick="article(${i.id},'person')">
				&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;
				<font class="link" size="4">${i.title}</font>
				&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;
				<font>字数：${i.size }</font>
			</div>
		</c:forEach>
		</div>
		<div style="text-align:center;margin-bottom: 20px">
			<c:forEach begin="1" end="${drafts.totalPage }" var="i">
				<c:if test="${drafts.currentPage == i}">
					 ${i} 
				</c:if>
				<c:if test="${drafts.currentPage != i}">
					<a href="${pageContext.request.contextPath}/draftList.action?page=${i}"> ${i} </a>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>