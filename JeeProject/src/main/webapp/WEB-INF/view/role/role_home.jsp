<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<jsp:include page="../common/easyui.jsp"></jsp:include>
</head>

<body class="easyui-layout">
	<div data-options="region:'north',title:'检索条件',split:true"
		style="height:100px;">
		<form id="searchForm" method="post" style="padding: 5px;">
			<%-- 角色名称 --%>
			<input id="search_name" name="search_name"/>
			<a id="searchBtn">查询</a>
		</form>
	</div>
	<div data-options="region:'center',title:'角色列表'"
		style="padding:5px;background:#eee;">
		<table id="list" class="easyui-datagrid"></table>
		<div id="toolBar" style="display: none">
			<%-- 添加按钮 --%>
			<a id="addBtn" href="#" class="easyui-linkbutton">添加</a>
		</div>
		<div id="addDialog"></div>
		<div id="editDialog"></div>
	</div>
</body>


<script type="text/javascript">

	var roleListUrl = "${ctx}/role/selectAll"
	var toAddUrl = "${ctx}/role/toAdd";
	var toEditUrl = "${ctx}/role/toEdit";
	var deleteUrl = "${ctx}/role/delete";
</script>
<script src="${ctx}/assets/js/view/role/role_home.js"
	type="text/javascript"></script>
</html>
