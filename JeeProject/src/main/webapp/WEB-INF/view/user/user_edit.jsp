<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>

<jsp:include page="../common/easyui.jsp"></jsp:include>

<!--/meta 作为公共模版分离出去-->

<meta name="keywords" content="">
<meta name="description" content="">
<style type="text/css">
html, body {
	height: 100%;
	width: 100%;
}
</style>
</head>
<body>
	<form id="editForm" method="post">
		<input type="hidden" name="id" />
		<table class="table table-celled">
			<tr>
				<td>用户名</td>
				<td><input id="loginName" name="loginName" /></td>
			</tr>
			<tr>
				<td>登录密码</td>
				<td><input id="password" name="password" type="text"></td>
			</tr>
			<tr>
				<td>工号</td>
				<td><input id="userNo" name="userNo" type="text"></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input id="name" name="name" type="text"></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input id="email" name="email" type="text"></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input id="phone" name="phone" type="text"></td>
			</tr>
			<tr>
				<td>手机</td>
				<td><input id="mobile" name="mobile" type="text"></td>
			</tr>
			<tr>
				<td>传真</td>
				<td><input id="fax" name="fax" type="text"></td>
			</tr>
			<tr>
				<td>用户状态</td>
				<td><select name="state" id="state">
						<option value="0">启用</option>
						<option value="1">禁用</option>
				</select></td>
			</tr>
			<tr>
				<td>归属公司</td>
				<td><select name="company" id="company">
				</select></td>
			</tr>
			<tr>
				<td>归属部门</td>
				<td><select name="office" id="office">
				</select></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		var officeTreeDataUrl = "${ctx}/office/treeData";
		var saveUrl = "${ctx}/user/update";
		var loadFormUrl = "${ctx}/user/select";
	</script>
	<script src="${ctx}/assets/js/view/user/user_edit.js"
		type="text/javascript"></script>
</body>
</html>
