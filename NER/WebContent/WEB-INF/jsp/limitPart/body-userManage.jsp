<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 引入外部js代码 -->
<script src="${pageContext.request.contextPath }/js/js-body-userManage.js"></script>
<!-- 引入外部css代码 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-body-userManage.css" />
<div class="body-div-lgwind">
	<h1 id="userTitle">用户表管理</h1>
	<!-- 用户查询 -->
	<div id="userSearch">
		<form  action="${pageContext.request.contextPath }/user/search" method="post">
			<input type="text" class="input-lgwind" name="username" value="${searchStr }" />
			<input id="userSearch-button" class="input-lgwind" type="submit" value="用户名查询" />
		</form>
	</div>
	<!-- 用户表列表div -->
	<div class="user-div">
		<table>
			<tr>
				<th>序号</th>
				<th>用户名</th>
				<th>密码</th>
				<th>角色</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${userList }" varStatus="i" var="item">
				<tr>
					<td>${i.index+1 }</td>
					<td>${item.username }</td>
					<td>${item.password }</td>
					<td>${item.role }</td>
					<td><a
						href="${pageContext.request.contextPath }/user/updatePopup?username=${item.username }"
						onclick="">修改</a> <c:if test="${item.role =='普通用户' }">
							<a
								href="${pageContext.request.contextPath }/user/delete?username=${item.username }">删除</a>

						</c:if></td>
				</tr>
			</c:forEach>
			<tr><td colspan="5"><a href="${pageContext.request.contextPath }/user/addPopup">添加用户</a></td></tr>
		</table>
	</div>
</div>
<!-- 遮罩div 盖章整个页面 -->
<div id="userMask" class="mask-lgwind"></div>
<!-- 用户添加div -->
<div id="userAdd">
	<h3>添加用户</h3>
	<img onclick="closeUserAdd();" title="点击退出" class="quit" alt="退出" src="${pageContext.request.contextPath }/picture/quit.png">
	<form class="center-form" action="${pageContext.request.contextPath }/user/add" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input class="input-lgwind" type="text" name="username" value="" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input class="input-lgwind" type="text" name="password" value="" /></td>
			</tr>
			<tr>
				<td>角色：</td>
				<td><select class="input-lgwind" name="role">
						<option value="普通用户">普通用户</option>
						<option value="管理员">管理员</option>
				</select></td>
			</tr>
			<tr></tr><tr></tr>
			<tr><td></td><td><input class="input-lgwind" type="submit" value="确认添加" /></td></tr>
		</table>
	</form>
</div>
<!-- 用户修改div -->
<div id="userUpdate">
	<h3>用户表修改</h3>
	<img onclick="closeUserUpdate();" title="点击退出" class="quit" alt="退出" src="${pageContext.request.contextPath }/picture/quit.png">
	<form class="center-form" action="${pageContext.request.contextPath }/user/update" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input class="input-lgwind" type="text" name="username" value="${user.username }" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input class="input-lgwind" type="text" name="password" value="${user.password }" /></td>
			</tr>
			<tr>
				<td>角色：</td>
				<td><select class="input-lgwind" name="role">
						<c:if test="${user.role=='普通用户' }">
							<option value="普通用户" selected>普通用户</option>
							<option value="管理员">管理员</option>
						</c:if>
						<c:if test="${user.role=='管理员' }">
							<option value="普通用户">普通用户</option>
							<option value="管理员" selected>管理员</option>
						</c:if>
				</select></td>
			</tr>
			<tr></tr><tr></tr>
			<tr><td></td><td><input class="input-lgwind" type="submit" value="确认修改" /></td></tr>
		</table>
	</form>
</div>

<!-- 接收到添加操作信息时显示遮罩和添加表单页面弹出层 -->
<c:if test="${op=='addData' }">
<script type="text/javascript">
/**
 * 加载页面执行的操作
 */
window.onload=function(event){
	//显示遮罩，显示修改数据div
	showMask(); showAdd();
}
</script>
</c:if>

<!-- 接收到修改操作信息时显示遮罩和修改表单页面弹出层 -->
<c:if test="${op=='updateData' }">
<script type="text/javascript">
/**
 * 加载页面执行的操作
 */
window.onload=function(event){
	//显示遮罩，显示修改数据div
	showMask(); showUpdate();
}
</script>
</c:if>