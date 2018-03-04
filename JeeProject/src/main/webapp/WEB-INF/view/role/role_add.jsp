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
	<form id="addForm" method="post">
		<table class="table table-celled">
			<tr>
				<td>角色名称</td>
				<td><input id="name" name="name" /></td>
			</tr>
			<tr>
				<td>英文名称</td>
				<td><input id="enName" name="enName" type="text"></td>
			</tr>
			<tr>
				<td>所属机构</td>
				<td><input id="office" name="office" type="text"></td>
			</tr>
			<tr>
				<td>角色类型</td>
				<td><select name="type" id="type">
						<option value="1">任务分配</option>
						<option value="2">管理角色</option>
						<option value="3">普通角色</option>
				</select></td>
			</tr>
			<tr>
				<td>数据范围</td>
				<td><select name="dataScope" id="dataScope">
						<option value="1">所有数据</option>
						<option value="2">所在公司及以下数据</option>
						<option value="3">所在公司数据</option>
						<option value="4">所在部门及以下数据</option>
						<option value="5">所在部门数据</option>
						<option value="6">仅本人数据</option>
						<option value="7">按明细设置</option>
				</select></td>
			</tr>
			<tr>
				<td>排序</td>
				<td><input type="text" id="sort" name="sort"></td>
			</tr>
			<tr>
				<td>权限</td>
				<td><input id="permissions" name="permissions" type="hidden"/>
					<ul id="permissionTree"></ul></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		var officeTreeDataUrl = "${ctx}/office/treeData";
		var permissionTreeDataUrl = "${ctx}/permission/treeData";
		var saveUrl = "${ctx}/role/insert";
	</script>
	<script src="${ctx}/assets/js/view/role/role_add.js"
		type="text/javascript"></script>
</body>
</html>
