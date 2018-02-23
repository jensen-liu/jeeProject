<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/assets/css/font-awesome.min.css" rel="stylesheet" />
<link href="${ctx}/assets/css/ace.min.css" rel="stylesheet" />
<link href="${ctx}/assets/css/ace-rtl.min.css" rel="stylesheet" />
<link href="${ctx}/assets/css/ace-skins.min.css" rel="stylesheet" />
<link href="${ctx}/assets/css/style.css" />
<link href="${ctx}/assets/css/login.css" />
<link href="${ctx}/assets/plugins/jquery-easyui-1.5.3/themes/icon.css"
	rel="stylesheet" type="text/css">
<link href="${ctx}/assets/plugins/insdep/reset.min.css" rel="stylesheet"
	type="text/css">
<link href="${ctx}/assets/plugins/insdep/easyui_full.css"
	rel="stylesheet" type="text/css">
<link href="${ctx}/assets/plugins/insdep/iconfont/iconfont.css"
	rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="${ctx}/favicon.ico" />

<script src="${ctx}/assets/js/ace-extra.min.js"></script>
<script src="${ctx}/assets/js/jquery-1.10.2.min.js"></script>
<script src="${ctx}/assets/plugins/layer/layer.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${ctx}/assets/plugins/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${ctx}/assets/plugins/insdep/insdep-extend.min.js"></script>

<title>登录</title>
</head>

<body class="login-layout">
	<div class="logintop">
		<span>欢迎后台管理界面平台</span>
		<ul>
			<li><a href="#">返回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>
	<div class="loginbody">
		<div class="login-container">
			<div class="center">
				<h1>
					<i class="icon-leaf green"></i> <span class="orange">思美软件</span> <span
						class="white">后台管理系统</span>
				</h1>
				<h4 class="white">Background Management System</h4>
			</div>

			<div class="space-6"></div>

			<div class="position-relative">
				<div id="login-box" class="login-box widget-box no-border visible">
					<div class="widget-body">
						<div class="widget-main">
							<h4 class="header blue lighter bigger">
								<i class="icon-coffee green"></i> 管理员登陆
							</h4>

							<div class="login_icon">
								<img src="${ctx}/assets/images/login/login.png" />
							</div>

							<form class="" method="post" id="loginForm" action="${ctx}/login">
								<fieldset>
									<label class="block clearfix"> <span
										class="block input-icon input-icon-right"> <input
											type="text" class="form-control" placeholder="登录名"
											name="loginName"> <i class="icon-user"></i>
									</span>
									</label> <label class="block clearfix"> <span
										class="block input-icon input-icon-right"> <input
											type="password" class="form-control" placeholder="密码"
											name="password"> <i class="icon-lock"></i>
									</span>
									</label> <label class="block clearfix"> <span
										class="block input-icon input-icon-right"> <input
											type="text" class="form-control" placeholder="验证码"
											name="verifyCode" style="width:120px;display: inline-block;">
											<img id="verifyCode" alt="验证码" src="${ctx}/verifyCode"
											style="display: inline-block;cursor: pointer;">
									</span>
									</label>
									<div class="space"></div>

									<div class="clearfix">
										<label class="inline"> <input type="checkbox"
											name="rememberMe" class="ace"> <span class="lbl">保存密码</span>
										</label> <input type="submit" value="登录"
											class="width-35 pull-right btn btn-sm btn-primary" />
									</div>

									<div class="space-4"></div>
								</fieldset>
							</form>

							<div class="social-or-login center">
								<span class="bigger-110">通知</span>
							</div>
							${message}
							<div class="social-login center">本网站系统不再对IE8以下浏览器支持，请见谅。</div>
						</div>
						<!-- /widget-main -->

						<div class="toolbar clearfix"></div>
					</div>
					<!-- /widget-body -->
				</div>
				<!-- /login-box -->
			</div>
			<!-- /position-relative -->
		</div>
	</div>
	<div class="loginbm">
		版权所有 2018 <a href="">Jensen个人所有</a>
	</div>
	<strong></strong>
</body>
</html>
<script>
	var ctx = "${ctx}";
	var loginUrl = ctx + "/login";
	var indexUrl = ctx + "/index";
	var verifyCodeUrl = ctx + "/verifyCode";
	$(function() {
		initForm();
		initVerifyCode();
	});

	function initForm() {
		$("#loginForm").form({
			url : loginUrl,
			onSubmit : function() {
				var str = "";
				$("input[type$='text']").each(function(n) {
					if ($(this).val() == "") {
						layer.alert(str += "" + $(this).attr("name") + "不能为空！\r\n", {
							title : '提示框',
							icon : 0,
						});
						return false;
					}
				});
			},
			success : function(data) {
				data = jQuery.parseJSON(data);
				if (data.result == 'ok') {
					location.href = indexUrl;
				} else {
					alert(data.response.msg);
				}
			}
		});
	}

	function initVerifyCode() {
		$("#verifyCode").click(function() {
			var src = $(this).attr("src");
			$(this).attr("src", src + "?timestamp=" + (new Date()).valueOf());
		});
	}

	$('#login_btn').on('click', function() {
		$("#loginForm").form("submit");
	});
</script>