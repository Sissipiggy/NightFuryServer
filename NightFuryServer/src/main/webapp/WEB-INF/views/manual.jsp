<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>使用说明</title>
<%@include file="headIncludeEmbedded.jsp"%>
</head>

<body>
	<div id="wrapper">
		<div id="container">
			<%@include file="headerEmbedded.jsp"%>
			<%@include file="mainNavigationEmbedded.jsp"%>
			<div id="main">
				<div class="sectionOneColumnDiv">
					<div class="sectionOneColumnTitleDiv">
						<div id="informationPlatformTitleDiv" class="switchDivLink"
							style="background: white; border-color: white">
							<a href="#"
								onclick="switchManualDiv('informationPlatformTitleDiv'); return false;"
								style="text-decoration: none">信息平台</a>
						</div>
						<div id="mapsTitleDiv" class="switchDivLink">
							<a href="#"
								onclick="switchManualDiv('mapsTitleDiv'); return false;"
								style="text-decoration: none">校园地图</a>
						</div>
						<div id="callInMealTitleDiv" class="switchDivLink">
							<a href="#"
								onclick="switchManualDiv('callInMealTitleDiv'); return false;"
								style="text-decoration: none">外卖系统</a>
						</div>
						<div id="iScheduleTitleDiv" class="switchDivLink">
							<a href="#"
								onclick="switchManualDiv('iScheduleTitleDiv'); return false;"
								style="text-decoration: none"><b>i</b>课程</a>
						</div>
						<div id="yellowPagesTitleDiv" class="switchDivLink">
							<a href="#"
								onclick="switchManualDiv('yellowPagesTitleDiv'); return false;"
								style="text-decoration: none">校园黄页</a>
						</div>
					</div>
					<div id="informationPlatformContentDiv">
						<%@include file="manualInformationPlatformEmbedded.jsp"%>
					</div>
					<div id="mapsContentDiv" style="display:none;">
						<%@include file="manualMapsEmbedded.jsp"%>
					</div>
					<div id="callInMealContentDiv" style="display:none;">
						<%@include file="manualCallInMealEmbedded.jsp"%>
					</div>
					<div id="iScheduleContentDiv" style="display:none;">
						<%@include file="manualIScheduleEmbedded.jsp"%>
					</div>
					<div id="yellowPagesContentDiv" style="display:none;">
						<%@include file="manualYellowPagesEmbedded.jsp"%>
					</div>
				</div>
			</div>
			<br /> <br /> <br /> <br />
			<!-- /columns-wrapper -->
			<%@include file="footerEmbedded.jsp"%>
		</div>
		<!-- /container -->
	</div>
	<!-- /wrapper -->

</body>
</html>
