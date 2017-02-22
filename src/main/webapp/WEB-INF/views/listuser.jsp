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
						User Collection(Here make some change!)
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>

		<div id="main" class="site-main container_16">
			<div class="inner">
			
				
				<div id="primary" class="grid_14 suffix_1">
					
					<!-- First article -->
					<article class="list">
						<div class="short-content">  
							<a href="<c:url value='/views/addUserPage.html' />"><span style="color:red;font-size:14px;">ADD USER</span></a>
 							<hr />
 							<div>  
 								
 								<table style="width:100%;text-align:center;">
									<thead>
										<tr>
											<td width="20%">UserID</td>
											<td width="20%">UserName</td>
											<td width="20%">Credit</td>
											<td width="20%">Privilege</td>
											<td width="20%">Action</td>
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
														<td>${user.userid }</td>
														<td>${user.userName }</td>
														<td>${user.credits }</td>
														<td>${user.privilege} </td>
														<td>
															<a href="<c:url value='/views/deleteUser.html?userid=${user.userid }' />" >Delete</a>
															<a href="<c:url value='/views/updateUserPage.html?userid=${user.userid }' />">Update</a>
														</td>
													</tr>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<tr>
													<td colspan="3">Data not found!</td>
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
	
	
	
</body>
</html>