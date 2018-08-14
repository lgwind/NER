<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录界面</title>
<!-- 引入外部css样式 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-lgwind.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-userLogin.css" />
<!-- 引入外部js代码 -->
<script src="${pageContext.request.contextPath }/js/js-lgwind.js"></script>
</head>
<body>
	<h1 class="title">武大吉奥新员工到岗登记表系统</h1>
	<!-- 用户登录表单div -->
	<div class="login-div-lgwind">
		<form action="${pageContext.request.contextPath}/user/login"
			method="post">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input class="input-lgwind" name="username" type="text"
						value="${user.username }" /></td>
					<td><a href="${pageContext.request.contextPath }/user/registerPopup">注册</a></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input class="input-lgwind" name="password"
						type="password" value="${user.password }" /></td>
					<td></td>
				</tr>
				<tr>
					<td><a
						href="${pageContext.request.contextPath }/user/loginVisitor">游客登录</a></td>
					<td><input class="submit-lgwind" type="submit" value="登录" /></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td class="checkbox-text-lgwind">记住密码<input type="checkbox"
						name="subjectAnswer" value="1" /> 
						<% for (int i = 0; i < 10; i++) {%>&nbsp;<%}%> 
						<a href="${pageContext.request.contextPath }/user/userLogin">忘记密码</a></td>
					<td></td>
				</tr>
			</table>
		</form>
		${loginResult }
	</div>
	
	<!-- 作者信息div -->
	<div class="author-div-lgwind">
		<table>
			<tr>
				<th>Author :</th>
				<td>&nbsp;陈乃乐</td>
			</tr>
			<tr>
				<th>Email :</th>
				<td>1904036477@qq.com</td>
			</tr>
		</table>
	</div>
	
	<!-- 注册弹出层div -->
	<jsp:include page="loginPart/login-userRegister.jsp"></jsp:include>
	
</body>
</html>