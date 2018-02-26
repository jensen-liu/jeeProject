$(function() {

	initSearchItem();
	initDatagrid();
	initTree();
	initBtnForAdd();
	initBtnForEdit();
	initDialogForAdd();
});

function initDatagrid() {
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

function initBtnForAdd() {
	$("#addBtn").linkbutton({
		iconCls : 'icon-add',
		plain : true,
		onClick : function() {
			$("#addDialog").dialog("open");
		}
	});
}

function initBtnForEdit() {
	$("#editBtn").linkbutton({
		iconCls : 'icon-edit',
		plain : true
	});
}

function initBtnForOperation() {
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

function initTree() {
	$('#officeTree').tree({
		url : officeTreeDataUrl,
		onClick : function(node) {
			alert(node.id);
		}
	});
}

function formatOperation(value, row, index) {
	var operation = "<a href='#' class='button-red' id='" + row.id + "'>删除</a> ";
	operation += "<a href='#' class='button-blue' id='" + row.id + "'>编辑</a>";
	return operation;
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

function reloadTreeData() {
	$("#officeTree").tree("reload");
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