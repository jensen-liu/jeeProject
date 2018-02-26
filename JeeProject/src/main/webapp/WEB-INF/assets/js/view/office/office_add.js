$(function() {
	initForm();
	initTextBoxForName();
	initTextBoxForCode();
	initTextBoxForAddress();
	initTextBoxForPhone();
	initTextBoxForFax();
	initTextBoxForEmail();
	initTextBoxForContact();
	initComboTreeForParentId();
	initComboboxForType();
	initNumberBoxForSort();
});
function initTextBoxForName() {
	$("#name").textbox({
		width : 200,
		required : true
	});
}
function initTextBoxForCode() {
	$("#code").textbox({
		width : 200,
		required : true
	});
}
function initTextBoxForAddress() {
	$("#address").textbox({
		width : 200
	});
}
function initComboTreeForParentId() {
	$('#parentId').combotree({
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
function initTextBoxForPhone() {
	$("#phone").textbox({
		width : 200
	});
}
function initTextBoxForFax() {
	$("#fax").textbox({
		width : 200
	});
}
function initTextBoxForEmail() {
	$("#email").textbox({
		width : 200
	});
}
function initTextBoxForContact() {
	$("#contact").textbox({
		width : 200
	});
}

function initNumberBoxForSort() {
	$('#sort').numberbox({
		min : 0,
		precision : 0,
		width : 200
	});
}

function initForm() {
	$('#addForm').form({
		url : saveUrl,
		novalidate : false,
		onSubmit : function() {
			$(this).form("enableValidation");
			var flag = $("#form").form("validate");
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
	$('#addForm').submit();
}