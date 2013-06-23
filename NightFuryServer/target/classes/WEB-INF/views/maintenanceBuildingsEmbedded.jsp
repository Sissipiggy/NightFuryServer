<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="margin: 20px; margin-left: 60px;">
	<div class="maintenance_navigation" id="maintenance_building">
		<%
			int i = 1;
		%>
		<c:forEach items="${buildingList}" var="entry">
			<div class="resourceTitle">
				<a href="javascript:void(0)"
					onclick="showResourceForm('#uploadBuildingCellForm','${entry.key.name}')"><img
					src="i/upload.png" width="30px" height="30px" title="添加详细"
					style="float: right; margin-right: 50px;"></a>
				<h3 class="resourceType"><%=i%>.${entry.key.name}
				</h3>
			</div>
			<div class="buildingInfoDiv">
				<span style="color: green;">建筑简介：</span>
				<c:out value="${entry.key.description}" />
				<hr style="color: #9c0; height: 1px;">
			</div>
			<ul style="margin-left: 15px;">
				<c:forEach var="cell" items="${entry.value}">
					<li style="list-style-type: circle;">
						<b>${cell.name}:</b>
						<br />
						&nbsp;&nbsp;&nbsp;${cell.description}
					</li>
				</c:forEach>
			</ul>
			<br />
			<div style="display: none;" id="uploadBuildingCellForm${entry.key.name}">
				<hr style="color: #9c0; height: 1px;">
				<form action="uploadCell" name="form1" method="post">
					<table>
						<tr>
							<td>名称：</td>
							<td><input type="text" name="cellName" maxLength="30"
								size="45" /></td>
						</tr>
						<tr>
							<td>简单描述：</td>
							<td><textarea name="cellDescription" rows="1" cols="38" /></textarea></td>
						</tr>
						<tr></tr>
						<tr>
							<td><input type="hidden" name="cellBuildingId"
								value="${entry.key.id}" /></td>
							<td align="right"><input type="submit" value="确定添加"/></td>
						</tr>
					</table>

				</form>
			</div>
			<%
				i++;
			%>
		</c:forEach>
	</div>
</div>