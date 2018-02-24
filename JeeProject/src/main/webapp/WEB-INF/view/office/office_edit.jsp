<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="favicon.ico">
<link rel="Shortcut Icon" href="favicon.ico" />

<link href="/lib/jquery-easyui-1.5.3/themes/icon.css" rel="stylesheet"
	type="text/css">
<link href="/lib/insdep/reset.min.css" rel="stylesheet" type="text/css">
<link href="/lib/insdep/easyui_full.css" rel="stylesheet"
	type="text/css">
<link href="/lib/insdep/iconfont/iconfont.css" rel="stylesheet"
	type="text/css">

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
					<td>
						<select name="type" id="type">
							<option value="0">机构</option>
							<option value="1">部门</option>
						</select>
					</td>
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
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="/lib/artTemplate/artTemplate.js"></script>
	<script type="text/javascript" src="/static/hzrb/js/tools.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="/lib/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/lib/insdep/insdep-extend.min.js"></script>
	<script type="text/javascript">
		var ctx = "${ctx}";
	</script>
	<script type="text/javascript" src="/static/hzrb/js/sys_set/organiza/orgian_add.js"></script>
	<script type="text/javascript" src="/static/hzrb/js/common/timeout.js"></script>
</body>
</html>
