<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.controller.util.UserUtil"%>
<%
	//获得登录的用户名\角色\登录页面
	String usernameLgwind;
	String userroleLgwind;
	String pageLgwind;
	//获取登录的用户名
	if (UserUtil.username.equals("还没保存用户名哦~")) {
		usernameLgwind = (String) session.getAttribute("usernameLgwind");
	} else {
		usernameLgwind = UserUtil.username;
		UserUtil.username = "还没保存用户名哦~";
	}
	//获取登录的角色
	if (UserUtil.userrole.equals("还没保存用户角色哦~")) {
		userroleLgwind = (String) session.getAttribute("userroleLgwind");
	} else {
		userroleLgwind = UserUtil.userrole;
		UserUtil.userrole = "还没保存用户角色哦~";
	}
	//获取登录页面
	if (UserUtil.page.equals("null")){
		pageLgwind = (String) session.getAttribute("pageLgwind");
	} else{
		pageLgwind = UserUtil.page;
		UserUtil.page = "null";
	}
	System.out.println("登录的用户为"+userroleLgwind+"：" + usernameLgwind);
	System.out.println("页面定位："+pageLgwind);
	//将登录的用户名和角色放入session
	session.setAttribute("usernameLgwind", usernameLgwind);
	session.setAttribute("userroleLgwind", userroleLgwind);
	session.setAttribute("pageLgwind", pageLgwind);
%>
<!-- 引入外部css代码 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-body-passwordUpdate.css" />
<div class="body-div-lgwind">
	<h1 id="userTitle">密码修改</h1>
	<form class="password-form" action="${pageContext.request.contextPath }/password/update" method="post">
		<table>
			<tr>
				<td class="td">用户名:</td>
				<td>&nbsp;<%=usernameLgwind%><input class="input-lgwind" type="hidden" name="username"
					value="<%=usernameLgwind%>" /><input class="input-lgwind" type="hidden" name="userrole"
					value="<%=userroleLgwind%>" /></td>
			</tr>
			<tr>
				<td>请输入原密码：</td>
				<td><input class="input-lgwind" type="password" name="passwordOld"
					value="${pu.passwordOld }" /></td>
			</tr>
			<tr>
				<td>请输入新密码：</td>
				<td><input class="input-lgwind" type="password" name="passwordNew"
					value="${pu.passwordNew }" /></td>
			</tr>
			<tr></tr><tr></tr>
			<tr>
				<td></td>
				<td><input class="input-lgwind" type="submit"
					value="确认修改" /></td>
			</tr>
			<tr class="red-font-lgwind"><td colspan="2">${PUResult }</td></tr>
		</table>
	</form>
</div>