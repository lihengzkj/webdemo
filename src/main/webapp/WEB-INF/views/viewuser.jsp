<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html">
<html>
<head>
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
    <link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath() %>/css/grid.css" />
	

</head>
<body  class="home blog two-column right-sidebar" data-twttr-rendered="true">
	<div id="page">

		<%@ include file="header.jsp" %> 

		<div class="item teaser-page-list">
			<div class="container_16">
				<div class="grid_6">
					<div id="rootline"> 
						User View
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>

		<div id="main" class="site-main container_16">
			<div class="inner"> 
				
				<div id="primary" class="grid_11 suffix_1">
					
					<!-- First article -->
					<article class="list">
						<div class="short-content">  
 							<hr />
 							<div>  
 								<form action="<c:url value='/views/updateUserLogic.html' />" method="post">
 									ID:<input type="text" readonly="readonly" name="userid" value="${user.userid }" /><br /><br />
	 								username:<input type="text" name="userName" value="${user.userName }" /><br /><br />
	 								privilege:<input type="text" name="privilege" value="${user.privilege }" /><br /><br />
	 								<input type="submit" name="submit" value="updateUser" />
	 								<br /><br /><a href="<c:url value='/views/index.html' />">Return List</a>
 								</form>
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
	 
	
</body>
</html>