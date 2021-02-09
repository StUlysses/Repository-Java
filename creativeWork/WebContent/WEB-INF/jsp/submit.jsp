<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>
	var basePath = "${pageContext.request.contextPath}"
	var aid = "${arti.id}"
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/submit.js"></script>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<div style="width:70%;height:675px;margin-left:15%;margin-right:15%;border:1px blue solid">
		<div  style="width:100%;height:50px;">
			<div style="width:50%;height:50px;line-height:50px;text-align:center;float:left">
				<span id="article">文章标题:${arti.title}</span>
			</div>
			<div style="width:50%;height:50px;line-height:50px;text-align:center;float:left">
				搜索专题:<input type="text" id="word" value="${themeQv.word}" style="border-radius:9px;width:70%"/>
			</div>
		</div>
		<div style="width:70%;height:520px;margin-left:15%">
			<c:forEach items="${themeQv.list}" var="i">
				<div style="width:100%;height:50px;font-size:25px">
					<div style="width:80%;float:left">
						<span onmouseup="theme(${i.tid})" class="link">${i.tname}</span>
					</div>
					<div style="width:20%;float:left">
						<span onmouseup="submit('${i.tid}','${i.tname}')" class="link">投稿</span>
					</div>
				</div>
			</c:forEach>
		</div>
		<div style="font-size:20px;text-align:center">
			<c:forEach begin="1" end="${themeQv.totalPage }" var="i">
				<c:if test="${themeQv.currentPage == i}">
					 ${i} 
				</c:if>
				<c:if test="${themeQv.currentPage != i}">
					<a href="${pageContext.request.contextPath}/searchTheme.action?tname=${themeQv.word}&page=${i}"> ${i} </a>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>