<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.lgwind.controller.util.SystemSet"%>
<!-- 引入外部js代码 -->
<script src="${pageContext.request.contextPath }/js/js-body-userDataManage.js"></script>
<!-- 引入外部css代码 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-body-userDataManage.css" />
<div class="body-div-lgwind">
	<h1 id="dataTitle">用户数据表管理</h1>
	<!-- 导出为Excel的xls文件 -->
	<div id="export">
		<table><tr><td>导出</td><td>
		<input id="xls-input" class="input-lgwind" type="button"
			onclick="window.open('${pageContext.request.contextPath }/datas/exportXLSPopup','_self');"
			value="xls文件" /></td><td>
		<input id="csv-input" class="input-lgwind" type="button"
			onclick="window.open('${pageContext.request.contextPath }/datas/exportCSVPopup','_self');"
			value="csv文件" /></td>
		</table>
	</div>
	<!-- 用户查询 -->
	<div id="dataSearch">
		<form  action="${pageContext.request.contextPath }/datas/search" method="post">
			<input type="text" class="input-lgwind" name="username" value="${searchStr }" />
			<input id="dataSearch-button" class="input-lgwind" type="submit" value="用户名查询" />
		</form>
	</div>
	<!-- 用户表列表div -->
	<div class="data-div">
		<table>
			<tr>
				<th>序号</th>
				<th>用户名</th>
				<th>姓名</th>
				<th>电话</th>
				<th>邮箱</th>
				<th>岗位</th>
				<th>报道时间</th>
				<th>到现场时间</th>
				<th>职位</th>
				<th>方向</th>
				<th>生日</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${datasList }" varStatus="i" var="item">
				<tr>
					<td>${i.index+1 }</td>
					<td>${item.username }</td>
					<td>${item.name }</td>
					<td>${item.phone }</td>
					<td>${item.email }</td>
					<td>${item.post }</td>
					<td>${item.reporttime }</td>
					<td>${item.starttime }</td>
					<td>${item.position }</td>
					<td>${item.direction }</td>
					<td>${item.birthday }</td>
					<td><a href="${pageContext.request.contextPath }/datas/updatePopup?username=${item.username }" 
					       onclick="">修改</a>
					<a href="${pageContext.request.contextPath }/datas/delete?username=${item.username }">删除</a></td>
				</tr>
			</c:forEach>
			<tr><td colspan="12"><a href="${pageContext.request.contextPath }/datas/addPopup">添加数据</a></td></tr>
		</table>
	</div>
</div>

<!-- 遮罩div 盖章整个页面 -->
<div id="userMask" class="mask-lgwind"></div>
<!-- 添加数据div -->
<div id="dataAdd">
	<h3>添加数据</h3>
	<img onclick="closeDatasAdd();" title="点击退出" class="quit" alt="退出" src="${pageContext.request.contextPath }/picture/quit.png">
	<form class="center-form" action="${pageContext.request.contextPath }/datas/add" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input class="input-lgwind" type="text" name="username" value="${datas.username }" /></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input class="input-lgwind" type="text" name="name" value="${datas.name }" /></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><input class="input-lgwind" type="text" name="phone" value="${datas.phone }" /></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input class="input-lgwind" type="text" name="email" value="${datas.email }" /></td>
			</tr>
			<tr>
				<td>岗位：</td>
				<td><input class="input-lgwind" type="text" name="post" value="${datas.post }" /></td>
			</tr>
			<tr>
				<td>报道时间：</td>
				<td><input class="input-lgwind" type="date" name="reporttime" value="${datas.reporttime }" /></td>
			</tr>
			<tr>
				<td>到现场时间：</td>
				<td><input class="input-lgwind" type="date" name="starttime" value="${datas.starttime }" /></td>
			</tr>
			<tr>
				<td>职位：</td>
				<td><input class="input-lgwind" type="text" name="position" value="${datas.position }" /></td>
			</tr>
			<tr>
				<td>方向：</td>
				<td><input class="input-lgwind" type="text" name="direction" value="${datas.direction }" /></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input class="input-lgwind" type="date" name="birthday" value="${datas.birthday }" /></td>
			</tr>
			<tr></tr><tr></tr>
			<tr><td></td><td><input class="input-lgwind" type="submit" value="确认添加" /></td></tr>
			<tr class="red-font-lgwind"><td colspan="2">${datasAddResult }</td></tr>
		</table>
	</form>
</div>

<!-- 数据修改div -->
<div id="dataUpdate">
	<h3>用户数据表修改</h3>
	<img onclick="closeDatasUpdate();" title="点击退出" class="quit" alt="退出" src="${pageContext.request.contextPath }/picture/quit.png">
	<form class="center-form" action="${pageContext.request.contextPath }/datas/update" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input class="input-lgwind" type="text" name="username" value="${datas.username }" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input class="input-lgwind" type="text" name="name" value="${datas.name }" /></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><input class="input-lgwind" type="text" name="phone" value="${datas.phone }" /></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input class="input-lgwind" type="text" name="email" value="${datas.email }" /></td>
			</tr>
			<tr>
				<td>岗位：</td>
				<td><input class="input-lgwind" type="text" name="post" value="${datas.post }" /></td>
			</tr>
			<tr>
				<td>报道时间：</td>
				<td><input class="input-lgwind" type="date" name="reporttime" value="${datas.reporttime }" /></td>
			</tr>
			<tr>
				<td>到现场时间：</td>
				<td><input class="input-lgwind" type="date" name="starttime" value="${datas.starttime }" /></td>
			</tr>
			<tr>
				<td>职位：</td>
				<td><input class="input-lgwind" type="text" name="position" value="${datas.position }" /></td>
			</tr>
			<tr>
				<td>方向：</td>
				<td><input class="input-lgwind" type="text" name="direction" value="${datas.direction }" /></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input class="input-lgwind" type="date" name="birthday" value="${datas.birthday }" /></td>
			</tr>
			<tr></tr><tr></tr>
			<tr><td></td><td><input class="input-lgwind" type="submit" value="确认修改" /></td></tr>
		</table>
	</form>
</div>

<!-- 导出xls文件弹出层 -->
<div id="exportXLSPopup">
	<h3>导出xls文件</h3>
	<img onclick="closeXlSPopup();" title="点击退出" class="quit" alt="退出" src="${pageContext.request.contextPath }/picture/quit.png">
	<a href="<%=SystemSet.downloadXLS() %>">下载xls文件</a>
</div>

<!-- 导出csv文件弹出层 -->
<div id="exportCSVPopup">
	<h3>导出csv文件</h3>
	<img onclick="closeCSVPopup();" title="点击退出" class="quit" alt="退出" src="${pageContext.request.contextPath }/picture/quit.png">
	<a href="<%=SystemSet.downloadCSV() %>">下载csv文件</a>
</div>

<!-- 接收到添加操作信息时显示遮罩和导出xls文件弹出层 -->
<c:if test="${op=='showExportXLSPopup' }">
<script type="text/javascript">
/**
 * 加载页面执行的操作
 */
window.onload=function(event){
	//显示遮罩，显示修改数据div
	showMask(); showXLSPopup();
}
</script>
</c:if>

<!-- 接收到添加操作信息时显示遮罩和导出csv文件弹出层 -->
<c:if test="${op=='showExportCSVPopup' }">
<script type="text/javascript">
/**
 * 加载页面执行的操作
 */
window.onload=function(event){
	//显示遮罩，显示修改数据div
	showMask(); showCSVPopup();
}
</script>
</c:if>

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