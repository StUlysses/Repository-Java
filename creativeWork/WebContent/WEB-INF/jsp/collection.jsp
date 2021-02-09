<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${logined.username}的收藏</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/collection.js"></script>
<style>
	.link{color:#080808}
</style>
</head>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<div style="width:40%;height:675px;margin-left:30%;margin-right:30%">
		<div style="height:70px;line-height:70px;text-align:center" >
			<h3>${logined.username}的收藏</h3>
		</div>
		<c:forEach items="${collects.list}" var="i">
			<div style="height:45px;line-height:45px" onclick="article(${i.aid})">
				<font id="article" size="4px" class="link">${i.title}</font>
			</div>
		</c:forEach>
		<div style="font-size:20px;position:absolute;bottom:20px;right:50%">
			<c:forEach begin="1" end="${collects.totalPage }" var="i">
				<c:if test="${collects.currentPage == i}">
					 ${i} 
				</c:if>
				<c:if test="${collects.currentPage != i}">
					<a href="${pageContext.request.contextPath}/collectList.action?page=${i}"> ${i} </a>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>