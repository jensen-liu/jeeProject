<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div style="width:90%;height:90%;padding: 5px 10px;margin:0 auto;">
		<form id="form" method="post">
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
							<option value="0">机构</option>
							<option value="1">部门</option>
					</select></td>
				</tr>
				<tr>
					<td>机构备注</td>
					<td><input type="text" id="note" name="note"></td>
				</tr>
				<tr>
					<td>排序</td>
					<td><input type="text" id="sort" name="sort"></td>
				</tr>
			</table>
		</form>
	</div>
	</body>
</html>
