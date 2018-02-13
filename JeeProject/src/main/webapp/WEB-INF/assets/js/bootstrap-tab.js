var addTabs = function(options) {
	// var rand = Math.random().toString();
	// var id = rand.substring(rand.indexOf('.') + 1);
	var url = window.location.protocol + '//' + window.location.host;
	options.url = url + options.url;
	id = "tab_" + options.id;
	$(".active").removeClass("active");
	// 如果TAB不存在，创建一个新的TAB
	if (!$("#" + id)[0]) {
		// 固定TAB中IFRAME高度
		mainHeight = $(document.body).height() - 90;
		// 创建新TAB的title
		title = '<li role="presentation" id="tab_' + id + '"><a href="#' + id
				+ '" aria-controls="' + id
				+ '" role="tab" data-toggle="tab"><i class="' + options.icon
				+ '"></i>' + options.title;
		// 是否允许关闭
		if (options.close) {
			title += ' <i class="glyphicon icon-remove-sign" tabclose="' + id
					+ '"></i>';
		}
		title += '</a></li>';
		// 是否指定TAB内容
		if (options.content) {
			content = '<div role="tabpanel" class="tab-pane" id="' + id + '">'
					+ options.content + '</div>';
		} else {// 没有内容，使用IFRAME打开链接
			content = '<div role="tabpanel" class="tab-pane" id="'
					+ id
					+ '"><iframe src="'
					+ options.url
					+ '" width="100%" height="'
					+ mainHeight
					+ '" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes" onload="changeFrameHeight(this)"></iframe></div>';
		}
		// 加入TABS
		$(".nav-tabs").append(title);
		$(".tab-content").append(content);
	}
	// 激活TAB
	$("#tab_" + id).addClass('active');
	$("#" + id).addClass("active");
};
var closeTab = function(id) {
	// 如果关闭的是当前激活的TAB，激活他的前一个TAB
	if ($("li.active").attr('id') == "tab_" + id) {
		$("#tab_" + id).prev().addClass('active');
		$("#" + id).prev().addClass('active');
	}
	// 关闭TAB
	$("#tab_" + id).remove();
	$("#" + id).remove();
};
$(function() {
	mainHeight = $(document.body).height() - 45;
	$('.main-left,.main-right').height(mainHeight);
	$("[addtabs]").click(function() {
		addTabs({
			id : $(this).attr("id"),
			title : $(this).attr('title'),
			close : true
		});
	});

	$(".nav-tabs").on("click", "[tabclose]", function(e) {
		id = $(this).attr("tabclose");
		closeTab(id);
	});
});
var changeFrameHeight = function(that) {
	$(that).height(document.documentElement.clientHeight - 115);
	$(that).parent(".tab-pane").height(
			document.documentElement.clientHeight - 130);
}
window.onresize = function() {
	var target = $(".tab-content .active iframe");
	changeFrameHeight(target);
}
$(function() {
	// tab页向左向右移动
	$('.nav-my-tab .leftbackward').click(function() {
		var strLeft = $('.nav-my-tab .middletab .nav-tabs').css('left');
		var iLeft = parseInt(strLeft.replace('px', ''));
		if (iLeft >= 0) {
			return;
		} else {
			//debugger;
			var totalWidth = 0;
			var lis = $(".nav-tabs li");
			for (var i = 0; i < lis.length; i++) {
				var item = lis[i];
				totalWidth -= $(item).width();
				if (iLeft > totalWidth) {
					iLeft += $(item).width();
					break;
				}
			}
			;
			if (iLeft > 0) {
				iLeft = 0;
			}
			$(".nav-my-tab .middletab .nav-tabs").animate({
				left : iLeft + 'px'
			});
		}
	});
	$('.nav-my-tab .rightforward').click(function() {
		var strLeft = $('.nav-my-tab .middletab .nav-tabs').css('left');
		var iLeft = parseInt(strLeft.replace('px', ''));
		var totalWidth = 0;
		$.each($(".nav-tabs li"), function(key, item) {
			totalWidth += $(item).width();
		});
		var tabsWidth = $(".nav-my-tab .middletab").width();
		if (totalWidth > tabsWidth) {
			//debugger;
			if (totalWidth - tabsWidth <= Math.abs(iLeft)) {
				return;
			}
			var lis = $(".nav-tabs li");
			totalWidth = 0;
			for (var i = 0; i < lis.length; i++) {
				var item = lis[i];
				totalWidth -= $(item).width();
				if (iLeft > totalWidth) {
					iLeft -= $(item).width();
					break;
				}
			}
			;
			$(".nav-my-tab .middletab .nav-tabs").animate({
				left : iLeft + 'px'
			});
		}
	});
});