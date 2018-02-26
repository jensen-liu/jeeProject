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
	<div
		data-options="region:'west',title:'机构树',split:true,tools:'#reloadTool'"
		style="width:200px;">
		<div id="reloadTool">
			<a href="javascript:void(0)" class="icon-reload" onclick="reloadTreeData()"></a>
		</div>
		<ul id="officeTree"></ul>
	</div>
	<div data-options="region:'center'"
		style="padding:5px;background:#eee;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'north',title:'检索条件',split:true"
				style="height:100px;">
				<form method="post" style="padding: 5px;">
					<%-- 机构编码 --%>
					<input name="search_code" />
					<%-- 机构名称 --%>
					<input name="search_name" />
					<%-- 上级机构 --%>
					<input name="search_parentId" />
				</form>
			</div>
			<div data-options="region:'center',title:'机构列表'"
				style="padding:5px;background:#eee;">
				<table id="list" class="easyui-datagrid"></table>
				<div id="toolBar" style="display: none">
					<%-- 添加按钮 --%>
					<a id="addBtn" href="#" class="easyui-linkbutton">添加</a>
					<%-- 修改按钮 --%>
					<a id="editBtn" href="#" class="easyui-linkbutton">修改</a>
				</div>
				<div id="addDialog"></div>
				<div id="editDialog"></div>
			</div>
		</div>
	</div>
</body>


<script type="text/javascript">

	var officeListUrl = "${ctx}/office/selectAll"
	var officeTreeDataUrl = "${ctx}/office/treeData";
	var toAddUrl = "${ctx}/office/toAdd";
	var toEditUrl = "${ctx}/office/toEdit";
	var deleteUrl = "${ctx}/office/delete";
</script>
<script src="${ctx}/assets/js/view/office/office_home.js" type="text/javascript"></script>
</html>
