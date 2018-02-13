<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>安居客</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/ace.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-tab.css" />
<link rel="shortcut icon" href="${ctx}/favicon.ico" />
<script src="assets/js/ace-extra.min.js"></script>
</head>

<body>
	<jsp:include page="top.jsp"></jsp:include>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<div class="sidebar" id="sidebar">
				<ul class="nav nav-list" id="menu"></ul>
				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
				</div>
			</div>
			<div class="main-content">
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12" style="padding-left:5px;">
							<ul class="nav nav-tabs" role="tablist">
								<li class="active"><a href="#index" role="tab" data-toggle="tab"><i class="glyphicon icon-home"></i>系统首页</a></li>
							</ul>
							<div class="tab-content">
								<div role="tabpanel" class="tab-pane active" id="index"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 
				<jsp:include page="setting.jsp"></jsp:include>
			 -->
		</div>

		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>

	<script src="${ctx}/assets/js/jquery.min.js"></script>
	<script src="${ctx}/assets/js/bootstrap.min.js"></script>
	<!-- ace scripts -->
	<script src="${ctx}/assets/js/ace-elements.min.js"></script>
	<script src="${ctx}/assets/js/ace.min.js"></script>
	<script src="${ctx}/assets/js/bootstrap-tab.js"></script>
	<script src="${ctx}/assets/js/sidebar-menu.js"></script>
</body>
</html>

