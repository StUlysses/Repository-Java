<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${theme.tname }</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script>
	var tuid = "${theme.uid}"
	var uuid = "${logined.uid}"
	var tname = "${theme.tname}"
	var isFol = "${followTheme}"
	var basePath = "${pageContext.request.contextPath}"
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/theme.js"></script>
<style>
	.link{
		color:#080808;
	}
</style>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<table style="width:70%;height:670px;margin-left:15%;margin-right:15%;border:1px black solid">
		<tr height="670px">
		<!-- 左侧 -->
			<td width="80%">
				<div style="width:100%;height:670px">
					<div style="width:100%;height:90px">
						<div style="width:60%;height:90px;line-height:90px;text-align:center;font-size:40px;float:left">
							${theme.tname}
						</div>
						<div style="width:38%;height:90px;float:left">
							<div style="width:100%;height:40px;line-height:50px;text-align:center;font-size:20px">
								<span id="unfollow" class="link">订阅</span>
								<span id="followed" class="link">已订阅</span>
							</div>
							<div style="width:100%;height:50px;line-height:40px;text-align:center;font-size:20px">
								总文章数:${ArticleNum}&#8195;
								订阅人数:${ReaderNum}&#8195;
							</div>
						</div>
					</div>
					<hr/>
					<div style="width:100%;height:500px;text-align:center;font-size:16px">
						<c:forEach items="${accepts.list}" var="i">
							<div style="width:70%;height:50px;line-height:50px;text-align:center;float:left">
								<span onmouseup="article(${i.aid})" class="link" style="font-size:20px;">
									${i.title}
								</span>
							</div>
							<div id="reviewDiv" style="width:30%;height:50px;line-height:50px;font-size:20px;float:left">
								字数:${i.size}|收藏数:${i.collectNum}
							</div>
						</c:forEach>
					</div>
					<div style="margin-bottom: 20px;font-size:16px;text-align:center">
						<c:forEach begin="1" end="${accepts.totalPage }" var="i">
							<c:if test="${accepts.currentPage == i}">
								 ${i} 
							</c:if>
							<c:if test="${accepts.currentPage != i}">
								<a href="${pageContext.request.contextPath}/common/theme.action?page=${i}&tid=${theme.tid}"> ${i} </a>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</td>
		<!-- 右侧 -->
			<td width="20%">
				<div style="width:100%;height:670px">
					<div style="width:100%;height:320px">
						<div style="width:100%;height:50px;text-align:left;font-size:20px">公告:</div>
						<div id="bulletin" style="width:100%;height:270px;font-size:16px">
							${theme.bulletin}
						</div>
					</div>
					<div style="width:100%;height:320px">
						<div style="width:100%;height:50px;text-align:left;font-size:20px">简介:</div>
						<div style="width:100%;height:270px;font-size:16px">
							${theme.info}
						</div>
					</div>
					<div id="manager" style="text-align:right;font-size:16px">
						管理员:${theme.username}
					</div>
					<div id="editTheme" style="text-align:right;font-size:16px">
						<span id="review" class="link">投稿审核</span>
						<span id="edit" class="link">编辑</span>
					</div>
					<div id="menu" style="width:80px;height:50px;line-height:25px;position:absolute;left:1216px;top:660px;text-align:center;display:none;border:1px blue solid">
						<div id="editBulletin" class="link">编辑公告</div>
						<div id="removeTheme" class="link">删除专题</div>
					</div>
				</div>
			</td>
		</tr>
		
	</table>
	
	
</body>
</html>