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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>武大吉奥新员工到岗登记表系统</title>
<!-- 引入外部css样式 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-lgwind.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-title.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-body.css" />
<!-- 引入外部js代码 -->
<script src="${pageContext.request.contextPath }/js/jquery-3.2.0.js"></script>
<script src="${pageContext.request.contextPath }/js/js-lgwind.js"></script>
</head>
<body>
	<!-- 根据游客角色身份判断标题功能 -->
	<%if(userroleLgwind.equals("游客")) {%>
	<jsp:include page="limitPart/title-visitor.jsp"></jsp:include>
	<%}else if(userroleLgwind.equals("普通用户")) { %>
	<jsp:include page="limitPart/title-general.jsp"></jsp:include>
	<%}else if(userroleLgwind.equals("管理员")) { %>
	<jsp:include page="limitPart/title-manage.jsp"></jsp:include>
	<%}else if(userroleLgwind.equals("超级管理员")) { %>
	<jsp:include page="limitPart/title-superManage.jsp"></jsp:include>
	<%} %>
	<!-- 改变选择页面 -->
	<%if(pageLgwind.equals("首页")){ %>
	<jsp:include page="limitPart/body.jsp"></jsp:include>
	<%}else if(pageLgwind.equals("用户表管理")) {%>
	<jsp:include page="limitPart/body-userManage.jsp"></jsp:include>
	<%}else if(pageLgwind.equals("用户数据表管理")) {%>
	<jsp:include page="limitPart/body-userDataManage.jsp"></jsp:include>
	<%}else if(pageLgwind.equals("密码修改")) {%>
	<jsp:include page="limitPart/body-passwordUpdate.jsp"></jsp:include>
	<%}else if(pageLgwind.equals("个人资料")) {%>
	<jsp:include page="limitPart/body-personal.jsp"></jsp:include>
	<%}else if(pageLgwind.equals("系统设置")) {%>
	<jsp:include page="limitPart/body-systemSet.jsp"></jsp:include>
	<%} %>
<%-- 	<form action="${pageContext.request.contextPath }"><input class="input-lgwind" type="submit" value="退出"/></form> --%>
</body>
</html>