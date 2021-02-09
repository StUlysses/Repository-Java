<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${theme.tname}的审核页</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>
	var basePath = "${pageContext.request.contextPath}"
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/review.js"></script>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<div style="width:70%;height:675px;margin-left:15%;margin-right:15%;border:1px black solid">
		<div style="width:100%;height:600px">
			<c:forEach items="${submitArticle.list}" var="i">
				<div style="width:70%;height:60px;line-height:60px;float:left">
					<div onmouseup="article(${i.aid})" class="link" style="width:100%;height:30px;line-height:30px;text-align:center;font-size:20px;">
						${i.title}
					</div>
					<div style="width:100%;height:20px;line-height:20px;text-align:center;font-size:15px;">
						字数:${i.size}&#8195;收藏数:${i.collectNum}
					</div>
				</div>
				<div id="${i.aid}" style="width:30%;height:60px;line-height:60px;font-size:20px;float:left">
					<span onmouseup="accept('${i.aid}','${i.title}','${i.collectNum}','${i.size}')" class="link">收录</span>
					<span style="display: none">已收录</span>
					<span onmouseup="object('${i.aid}','${i.title}')" class="link">拒绝</span>
					<span style="display: none">已拒绝</span>
				</div>
			</c:forEach>
		</div>
		<div style="margin-bottom: 20px;font-size:20px;text-align:center">
			<c:forEach begin="1" end="${submitArticle.totalPage }" var="i">
				<c:if test="${submitArticle.currentPage == i}">
					 ${i} 
				</c:if>
				<c:if test="${submitArticle.currentPage != i}">
					<a href="${pageContext.request.contextPath}/reView.action?page=${i}&tname=${theme.tname}"> ${i} </a>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>