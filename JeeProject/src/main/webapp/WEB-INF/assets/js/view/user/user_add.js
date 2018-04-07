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
	$('#addForm').form({
		url : saveUrl,
		novalidate : true,
		onSubmit : function() {
			$(this).form("enableValidation");
			var flag = $("#addForm").form("validate");
			if (!flag) {
				parent.enableAddSaveBtn();
				return false;
			}
		},
		success : function(data) {
			data = $.parseJSON(data);
			if (data.result == 'ok') {
				parent.closeAddDialog();
				parent.loadList();
			} else {
				$.messager.alert('系统提示', data.response.msg, 'error');
			}
			parent.enableAddSaveBtn();
			$(this).form("disableValidation");
		}
	});
}
function save() {
	parent.disableAddSaveBtn();
	$('#addForm').form("submit");
}