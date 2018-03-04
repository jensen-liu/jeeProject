$(function() {
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
	initForm();
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