<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>timer</title>
	<link rel="stylesheet" href='${pageContext.request.contextPath }/css/base.css'>
	<link rel="stylesheet" href='${pageContext.request.contextPath }/css/demo.css'>
</head>
<body>
<jsp:include page="common.jsp"></jsp:include>

	<!-- COIDEA:demo START -->
  <header>
    <ul class="navigation">
      
      <!-- navigation START -->
      <c:forEach items="${list }" var="i" varStatus="state">
	      <li data-width="${(total-state.index)*120+220 }" onclick="IntoTimeLine('${i.guid }')" data-height="${(total-state.index)*120+220 }">
	         <h5>${i.name }</h5> 
	      </li>
      </c:forEach>
      
      <li data-width="220" onclick="CreateTimeLine()" data-height="220">
          <h5>添加时间轴</h5> 
      </li>
      <!-- navigation END -->
      
      <!-- navigation:background-helper START -->
      <div class="header-transparent"></div>
      <!-- navigation:background-helper END -->
      
      <!-- navigation:trigger START -->
      <div id="menu-trigger">
        <div id="hamburger">
          <span></span>
          <span></span>
          <span></span>
        </div>
        <div id="close">
          <span></span>
          <span></span>
        </div>
      </div>
      <!-- navigation:trigger END -->
      
    </ul>
  </header>
  <!-- COIDEA:demo END -->
  <img id="indexImg" src="" style="width:100%;height:100%;position:absolute;top:0px;left:0px" />
  
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/TweenMax.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/demo.js"></script>
<script type="text/javascript">
	$(function(){
		if (mode == 'PC') {
            $('#indexImg').attr('src', basePath+'/img/bg.jpeg');
        }
        else if (mode == 'phone') {
            $('#indexImg').attr('src', basePath+'/img/bg2.jpeg');
        }
	})
	//点击建立时间轴
	function CreateTimeLine(){
		if(getAuth() != 'zhu'){
			InputDialog("输入密码","authory");
			return;
		}
		InputDialog('建立时间轴','timeline');
	}
	
	function IntoTimeLine(id){
		location.href = basePath + '/timeline/index.action?tid='+id;
	}
</script>
</html>