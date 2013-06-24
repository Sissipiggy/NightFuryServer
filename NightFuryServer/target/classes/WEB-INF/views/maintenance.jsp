<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>参与维护</title>
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
						<div id="maintenanceHelpTitleDiv" class="switchDivLink"
							style="background: white; border-color: white">
							<a href="#"
								onclick="switchMaintenanceDiv('maintenanceHelpTitleDiv'); return false;"
								style="text-decoration: none">维护说明</a>
						</div>
						<div id="buildingsTitleDiv" class="switchDivLink">
							<a href="#"
								onclick="switchMaintenanceDiv('buildingsTitleDiv'); return false;"
								style="text-decoration: none">暨大建筑</a>
						</div>
						<div id="yellowPagesTitleDiv" class="switchDivLink">
							<a href="#"
								onclick="switchMaintenanceDiv('yellowPagesTitleDiv'); return false;"
								style="text-decoration: none">校园黄页</a>
						</div>
						<div id="newFunctionsTitleDiv" class="switchDivLink">
							<a href="#"
								onclick="switchMaintenanceDiv('newFunctionsTitleDiv'); return false;"
								style="text-decoration: none">新功能推介</a>
						</div>
						<div id="bugsTitleDiv" class="switchDivLink">
							<a href="#"
								onclick="switchMaintenanceDiv('bugsTitleDiv'); return false;"
								style="text-decoration: none">提交Bug</a>
						</div>
					</div>
					<div id="maintenanceHelpContentDiv">
						<%@include file="maintenanceHelpEmbedded.jsp"%>
					</div>
					<div id="buildingsContentDiv" style="display:none;">
						<%@include file="maintenanceBuildingsEmbedded.jsp"%>
					</div>
					<div id="yellowPagesContentDiv" style="display:none;">
						<%@include file="maintenanceYellowPagesEmbedded.jsp"%>
					</div>
					<div id="newFunctionsContentDiv" style="display:none;">
						<%@include file="maintenanceNewFunctionsEmbedded.jsp"%>
					</div>
					<div id="bugsContentDiv" style="display:none;">
						<%@include file="maintenanceBugsEmbedded.jsp"%>
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
