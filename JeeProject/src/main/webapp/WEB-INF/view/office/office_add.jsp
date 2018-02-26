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
				<td>上级机构</td>
				<td><input id="parentId" name="parentId" /></td>
			</tr>
			<tr>
				<td>机构名称</td>
				<td><input id="name" name="name" type="text"></td>
			</tr>
			<tr>
				<td>机构代码</td>
				<td><input id="code" name="code" type="text"></td>
			</tr>
			<tr>
				<td>机构类型</td>
				<td><select name="type" id="type">
						<option value="1">公司</option>
						<option value="2">部门</option>
						<option value="3">小组</option>
				</select></td>
			</tr>
			<tr>
				<td>联系地址</td>
				<td><input type="text" id="address" name="address"></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" id="phone" name="phnoe"></td>
			</tr>
			<tr>
				<td>传真</td>
				<td><input type="text" id="fax" name="fax"></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" id="email" name="email"></td>
			</tr>
			<tr>
				<td>联系人</td>
				<td><input type="text" id="contact" name="contact"></td>
			</tr>
			<tr>
				<td>排序</td>
				<td><input type="text" id="sort" name="sort"></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		var officeTreeDataUrl = "${ctx}/office/treeData";
		var saveUrl = "${ctx}/office/insert";
	</script>
	<script src="${ctx}/assets/js/view/office/office_add.js"
		type="text/javascript"></script>
</body>
</html>
