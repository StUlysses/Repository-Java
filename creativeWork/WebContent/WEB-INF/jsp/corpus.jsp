<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${cor.coname}</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>
	var coid = "${cor.coid}"
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/corpus.js"></script>
<style>
	.link{color:#080808}
</style>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<table style="width:70%;height:675px;margin-left:15%;margin-right:15%">
		<tr height="50px">
			<td style="text-align:center" colspan="2">
				<font size="8">${cor.coname}</font>
			</td>
		</tr>
		<tr height="25px">
			<td style="text-align:center">
				
			</td>
			<td style="text-align:right">
				<font size="4" class="link">${cor.username }</font>
			</td>
			<td style="text-align:center">
				<font id="removeCorpus" style="text-align:right;font-size:16px" class="link">删除文集</font>
			</td>
		</tr>
		<tr height="500px">
			<td colspan="3">
				<div style="width:100%;height:500px">
					<div style="text-align:center;width:100%;height:450px;margin-top: 30px">
						<c:forEach items="${ccs.list }" var="i">
							<div onclick="article(${i.aid},'person')" style="width:60%;height:45px;font-size:20px;float:left" class="link">
								${i.title}
							</div>
							<div onclick="removeCorpusContent(${i.aid},${i.coid })" style="width:30%;height:45px;font-size:20px;float:left" class="link">移除</div>
						</c:forEach>
					</div>
					<div style="position:relative;margin-bottom: 10px;font-size:10;text-align:center">
						<c:forEach begin="1" end="${ccs.totalPage }" var="i">
							<c:if test="${ccs.currentPage == i}">
								 ${i} 
							</c:if>
							<c:if test="${ccs.currentPage != i}">
								<a href="${pageContext.request.contextPath}/corpusList.action?coid=${ccs.uid}&page=${i}"> ${i} </a>
							</c:if>
						</c:forEach>
						
					</div>
				</div>
			</td>
		</tr>
		
	</table>
</body>
</html>