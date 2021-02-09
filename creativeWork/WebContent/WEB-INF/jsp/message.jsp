<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${logined.username}的消息页面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>
	var basePath = "${pageContext.request.contextPath}"
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/message.js"></script>
<style>
	.link{color:#080808}
</style>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<table style="width:70%;height:675px;margin-left:15%;margin-right:15%;border:1px blue solid">
		<tr height="670px">
		<!-- 左侧 -->
			<td width="20%" style="text-align:center">
				<table style="width:100%;height:670px">
					<tr height="70px"><td><font id="myComment" class="link" size="4">收到的留言</font></td></tr>
					<tr height="70px"><td><font id="myReview" class="link" size="4">收到的评论</font></td></tr>
					<tr height="70px"><td><font id="sendComment" class="link" size="4">我的留言</font></td></tr>
					<tr height="70px"><td><font id="sendReview" class="link" size="4">我的评论</font></td></tr>
					<tr height="70px"><td><font id="systemMsg" class="link" size="4">系统消息</font></td></tr>
					<tr height="320px"></tr>
				</table>
			</td>
		<!-- 分割线 -->
		<td>
			<div style="width:0.5px;height:670px;background-color:black"></div>
		</td>
		<!-- 右侧 -->
			<td width="80% border:blue">
				<div style="width:100%;height:670px;margin-top: 20px">
				<!-- ******************收到的留言********************* -->
					<c:if test="${chatMode == 'rc'}">
						<div style="width:100%;height:600px">
							<c:forEach items="${comments.list}" var="i">
								<div style="width:100%;height:40px;line-height:40px;font-size:20px;text-align:center">
									你收到了<a href="${pageContext.request.contextPath}/common/person.action?suid=${i.sid}">${i.sname}</a>的留言:${i.content}
								</div>
							</c:forEach>
						</div>
						<div style="font-size:16px;text-align:center">
							<c:forEach begin="1" end="${comments.totalPage }" var="i">
								<c:if test="${comments.currentPage == i}">
									 ${i} 
								</c:if>
								<c:if test="${comments.currentPage != i}">
									<a href="${pageContext.request.contextPath}/myComment.action?page=${i}"> ${i} </a>
								</c:if>
							</c:forEach>
						</div>
					</c:if>
				<!-- **********************收到的评论************************ -->
					<c:if test="${chatMode == 'rr'}">
						<div style="width:100%;height:600px">
							<c:forEach items="${comments.list}" var="i">
								<div style="width:100%;height:40px;line-height:40px;font-size:20px;text-align:center">
									你的文章<a href="${pageContext.request.contextPath}/common/article.action?id=${i.belong}">${i.lname}</a>
									收到<a href="${pageContext.request.contextPath}/common/person.action?suid=${i.sid}">${i.sname}</a>
									的留言:${i.content}
								</div>
							</c:forEach>
						</div>
						<div style="font-size:16px;text-align:center">
							<c:forEach begin="1" end="${comments.totalPage }" var="i">
								<c:if test="${comments.currentPage == i}">
									 ${i} 
								</c:if>
								<c:if test="${comments.currentPage != i}">
									<a href="${pageContext.request.contextPath}/myReview.action?page=${i}"> ${i} </a>
								</c:if>
							</c:forEach>
						</div>
					</c:if>
				<!-- ************************发送的留言*********************** -->
					<c:if test="${chatMode == 'sc'}">
						<div style="width:100%;height:600px">
							<c:forEach items="${comments.list}" var="i">
								<div style="width:100%;height:40px;line-height:40px;font-size:20px;text-align:center">
									你给<a href="${pageContext.request.contextPath}/common/person.action?suid=${i.lid}">${i.lname}</a>的留言:${i.content}
								</div>
							</c:forEach>
						</div>
						<div style="font-size:16px;text-align:center">
							<c:forEach begin="1" end="${comments.totalPage }" var="i">
								<c:if test="${comments.currentPage == i}">
									 ${i} 
								</c:if>
								<c:if test="${comments.currentPage != i}">
									<a href="${pageContext.request.contextPath}/sendComment.action?page=${i}"> ${i} </a>
								</c:if>
							</c:forEach>
						</div>
					</c:if>
				<!-- **********************发送的评论************************ -->
					<c:if test="${chatMode == 'sr'}">
						<div style="width:100%;height:600px">
							<c:forEach items="${comments.list}" var="i">
								<div style="width:100%;height:40px;line-height:40px;font-size:20px;text-align:center">
									你评论了文章<a href="${pageContext.request.contextPath}/common/article.action?id=${i.belong}">${i.lname}</a>
									:${i.content}
								</div>
							</c:forEach>
						</div>
						<div style="font-size:16px;text-align:center">
							<c:forEach begin="1" end="${comments.totalPage }" var="i">
								<c:if test="${comments.currentPage == i}">
									 ${i} 
								</c:if>
								<c:if test="${comments.currentPage != i}">
									<a href="${pageContext.request.contextPath}/myReview.action?page=${i}"> ${i} </a>
								</c:if>
							</c:forEach>
						</div>
					</c:if>
				<!-- ****************************系统消息************************* -->
					<c:if test="${chatMode == 'sm'}">
						<div style="width:100%;height:600px">
							<c:forEach items="${comments.list}" var="i">
								<div style="width:100%;height:40px;line-height:40px;font-size:20px;text-align:center">
									${i.content}
								</div>
							</c:forEach>
						</div>
						<div style="font-size:16px;text-align:center">
							<c:forEach begin="1" end="${comments.totalPage }" var="i">
								<c:if test="${comments.currentPage == i}">
									 ${i} 
								</c:if>
								<c:if test="${comments.currentPage != i}">
									<a href="${pageContext.request.contextPath}/systemMsg.action?page=${i}"> ${i} </a>
								</c:if>
							</c:forEach>
						</div>
					</c:if>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>