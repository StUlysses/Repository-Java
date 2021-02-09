<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜索</title>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>
	var basePath = "${pageContext.request.contextPath}"
</script>
<script src="${pageContext.request.contextPath}/js/search.js"></script>
<style>
	.link{color:#080808}
</style>
</head>
<body>
	<jsp:include page="./common/header.jsp">
		<jsp:param value="${word }" name="search"/>
	</jsp:include>
	<table style="width:70%;height:670px;margin-left:15%;margin-right:15%;border:1px black solid">
		<tr>
		<!-- 左侧 -->
			<td style="width:20%">
				<div class="link" style="height:40px;line-height:40px;font-size:25px;text-align:right" id="clear">
					清空
				</div>
				<div id="divH" style="width:100%;height:400px">
					<c:forEach items="${history}" var="i">
						<div onmouseup="search('${i}')" class="link" style="height:40px;line-height:40px;font-size:20px;text-align:center">
								${i}
						</div>
					</c:forEach>
				</div>
			</td>
			<!-- 分割线 -->
			<td>
				<div style="width:0.5px;height:670px;background-color:black"></div>
			</td>
			<!-- 右侧 -->
			<td style="width:80%">
				<div style="width:100%;height:670px;">
					<div style="width:100%;height:110px">
						<div style="width:100%;height:20px;line-height:20px;font-size:18px;margin-left: 50px">
							相关用户：
						</div>
						<div style="width:100%;height:30px;line-height:30px;font-size:20px;text-align:center">
							<c:forEach begin="0" end="4" items="${resultU}" var="u">
								<span class="link" style="width:20%" onmouseup="person(${u.uid})">${u.username }</span>
							</c:forEach>
						</div>
						<div style="width:100%;height:20px;line-height:20px;font-size:18px;margin-left: 50px">
							相关专题：
						</div>
						<div style="width:100%;height:30px;line-height:30px;font-size:20px;text-align:center">
							<c:forEach items="${resultT}" var="t">
								<span class="link" style="width:20%" onmouseup="theme(${t.tid})">专题${t.tname}</span>
							</c:forEach>
						</div>
					</div>
					<!-- 文章结果 -->
					<div style="width:100%;height:20px;line-height:20px;font-size:18px;margin-left: 50px">
						相关文章：
					</div>
					<div  style="width:100%;height:520px;text-align:center">
						<div style="height:470px">
							<c:forEach items="${resultA.list }" var="a">
								<div style="width:100%;height:45px;line-height:45px;font-size:20px">
									<span class="link" style="width:20%" onmouseup="article(${a.id})">${a.title }</span>
								</div>
							</c:forEach>
						</div>
						<div style="font-size:20px;text-align:center">
							<c:forEach begin="1" end="${resultA.totalPage }" var="i">
								<c:if test="${resultA.currentPage == i}">
									 ${i} 
								</c:if>
								<c:if test="${resultA.currentPage != i}">
									<a href="${pageContext.request.contextPath}/common/search.action?page=${i}&word=${word}"> ${i} </a>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>