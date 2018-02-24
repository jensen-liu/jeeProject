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
			<a href="javascript:void(0)" class="icon-add" onclick="reloadTreeData()"></a>
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
				<div id="toolBar">
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
	$(function() {

		initSearchItem();
		initList();
		initOfficeTree();
		initAddBtn();
		initEditBtn();
		initAddDialog();
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
			} ] ],
			onLoadSuccess : function(row, data) {
				initOperBtn();
			}
		});
	}

	function initAddDialog() {
		var content = '<iframe id="addFormIframe" src="' + toAddUrl + '" width="100%" height="99%" frameborder="0" scrolling="no"></iframe>';
		$("#addDialog").dialog({
			title : '添加机构',
			width : 600,
			height : 450,
			content : content,
			closed : true,
			cache : false,
			modal : true,
			constrain : true,
			maximizable : true,
			onBeforeOpen : function() {
				//$("#addFormIframe")[0].contentWindow.reloadTree();
			},
			onClose : function() {
				//$("#addFormIframe")[0].contentWindow.clear();
			},
			buttons : [ {
				id : 'addSaveBtn',
				text : '保存',
				iconCls : 'icon-save',
				handler : function() {
					$("#addFormIframe")[0].contentWindow.save();
				}
			}, {
				text : '关闭',
				iconCls : 'icon-cancel',
				handler : function() {
					$("#addDialog").dialog("close");
				}
			} ]
		});
	}

	function initEditDialog() {
		$("#editDialog").dialog({

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
		$("#addBtn").linkbutton({
			iconCls : 'icon-add',
			plain : true,
			onClick : function() {
				$("#addDialog").dialog("open");
			}
		});
	}

	function initEditBtn() {
		$("#editBtn").linkbutton({
			iconCls : 'icon-edit',
			plain : true
		});
	}

	function initOfficeTree() {
		$('#officeTree').tree({
			url : officeTreeDataUrl,
			onClick : function(node) {
				alert(node.id);
			}
		});
	}

	/**
	 * 格式化操作列的按钮
	 */
	function operation(value, row, index) {
		var operation = "<a href='#' class='button-red' id='" + row.id + "'>删除</a> ";
		operation += "<a href='#' class='button-blue' id='" + row.id + "'>编辑</a>"
		return operation;
	}
	function initOperBtn() {
		$('.button-red').linkbutton({
			width : 45,
			height : 20,
			onClick : function() {
				var options = $(this).linkbutton("options");
				deleteOffice(options.id);
			}
		});
		$('.button-blue').linkbutton({
			width : 45,
			height : 20,
			onClick : function() {
				var options = $(this).linkbutton("options");
			}
		});
	}

	function deleteOffice(id) {
		$.messager.confirm('系统提示', '是否确认删除？', function(r) {
			if (r) {
				var node = $("#officeTree").tree("find", id);
				var children = $("#officeTree").tree("getChildren", node.target);
				if (children.length > 0) {
					$.messager.alert('系统提示', '该机构下存在子机构，无法删除!', 'info');
				} else {
					$.post(deleteUrl, {
						"id" : id
					}, function(data) {
						if (data.result == 'ok') {
							loadList() ;
						} else {
							$.messager.alert('系统提示', data.response.msg, 'info');
						}
					}, "json");
				}
			}
		});
	}
	function loadList() {
		$("#list").datagrid("load");
	}
	
	function reloadTreeData(){
		$("#officeTree").tree("reload");
	}
	
</script>

</html>
