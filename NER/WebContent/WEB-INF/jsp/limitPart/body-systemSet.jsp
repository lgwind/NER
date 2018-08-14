<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.controller.util.SystemSet"%>
<!-- 引入外部css代码 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-body-passwordUpdate.css" />
<div class="body-div-lgwind">
	<h1 id="userTitle">系统设置</h1>
	<form class="password-form" action="${pageContext.request.contextPath }/systemSet/update" method="post">
		<table>
			<tr>
				<td>服务器ip地址：</td>
				<td><input class="input-lgwind" type="text" name="ip"
					value="<%=SystemSet.ip %>" /></td>
			</tr>
			<tr>
				<td>端口号：</td>
				<td><input class="input-lgwind" type="text" name="port"
					value="<%=SystemSet.port %>" /></td>
			</tr>
			<tr></tr><tr></tr>
			<tr>
				<td></td>
				<td><input class="input-lgwind" type="submit"
					value="确认修改" /></td>
			</tr>
			<tr class="red-font-lgwind"><td colspan="2">${SSResult }</td></tr>
		</table>
	</form>
</div>