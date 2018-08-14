<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 引入外部js代码 -->
<script src="${pageContext.request.contextPath }/js/js-login-userRegister.js"></script>
<!-- 引入外部css代码 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-login-userRegister.css" />
	
<!-- 遮罩div 盖章整个页面 -->
<div id="userMask" class="mask-lgwind"></div>

<!-- 用户注册div -->
<div id="userRegister">
	<h3>普通用户注册</h3>
	<img onclick="closeUserRegister();" title="点击退出" class="quit" alt="退出" src="${pageContext.request.contextPath }/picture/quit.png">
	<form class="center-form" action="${pageContext.request.contextPath }/user/register" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input class="input-lgwind" type="text" name="username" value="${user.username }" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input class="input-lgwind" type="password" name="password" value="${user.password }" /></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input class="input-lgwind" type="password" name="password2" value="${password2 }" /></td>
			</tr>
			<tr></tr><tr></tr>
			<tr><td></td><td><input class="input-lgwind" type="submit" value="确认注册" /></td></tr>
			<tr><td colspan="2" class="red-font-lgwind">${registerResult }</td></tr>
		</table>
	</form>
</div>

<!-- 接收到注册操作信息时显示遮罩和添加表单页面弹出层 -->
<c:if test="${op=='registerData' }">
<script type="text/javascript">
/**
 * 加载页面执行的操作
 */
window.onload=function(event){
	//显示遮罩，显示修改数据div
	showMask(); showRegister();
}
</script>
</c:if>
