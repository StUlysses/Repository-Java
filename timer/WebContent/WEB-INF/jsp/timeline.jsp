<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href='${pageContext.request.contextPath }/css/demo1.css'>
<link rel="stylesheet" href='${pageContext.request.contextPath }/css/style.css'>
<link rel="stylesheet" href='${pageContext.request.contextPath }/css/kelly.css'>
</head>
<body>
<jsp:include page="common.jsp"></jsp:include>
	<div class="container">
		<div class="demos">
			<button type="button" class="btn btn-secondary" onclick="NewArticle()">记录</button>
		</div>
        <h1>heheda	</h1>
        <h2 class="ss-subtitle">${tLine.name }</h2>
		<div id="ss-links" class="ss-links">
	        <c:forEach items="${artiList }" var="i">
	   			<c:if test='${i.dateFlag != "none" }'>
	   				<a href="#${i.dateFlag }" style="text-decoration:none;">${i.year%-2000 }.${i.month }</a>
	   			</c:if>
	   		</c:forEach>
		</div>
           <div id="ss-container" class="ss-container">
         		<c:forEach items="${artiList }" var="i" varStatus="state">
         			<!-- 日期标签 -->
         			<c:if test='${i.dateFlag != "none" }'>
         				<div class="ss-row">
		                   <div class="ss-left">
		                       <h2 id="${i.dateFlag }"> ${i.month }</h2>
		                   </div>
		                   <div class="ss-right">
		                       <h2>${i.year }</h2>
		                   </div>
		               </div>
         			</c:if>
         			<!-- 设置左右，以图为准 ss-medium,ss-large,ss-small -->
         			<c:if test="${state.index%2 == 0 }">
         				<c:if test="${state.index%4 == 0 }">
         					<!-- 左中 -->
         					<div class="ss-row ss-medium">
			                   <div class="ss-left">
			                       <a class="ss-circle" onclick="ViewImg('${i.attList[0].path}')" style="background-image: url(/image${i.attList[0].path});">${i.title }</a>
			                   </div>
			                   <div class="ss-right">
			                       <h3>
			                           <span>${i.month } . ${i.year } </span>
			                           <a href="javascript:void(0);" onclick="delArti('${i.guid}')" style="text-decoration:none;float:left;">${i.title }</a>
			                           
			                           &nbsp;&nbsp;
			                           <c:if test='${i.content == "" }'>
			                           		<img alt="内容" src="${pageContext.request.contextPath }/img/book.svg" />
			                           </c:if>
			                           <c:if test='${i.content != "" }'>
			                           		<img alt="内容" onclick="ViewInfo('${i.title }','${i.content }')" src="${pageContext.request.contextPath }/img/book-half.svg" />
			                           </c:if>
			                       </h3>
			                   </div>
			               </div>
         				</c:if>
         				<c:if test="${state.index%4 != 0 }">
         					<!-- 左大 -->
         					<div class="ss-row ss-large">
			                   <div class="ss-left">
			                       <a class="ss-circle" onclick="ViewImg('${i.attList[0].path}')" style="background-image: url(/image/${i.attList[0].path});">${i.title }</a>
			                   </div>
			                   <div class="ss-right">
			                       <h3>
			                           <span>${i.month } . ${i.year } </span>
			                           <a href="javascript:void(0);" onclick="delArti('${i.guid}')" style="text-decoration:none;float:left;">${i.title }</a>
			                           
			                           &nbsp;&nbsp;
			                           <c:if test='${i.content == "" }'>
			                           		<img alt="内容" src="${pageContext.request.contextPath }/img/book.svg" />
			                           </c:if>
			                           <c:if test='${i.content != "" }'>
			                           		<img alt="内容" onclick="ViewInfo('${i.title }','${i.content }')" src="${pageContext.request.contextPath }/img/book-half.svg" />
			                           </c:if>
			                       </h3>
			                   </div>
			               </div>
         				</c:if>
         			</c:if>
         			<c:if test="${state.index%2 == 1 }">
	         			<c:if test="${(state.index-1)%4 == 0 }">
         					<!-- 右大 -->
	         				<div class="ss-row ss-large">
			                   <div class="ss-left">
			                       <h3>
			                           <span>${i.month } . ${i.year } </span>
			                           <a href="javascript:void(0);" onclick="delArti('${i.guid}')" style="text-decoration:none;float:left;">${i.title }</a>
			                           
			                           &nbsp;&nbsp;
			                           <c:if test='${i.content == "" }'>
			                           		<img alt="内容" src="${pageContext.request.contextPath }/img/book.svg" />
			                           </c:if>
			                           <c:if test='${i.content != "" }'>
			                           		<img alt="内容" onclick="ViewInfo('${i.title }','${i.content }')" src="${pageContext.request.contextPath }/img/book-half.svg" />
			                           </c:if>
			                       </h3>
			                   </div>
			                   <div class="ss-right">
			                       <a class="ss-circle" onclick="ViewImg('${i.attList[0].path}')" style="background-image: url(/image/${i.attList[0].path});">${i.title }</a>
			                   </div>
			               </div>
	         			</c:if>
	         			<c:if test="${(state.index-1)%4 != 0 }">
         					<!-- 右中 -->
	         				<div class="ss-row ss-medium">
			                   <div class="ss-left">
			                       <h3>
			                           <span>${i.month } . ${i.year } </span>
			                           <a href="javascript:void(0);" onclick="delArti('${i.guid}')" style="text-decoration:none;float:left;">${i.title }</a>
			                           
			                           &nbsp;&nbsp;
			                           <c:if test='${i.content == "" }'>
			                           		<img alt="内容" src="${pageContext.request.contextPath }/img/book.svg" />
			                           </c:if>
			                           <c:if test='${i.content != "" }'>
			                           		<img alt="内容" onclick="ViewInfo('${i.title }','${i.content }')" src="${pageContext.request.contextPath }/img/book-half.svg" />
			                           </c:if>
			                       </h3>
			                   </div>
			                   <div class="ss-right">
			                       <a class="ss-circle" onclick="ViewImg('${i.attList[0].path}')" style="background-image: url(/image/${i.attList[0].path});">${i.title }</a>
			                   </div>
			               </div>
	         			</c:if>
         			</c:if>
         			
         		</c:forEach>
         		<div class="ss-row ss-small">
                   <div class="ss-left">
                       <h3>
                           <span>forever</span>
                           <a href="javascript:void(0);" style="text-decoration:none;">has no end</a>
                       </h3>
                   </div>
				<div class="ss-right">
                       <a class="ss-circle"style="background-image: url(${pageContext.request.contextPath }/img/1.jpg);"></a>
                   </div>
               </div>
           </div>
       </div>
       
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/modernizr.custom.11333.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easing.1.3.js"></script>
<script type="text/javascript">
	$(function() {
		var $sidescroll	= (function() {
				// the row elements
			var $rows			= $('#ss-container > div.ss-row'),
				// we will cache the inviewport rows and the outside viewport rows
				$rowsViewport, $rowsOutViewport,
				// navigation menu links
				$links			= $('#ss-links > a'),
				// the window element
				$win			= $(window),
				// we will store the window sizes here
				winSize			= {},
				// used in the scroll setTimeout function
				anim			= false,
				// page scroll speed
				scollPageSpeed	= 2000 ,
				// page scroll easing
				scollPageEasing = 'easeInOutExpo',
				// perspective?
				hasPerspective	= false,
				perspective		= hasPerspective && Modernizr.csstransforms3d,
				// initialize function
				init			= function() {
					// get window sizes
					getWinSize();
					// initialize events
					initEvents();
					// define the inviewport selector
					defineViewport();
					// gets the elements that match the previous selector
					setViewportRows();
					// if perspective add css
					if( perspective ) {
						$rows.css({
							'-webkit-perspective'			: 600,
							'-webkit-perspective-origin'	: '50% 0%'
						});
					}
					// show the pointers for the inviewport rows
					$rowsViewport.find('a.ss-circle').addClass('ss-circle-deco');
					// set positions for each row
					placeRows();
				},
				// defines a selector that gathers the row elems that are initially visible.
				// the element is visible if its top is less than the window's height.
				// these elements will not be affected when scrolling the page.
				defineViewport	= function() {
					$.extend( $.expr[':'], {
						inviewport	: function ( el ) {
							if ( $(el).offset().top < winSize.height ) {
								return true;
							}
							return false;
						}
					});
				},
				// checks which rows are initially visible 
				setViewportRows	= function() {
					$rowsViewport 		= $rows.filter(':inviewport');
					$rowsOutViewport	= $rows.not( $rowsViewport )
				},
				// get window sizes
				getWinSize		= function() {
					winSize.width	= $win.width();
					winSize.height	= $win.height();
				},
				// initialize some events
				initEvents		= function() {
					// navigation menu links.
					// scroll to the respective section.
					$links.on( 'click.Scrolling', function( event ) {
						// scroll to the element that has id = menu's href
						$('html, body').stop().animate({
							scrollTop: $( $(this).attr('href') ).offset().top
						}, scollPageSpeed, scollPageEasing );
						return false;
					});
					$(window).on({
						// on window resize we need to redefine which rows are initially visible (this ones we will not animate).
						'resize.Scrolling' : function( event ) {
							// get the window sizes again
							getWinSize();
							// redefine which rows are initially visible (:inviewport)
							setViewportRows();
							// remove pointers for every row
							$rows.find('a.ss-circle').removeClass('ss-circle-deco');
							// show inviewport rows and respective pointers
							$rowsViewport.each( function() {
								$(this).find('div.ss-left')
									   .css({ left   : '0%' })
									   .end()
									   .find('div.ss-right')
									   .css({ right  : '0%' })
									   .end()
									   .find('a.ss-circle')
									   .addClass('ss-circle-deco');
							
							});
						
						},
						// when scrolling the page change the position of each row	
						'scroll.Scrolling' : function( event ) {
							
							// set a timeout to avoid that the 
							// placeRows function gets called on every scroll trigger
							if( anim ) return false;
							anim = true;
							setTimeout( function() {
								
								placeRows();
								anim = false;
								
							}, 10 );
						
						}
					});
				
				},
				// sets the position of the rows (left and right row elements).
				// Both of these elements will start with -50% for the left/right (not visible)
				// and this value should be 0% (final position) when the element is on the
				// center of the window.
				placeRows		= function() {
					
						// how much we scrolled so far
					var winscroll	= $win.scrollTop(),
						// the y value for the center of the screen
						winCenter	= winSize.height / 2 + winscroll;
					
					// for every row that is not inviewport
					$rowsOutViewport.each( function(i) {
						
						var $row	= $(this),
							// the left side element
							$rowL	= $row.find('div.ss-left'),
							// the right side element
							$rowR	= $row.find('div.ss-right'),
							// top value
							rowT	= $row.offset().top;
						
						// hide the row if it is under the viewport
						if( rowT > winSize.height + winscroll ) {
							
							if( perspective ) {
							
								$rowL.css({
									'-webkit-transform'	: 'translate3d(-75%, 0, 0) rotateY(-90deg) translate3d(-75%, 0, 0)',
									'opacity'			: 0
								});
								$rowR.css({
									'-webkit-transform'	: 'translate3d(75%, 0, 0) rotateY(90deg) translate3d(75%, 0, 0)',
									'opacity'			: 0
								});
							
							}
							else {
							
								$rowL.css({ left 		: '-50%' });
								$rowR.css({ right 		: '-50%' });
							
							}
							
						}
						// if not, the row should become visible (0% of left/right) as it gets closer to the center of the screen.
						else {
								
								// row's height
							var rowH	= $row.height(),
								// the value on each scrolling step will be proporcional to the distance from the center of the screen to its height
								factor 	= ( ( ( rowT + rowH / 2 ) - winCenter ) / ( winSize.height / 2 + rowH / 2 ) ),
								// value for the left / right of each side of the row.
								// 0% is the limit
								val		= Math.max( factor * 50, 0 );
								
							if( val <= 0 ) {
							
								// when 0% is reached show the pointer for that row
								if( !$row.data('pointer') ) {
								
									$row.data( 'pointer', true );
									$row.find('.ss-circle').addClass('ss-circle-deco');
								
								}
							
							}
							else {
								
								// the pointer should not be shown
								if( $row.data('pointer') ) {
									
									$row.data( 'pointer', false );
									$row.find('.ss-circle').removeClass('ss-circle-deco');
								
								}
								
							}
							
							// set calculated values
							if( perspective ) {
								
								var	t		= Math.max( factor * 75, 0 ),
									r		= Math.max( factor * 90, 0 ),
									o		= Math.min( Math.abs( factor - 1 ), 1 );
								
								$rowL.css({
									'-webkit-transform'	: 'translate3d(-' + t + '%, 0, 0) rotateY(-' + r + 'deg) translate3d(-' + t + '%, 0, 0)',
									'opacity'			: o
								});
								$rowR.css({
									'-webkit-transform'	: 'translate3d(' + t + '%, 0, 0) rotateY(' + r + 'deg) translate3d(' + t + '%, 0, 0)',
									'opacity'			: o
								});
							}
							else {
								$rowL.css({ left 	: - val + '%' });
								$rowR.css({ right 	: - val + '%' });
							}
						}	
					});
				};
			return { init : init };
		})();
		$sidescroll.init();
	});
	//新建记录
	function NewArticle(){
		if(getAuth() != 'zhu'){
			InputDialog("输入密码","authory");
			return;
		}
		TextDialog("记录","article");
	}
	//删除记录
	function delArti(id){
		if(getAuth() != 'zhu'){
			InputDialog("输入密码","authory");
			return;
		}
		articleId = id;
		typeType = "delArticle";
		PopDialog("删除确认", "此操作不可逆");
	}
	//查看图片
	function ViewImg(path){
		ImageDialog(path);
	}
	//展示文章详情	
	function ViewInfo(title,content){
		typeType = "";
		let con = content.split('###&&&');
		let h5 = '';
		for(let i = 0;i < con.length;i++){
			h5+= '<p style="line-height: 1.5;height: calc(1.5em + .75rem + 2px);padding: .375rem .75rem;">'+con[i]+'</p>';
		}
		PopDialog(title, h5);
	}
</script>
</html>