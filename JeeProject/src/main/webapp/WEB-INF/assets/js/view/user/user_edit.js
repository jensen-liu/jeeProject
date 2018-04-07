$(function() {
	initTextBoxForName();
	initTextBoxForEnName();
	initComboTreeForOffice();
	initComboboxForType();
	initComboboxForDataScope();
	initTreeForPermission();
	initNumberBoxForSort();
	initForm();
});
function initTextBoxForName() {
	$("#name").textbox({
		width : 200,
		required : true
	});
}
function initTextBoxForEnName() {
	$("#enName").textbox({
		width : 200,
		required : true
	});
}
function initComboTreeForOffice() {
	$('#office').combotree({
		width : 200,
		url : officeTreeDataUrl,
		required : true
	});
}
function initComboboxForType() {
	$("#type").combobox({
		width : 200,
		editable : false,
		panelHeight : "auto"
	});
}
function initComboboxForDataScope() {
	$("#dataScope").combobox({
		width : 200,
		editable : false,
		panelHeight : "auto"
	});
}
function initNumberBoxForSort() {
	$('#sort').numberbox({
		min : 0,
		precision : 0,
		width : 200
	});
}
function initTreeForPermission() {
	$('#permissionTree').tree({
		url : permissionTreeDataUrl
	});
}
function initForm() {
	$('#editForm').form({
		url : saveUrl,
		novalidate : true,
		onSubmit : function() {
			$(this).form("enableValidation");
			var flag = $("#editForm").form("validate");
			if (!flag) {
				parent.enableEditSaveBtn();
				return false;
			}
		},
		success : function(data) {
			data = $.parseJSON(data);
			if (data.result == 'ok') {
				parent.closeEditDialog();
				parent.loadList();
			} else {
				$.messager.alert('系统提示', data.response.msg, 'error');
			}
			parent.enableEditSaveBtn();
			$(this).form("disableValidation");
		}
	});
}
function save() {
	parent.disableEditSaveBtn();
	$('#editForm').form("submit");
}
/**
 * 回填表单数据
 */
function loadForm(id) {
	$.post(loadFormUrl, {
		"id" : id
	}, function(data) {
		if (data.result == "ok") {
			$("#editForm").form("load", data.response);
		} else {
			$.messager.alert('系统提示', data.response.msg, 'error');
		}
	}, "json");
}