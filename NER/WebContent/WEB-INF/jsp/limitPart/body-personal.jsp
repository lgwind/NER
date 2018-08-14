<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.lgwind.controller.util.UserUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.lgwind.domain.Datas"%>
<%@ page import="com.lgwind.dao.DatasDao"%>
<%
    //获得登录的用户名\角色\登录页面
    String usernameLgwind;
    String userroleLgwind;
    String pageLgwind;
    //获取登录的用户名
    if (UserUtil.username.equals("还没保存用户名哦~")) {
        usernameLgwind = (String) session
                .getAttribute("usernameLgwind");
    } else {
        usernameLgwind = UserUtil.username;
        UserUtil.username = "还没保存用户名哦~";
    }
    //获取登录的角色
    if (UserUtil.userrole.equals("还没保存用户角色哦~")) {
        userroleLgwind = (String) session
                .getAttribute("userroleLgwind");
    } else {
        userroleLgwind = UserUtil.userrole;
        UserUtil.userrole = "还没保存用户角色哦~";
    }
    //获取登录页面
    if (UserUtil.page.equals("null")) {
        pageLgwind = (String) session.getAttribute("pageLgwind");
    } else {
        pageLgwind = UserUtil.page;
        UserUtil.page = "null";
    }
    System.out
            .println("登录的用户为" + userroleLgwind + "：" + usernameLgwind);
    System.out.println("页面定位：" + pageLgwind);
    //将登录的用户名和角色放入session
    session.setAttribute("usernameLgwind", usernameLgwind);
    session.setAttribute("userroleLgwind", userroleLgwind);
    session.setAttribute("pageLgwind", pageLgwind);
%>
<!-- 引入外部css代码 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-body-personal.css" />
<div class="body-div-lgwind">
	<h1 id="userTitle">个人资料</h1>
	<%
	    //根据用户名查询表单信息
	    List<Datas> datasList = new DatasDao().getAll(usernameLgwind);
	    Datas datas = new Datas();
	    ;
	    if (datasList.size() > 0) {
	        datas = datasList.get(0);
	    }
	%>
	<form class="password-form"
		action="${pageContext.request.contextPath }/personal/update"
		method="post">
		<table>
			<tr>
				<td class="td">用户名：</td>
				<td><input class="input-lgwind" type="text" name="username"
					value="<%=usernameLgwind%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<td class="td">姓名：</td>
				<td><c:choose>
						<c:when test="${datas.name==null }">
							<input class="input-lgwind" type="text" name="name"
								value="<%=datas.getName()%>" />
						</c:when>
						<c:otherwise>
							<input class="input-lgwind" type="text" name="name"
								value="${datas.name }" />
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td class="td">电话：</td>
				<td><c:choose>
						<c:when test="${datas.phone==null }">
							<input class="input-lgwind" type="text" name="phone"
								value="<%=datas.getPhone()%>" />
						</c:when>
						<c:otherwise>
							<input class="input-lgwind" type="text" name="phone"
								value="${datas.phone }" />
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td class="td">邮箱：</td>
				<td><c:choose>
						<c:when test="${datas.email==null }">
							<input class="input-lgwind" type="text" name="email"
								value="<%=datas.getEmail()%>" />
						</c:when>
						<c:otherwise>
							<input class="input-lgwind" type="text" name="email"
								value="${datas.email }" />
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td class="td">岗位：</td>
				<td><c:choose>
						<c:when test="${datas.post==null }">
							<input class="input-lgwind" type="text" name="post"
								value="<%=datas.getPost()%>" />
						</c:when>
					<c:otherwise>
							<input class="input-lgwind" type="text" name="post"
								value="${datas.post }" />
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td class="td">报道时间：</td>
				<td><c:choose>
						<c:when test="${datas.reporttime==null }">
							<input class="input-lgwind" type="date" name="reporttime"
								value="<%=datas.getReporttime()%>" />
						</c:when>
						<c:otherwise>
							<input class="input-lgwind" type="date" name="reporttime"
								value="${datas.reporttime }" />
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td class="td">到现场时间：</td>
				<td><c:choose>
						<c:when test="${datas.starttime==null }">
							<input class="input-lgwind" type="date" name="starttime"
								value="<%=datas.getStarttime()%>" />
						</c:when>
						<c:otherwise>
							<input class="input-lgwind" type="date" name="starttime"
								value="${datas.starttime }" />
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td class="td">职位：</td>
				<td><c:choose>
						<c:when test="${datas.position==null }">
							<input class="input-lgwind" type="text" name="position"
								value="<%=datas.getPosition()%>" />
						</c:when>
						<c:otherwise>
							<input class="input-lgwind" type="text" name="position"
								value="${datas.position }" />
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td class="td">方向：</td>
				<td><c:choose>
						<c:when test="${datas.direction==null }">
							<input class="input-lgwind" type="text" name="direction"
								value="<%=datas.getDirection()%>" />
						</c:when>
						<c:otherwise>
							<input class="input-lgwind" type="text" name="direction"
								value="${datas.direction }" />
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td class="td">生日：</td>
				<td><c:choose>
						<c:when test="${datas.birthday==null }">
							<input class="input-lgwind" type="date" name="birthday"
								value="<%=datas.getBirthday()%>" />
						</c:when>
						<c:otherwise>
							<input class="input-lgwind" type="date" name="birthday"
								value="${datas.birthday }" />
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><input id="submit" class="input-lgwind" type="submit"
					value="确认修改" /></td>
			</tr>
			<tr class="red-font-lgwind">
				<td colspan="2">${personalResult }</td>
			</tr>
		</table>
	</form>
</div>