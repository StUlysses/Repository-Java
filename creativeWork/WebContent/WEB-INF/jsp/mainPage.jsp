<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>创点</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>
	
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mainPage.js"></script>
<style>
	.link{color:#080808}
	a{text-decoration:none}
</style>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<table style="width:70%;height:675px;margin-left:15%;margin-right:15%">
		<tr height="100px">
			<td width="100%" colspan="2">
				<div style="width:60%;height:100px;margin-left:20%;margin-right:20%;border:1px blue solid">
					<img id="adImg" src="${pageContext.request.contextPath}/ad/1.jpg" style="width:100%;height:100px;position:relative">
				</div>
			</td>
		</tr>
		<tr>
		<!-- 左侧文章栏 -->
			<td style="width:70%;height:550px">
				<div style="width:100%;height:85%;margin-top: 20px">
					<c:forEach items="${queryVo.list}" var="i">
						<div style="height:43px">
							<div style="width:40%;height:30px;text-align:center;font-size:20px;float:left" onclick="article(${i.id})">${i.title }</div>
							<div style="width:50%;height:30px;text-align:right;font-size:14px;float:left" onclick="article(${i.id})">
								作者：${i.username}|字数：${i.size }个字|收藏数：${i.collectNum}
							</div>
						</div>
					</c:forEach>
				</div>
				<div style="margin-bottom: 20px;font-size:10;text-align:center">
					<c:forEach begin="1" end="${queryVo.totalPage }" var="i">
						<c:if test="${queryVo.currentPage == i}">
							 ${i} 
						</c:if>
						<c:if test="${queryVo.currentPage != i}">
							<a href="${pageContext.request.contextPath}/common/creative.action?page=${i}"> <font class="link" size="5px">${i}</font> </a>
						</c:if>
					</c:forEach>
				</div>
			</td>
			<!-- 右侧动态栏 -->
			
			<td style="width:30%">
			<!-- 活跃专题 -->
				<div style="width:100%;height:260px;text-align:center">
					<c:forEach items="${themes}" var="i">
						<div style="width:100%;height:20%;text-align:center">
							<a href="${pageContext.request.contextPath}/common/theme.action?tid=${i.tid}"><font class="link" size="5px">${i.tname}</font></a>
						</div>
					</c:forEach>
				</div>
				<!-- 活跃用户 -->
				<div style="width:100%;height:260px;text-align:center">
					<c:forEach items="${activeUser}" var="i">
						<div style="width:100%;height:20%;text-align:center">
							<a href="${pageContext.request.contextPath}/common/person.action?suid=${i.uid}"><font class="link" size="5px">${i.username}</font></a>
						</div>
					</c:forEach>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>