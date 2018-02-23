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
	<div data-options="region:'west',title:'机构树',split:true"
		style="width:200px;"></div>
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
				<div id="toolBar">
					<a id="addBtn" href="#" class="easyui-linkbutton"
						data-options="iconCls:'icon-edit',plain:true" /a> <a
						id="editBtn" href="#" class="easyui-linkbutton"
						data-options="iconCls:'icon-help',plain:true" /a>
				</div>

			</div>
		</div>
	</div>
</body>


<script type="text/javascript">

	var officeListUrl = "${ctx}/office/selectAll"

	$(function() {

		initSearchItem();
		initList();
	});

	function initList() {
		$('#list').datagrid({
			url : officeListUrl,
			fit : true,
			fitColumns : true,
			toolbar : '#toolBar',
			method : 'post',
			rownumbers : true,
			onLoadSuccess : function(row, data) {},
			columns : [ [ {
				title : "id",
				field : "id",
				hidden : true
			}, {
				field : "text",
				title : "机构名称",
				halign : "center",
				width : 60
			}, {
				field : "code",
				title : '机构代码',
				halign : "center",
				width : 80
			}, {
				field : "typeName",
				title : '机构类型',
				halign : "center",
				width : 80
			}, {
				field : 'path',
				title : '机构路径',
				halign : "center",
				width : 80
			}, {
				field : 'sort',
				title : '排序',
				halign : "center",
				align : "center",
				width : 80
			}, {
				field : 'operation',
				title : '操作',
				halign : "center",
				align : "center",
				width : 80,
				formatter : operation
			} ] ]
		});
	}

	function initSearchItem() {
		$("input[name='search_code']").textbox({
			label : "机构编码：",
			labelWidth : "70",
			width : "200"
		});

		$("input[name='search_name']").textbox({
			label : "机构名称：",
			labelWidth : "70",
			width : "200"
		});

		$("input[name='search_parentId']").textbox({
			label : "上级机构：",
			labelWidth : "70",
			width : "200"
		});

	}

	function initAddBtn() {
	}

	function initEditBtn() {
	}

	/**
	 * 格式化操作列的按钮
	 */
	function operation(value, row, index) {
		var operation = "<a href='#' class='button-red' id='" + row.id + "'>删除</a> ";
		operation += "<a href='#' class='button-blue' id='" + row.id + "'>编辑</a>"
		return operation;
	}
</script>

</html>
