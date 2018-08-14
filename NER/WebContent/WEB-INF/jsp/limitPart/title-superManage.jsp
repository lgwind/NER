<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="title-div-lgwind">
	<ul>
		<li><a href="${pageContext.request.contextPath }/page/home">首页</a></li>
		<li><a href="${pageContext.request.contextPath }/page/userManage">用户表管理</a></li>
		<li><a href="${pageContext.request.contextPath }/page/userDataManage">用户数据表管理</a></li>
		<li><a href="${pageContext.request.contextPath }/page/passwordUpdate">密码修改</a></li>
		<li><a href="${pageContext.request.contextPath }/page/personal">个人资料</a></li>
		<li><a href="${pageContext.request.contextPath }/page/systemSet">系统设置</a></li>
	</ul>
</div>
<div class="quit-button">
	<form action="${pageContext.request.contextPath }">
	<input class="input-lgwind" type="submit" value="退出登录" />
	</form>
</div>