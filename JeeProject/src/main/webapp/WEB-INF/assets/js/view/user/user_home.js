$(function() {

	initSearchItem();
	initDatagrid();
	initBtnForAdd();
	initBtnForSearch();
	initDialogForAdd();
	initDialogForEdit();
	initForm();
});

function initDatagrid() {
	$('#list').datagrid({
		url : userListUrl,
		fit : true,
		singleSelect : true,
		fitColumns : true,
		toolbar : '#toolBar',
		method : 'post',
		rownumbers : true,
		pagination : true,
		onLoadSuccess : function(row, data) {},
		columns : [ [ {
			title : "id",
			field : "id",
			hidden : true
		}, {
			field : "loginName",
			title : "用户名",
			halign : "center",
			width : 60
		}, {
			field : "name",
			title : '姓名',
			halign : "center",
			width : 80
		}, {
			field : "typeText",
			title : '权限类型',
			halign : "center",
			width : 80
		}, {
			field : 'officeName',
			title : '所属机构',
			halign : "center",
			width : 80
		}, {
			field : 'sysDataText',
			title : '系统数据',
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
			formatter : formatOperation
		} ] ],
		onLoadSuccess : function(row, data) {
			initBtnForOperation();
		}
	});
}

function initDialogForAdd() {
	var content = '<iframe id="addFormIframe" src="' + toAddUrl + '" width="100%" height="99%" frameborder="0" scrolling="auto"></iframe>';
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

function initDialogForEdit() {
	var content = '<iframe id="editFormIframe" src="' + toEditUrl + '" width="100%" height="99%" frameborder="0" scrolling="auto"></iframe>';
	$("#editDialog").dialog({
		title : '修改机构',
		width : 600,
		height : 450,
		content : content,
		closed : true,
		cache : false,
		modal : true,
		constrain : true,
		maximizable : true,
		onBeforeOpen : function() {},
		onClose : function() {},
		buttons : [ {
			id : 'addSaveBtn',
			text : '保存',
			iconCls : 'icon-save',
			handler : function() {
				$("#editFormIframe")[0].contentWindow.save();
			}
		}, {
			text : '关闭',
			iconCls : 'icon-cancel',
			handler : function() {
				$("#editDialog").dialog("close");
			}
		} ]
	});
}

function initSearchItem() {
	$("#search_name").textbox({
		label : "角色名称：",
		labelWidth : "70",
		width : "200"
	});

	$("#search_type").textbox({
		label : "角色类型：",
		labelWidth : "70",
		width : "200"
	});
}

function initBtnForAdd() {
	$("#addBtn").linkbutton({
		iconCls : 'icon-add',
		plain : true,
		onClick : function() {
			$("#addDialog").dialog("open");
		}
	});
}
function initBtnForSearch() {
	$("#searchBtn").linkbutton({
		iconCls : 'icon-search',
		onClick : function() {
			$("#searchForm").form("submit");
		}
	});
}
function initBtnForOperation() {
	$('.button-red').linkbutton({
		width : 45,
		height : 20,
		onClick : function() {
			var options = $(this).linkbutton("options");
			deleteRole(options.id);
		}
	});
	$('.button-blue').linkbutton({
		width : 45,
		height : 20,
		onClick : function() {
			var options = $(this).linkbutton("options");
			openEditDialog(options.id);
		}
	});
}
function initForm() {
	$("#searchForm").form({
		onSubmit : function(param) {
			param.search_name = $("#search_name").textbox("getValue");
			$('#list').datagrid("load", param);
			return false;
		}
	});
}
function formatOperation(value, row, index) {
	var operation = "<a href='#' class='button-red' id='" + row.id + "'>删除</a> ";
	operation += "<a href='#' class='button-blue' id='" + row.id + "'>编辑</a>";
	return operation;
}


function deleteRole(id) {
	$.messager.confirm('系统提示', '是否确认删除？', function(r) {
		if (r) {
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
	});
}
function loadList() {
	$("#list").datagrid("load");
}

function disableAddSaveBtn() {
	$("#addSaveBtn").linkbutton("disable");
}
/**
 * 启用添加保存按钮
 */
function enableAddSaveBtn() {
	$("#addSaveBtn").linkbutton("enable");
}
/**
 * 禁用编辑保存按钮
 */
function disableEditSaveBtn() {
	$("#editSaveBtn").linkbutton("disable");
}
/**
 * 启用编辑保存按钮
 */
function enableEditSaveBtn() {
	$("#editSaveBtn").linkbutton("enable");
}
/**
 * 打开添加机构面板
 */
function openAddDialog() {
	$("#addDialog").dialog("open");
}
/**
 * 关闭添加表单面板
 */
function closeAddDialog() {
	$("#addDialog").dialog("close");
}
/**
 * 打开编辑表单面板
 */
function openEditDialog(id) {
	$("#editDialog").dialog("open");
	$("#editFormIframe")[0].contentWindow.loadForm(id);
}
/**
 * 关闭编辑表单面板
 */
function closeEditDialog() {
	$("#editDialog").dialog("close");
}