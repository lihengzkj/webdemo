<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html">
<html>
<head>
	
	<!-- 国际化配置 -->
	<fmt:setLocale value="${language }"/>
	<!-- 设置本地工具类-->
	<fmt:setBundle basename="com.siyou.bojun.i18n.i18nproperties" var="msg"/>
	
	
	<!--  Basic Page Needs -->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>WebDemo</title>
	<meta name="description" content="">
	<meta name="author" content="">

	<!-- Favicon -->
	<link rel="shortcut icon" href="favicon.ico" /> 
	
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<!-- CSS -->
	<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath() %>/css/style.css" /> 
    <link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath() %>/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath() %>/css/flexslider.css" />
    <link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath() %>/css/font-awesome-ie7.min.css" />
    <link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath() %>/css/keyframes.css" />
    <link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath() %>/css/grid.css" />
	

</head>
<body  class="home blog two-column right-sidebar" data-twttr-rendered="true">
	<div id="page">

		<%@ include file="header.jsp" %> 

		<div class="item teaser-page-list">
			<div class="container_16">
				<!--<aside class="grid_10">
					<h1 class="page-title">关于我们</h1>
				</aside>-->
				<div class="grid_6">
					<div id="rootline">
						<fmt:message bundle="${msg }" key="locations" />
						User Collection
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>

		<div id="main" class="site-main container_16">
			<div class="inner">
			
				<div id="secondary" class="grid_4 widget-area" role="complementary">

					<!-- Widget Archive -->
					<aside id="archives" class="widget">
						<div class="widget-title">	
							<h3><fmt:message bundle="${msg }" key="aboutUs" /></h3>
							<div class="clear"></div>
						</div>
						<ul>
							<li class="subMenuActive">
								<a href="#">
									Users
								</a>
							</li>
						</ul>
					</aside>

				</div>
				
				<div id="primary" class="grid_11 suffix_1">
					
					<!-- First article -->
					<article class="list">
						<div class="short-content"> 
							  
							
 							<hr />
 							<div> 
 							
								
								<h1>E</h1>
 								<table style="width:100%;text-align:center;">
									<thead>
										<tr>
											<td width="30%">UserName</td>
											<td width="30%">Credit</td>
											<td width="30%">Privilege</td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
										</tr> 
										<c:choose>
											<c:when test="${page.allRecords gt 0 }">
												<c:forEach items="${page.pageData }" var="user">
													<tr>
														<td>${user.userName }</td>
														<td>${user.credits }</td>
														<td>${user.privilege} </td>
													</tr>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<tr>
													<td colspan="3"><fmt:message bundle="${msg }" key="newsDataNotFound" /></td>
												</tr>
											</c:otherwise>
										</c:choose>
									</tbody>
								</table>
								
								
								
								
 							</div> 
							
							<div class="clear"></div>

						</div>
						<div class="clear"></div>
					</article>
									
				</div>
	
				
				<div class="clear"></div>
			</div>
		</div>

		<!-- Footer -->
		<%@ include file="footer.jsp" %>
		<!-- #colophon .site-footer -->

	</div>
	<!-- /#page -->
	
	
	<!-- Scripts -->
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/html5.js"></script>
    <script src="<%=request.getContextPath() %>/js/base.js"></script>

	<!-- Scripts for plugins -->
	<script src="<%=request.getContextPath() %>/js/jquery.fitvids.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.flexslider-min.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.inview.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.scrollParallax.min.js"></script>

	<!-- Google Analytics Tracking -->
	<script type="text/javascript">
		var analyticsFileTypes = [''];
		var analyticsEventTracking = 'enabled';
	</script>
	
	
</body>
</html>