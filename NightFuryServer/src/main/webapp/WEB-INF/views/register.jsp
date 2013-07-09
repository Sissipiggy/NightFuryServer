<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>注册页面</title>
<link href="c/layout.css" rel="stylesheet" type="text/css" />
<%@include file="headIncludeEmbedded.jsp"%>
<script src="/s/register.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="container">
			<%@include file="headerEmbedded.jsp"%>
			<%@include file="mainNavigationEmbedded.jsp"%>
			<div class="main">
				<%@include file="registerFormEmbeded.jsp"%>
			</div>
			<br />
			<%@include file="footerEmbedded.jsp"%>
		</div>
		<!-- /container -->
	</div>
	<!-- /wrapper -->
</body>
</html>