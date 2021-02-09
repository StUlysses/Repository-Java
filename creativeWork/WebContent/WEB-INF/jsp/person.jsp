<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${user.username}个人主页</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>
	var basePath = "${pageContext.request.contextPath}"
	var luid = "${logined.uid}"
	var uuid = "${user.uid}"
	var uname = "${user.username}"
	var isFollow = "${isFollow}"
</script>
<script src="${pageContext.request.contextPath }/js/person.js"></script>
<style>
	.link{color:#080808}
</style>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<table style="width:70%;height:675px;margin-left:15%;margin-right:15%">
		<tr>
		<!-- 左侧 -->
			<td style="width:80%;height:675px">
				<table style="width:100%;height:675px">
					<tr style="height:100px">
						<td style="width:30%;text-align:center">
							<font class="link" size="7">${user.username}</font>
						</td>
						<td style="width:15%"></td>
						<td style="width:55%;text-align:center">
							<div id="pd1" style="width:100%;height:100%;margin-top:30px">
								<font size="4">${user.username}的读者：${user.readerNum}</font>
								&#8195;
								<font  size="4">${user.username}的关注：${user.followNum}</font>
								&#8195;
								<font size="4">${user.username}获得收藏数：${user.collectNum}</font>
								<br/><br/>
								<font id="comment" class="link" size="4" style="width:20%;float:left">留言</font>
								<!-- 已关注显示部分 -->
								<div id="followed" style="width:20%;float:left">
										<font class="link" size="4">已关注</font>
								</div>
								<!-- 未关注显示部分 -->
								<div id="unFollow" style="width:20%;float:left">
										<font class="link" size="4">关注</font>
								</div>
							</div>
							<div id="pd2" style="width:100%;height:100%;margin-top:30px">
								<font id="readerList" class="link" size="4">${user.username}的读者：${user.readerNum}</font>
								&#8195;
								<font id="followList" class="link" size="4">${user.username}的关注：${user.followNum}</font>
								&#8195;
								<font size="4">${user.username}获得收藏数：${user.collectNum}</font>
								<br/><br/>
								<font id="collectList" class="link" size="4">收藏文章:${user.collectNum}</font>
								&#8195;
								<font id="draftList" class="link" size="4">草稿</font>
							</div>
						</td>
					</tr>
					<tr height="40px">
						<td colspan="3">
							<font size="3">${user.info }</font>
							<hr/>
						</td>
					</tr>
					<!-- 文章排列 -->
					<tr height="500px">
						<td colspan="3">
							<div style="width:100%;height:85%;margin-top: 20px">
								<c:forEach items="${queryVo.list}" var="i">
									<div style="height:40px">
										<div style="width:40%;height:30px;text-align:center;font-size:20px;float:left" onclick="article(${i.id},'person')">${i.title }</div>
										<div style="width:50%;height:30px;text-align:right;font-size:14px;float:left" onclick="article(${i.id},'person')">
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
										<a href="${pageContext.request.contextPath}/common/person.action?suid=${user.uid}&page=${i}"> ${i} </a>
									</c:if>
								</c:forEach>
							</div>
						</td>
					</tr>
				</table>
			</td>
		<!-- 分割线 -->
			<td class="rightSize">
				<div style="width:0.5px;height:670px;background-color:gray"></div>
			</td>
		<!-- 右侧 -->
			<td style="width:20%">
				<div class="rightSize" style="width:100%;height:675px">
					<div style="height:30px;width:100%;font-size:25px">
						<c:if test="${theme.tid == null}"><font id="createTheme">创建专题</font></c:if>
						<span onmouseup="enterTheme(${theme.tid})">${theme.tname }</span>
					</div>
					<hr/>
					<div style="width:100%;height:400px;">
						<div style="width:100%;height:30px;font-size:25px;">
							关注的专题
						</div>
						<c:forEach items="${myTheme}" var="i">
							<div class="link" onmouseup="enterTheme(${i.tid})" style="width:100%;height:50px;line-height:50px;font-size:20px;text-align:center">
								${i.tname}
							</div>
						</c:forEach>
					</div>
					<hr/>
					<div style="height:30px;text-align:right">
						文集列表
					</div>
					<c:forEach items="${corpus}" var="i">
						<div onclick="corpus(${i.coid})" style="text-align:center;height:30px;width:100%">
							<font class="link">${i.coname}</font>
						</div>
					</c:forEach>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>