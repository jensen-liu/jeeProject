(function($) {
	$.fn.sidebarMenu = function(options) {
		options = $.extend({}, $.fn.sidebarMenu.defaults, options || {});
		var target = $(this);
		target.addClass('nav');
		target.addClass('nav-list');
		if (options.data) {
			init(target, options.data);
		} else {
			if (!options.url)
				return;
			$.getJSON(options.url, options.param, function(data) {
				init(target, data);
			});
		}
		var url = window.location.pathname;
		// menu = target.find("[href='" + url + "']");
		// menu.parent().addClass('active');
		// menu.parent().parentsUntil('.nav-list',
		// 'li').addClass('active').addClass('open');
		function init(target, data) {
			$.each(data, function(i, item) {
				var li = $('<li></li>');
				var a = $('<a></a>');
				var icon = $('<i></i>');
				// icon.addClass('glyphicon');
				icon.addClass(item.icon);
				var text = $('<span></span>');
				text.addClass('menu-text').text(item.text);
				a.append(icon);
				a.append(text);
				if (item.menus && item.menus.length > 0) {
					a.attr('href', '#');
					a.addClass('dropdown-toggle');
					var arrow = $('<b></b>');
					arrow.addClass('arrow').addClass('icon-angle-down');
					a.append(arrow);
					li.append(a);
					var menus = $('<ul></ul>');
					menus.addClass('submenu');
					init(menus, item.menus);
					li.append(menus);
				} else {
					var href = 'javascript:addTabs({id:\'' + item.id
							+ '\',title: \'' + item.text
							+ '\',close: true,url: \'' + item.url
							+ '\',icon:\'' + item.icon + '\'});';
					a.attr('href', href);
					// if (item.istab)
					// a.attr('href', href);
					// else {
					// a.attr('href', item.url);
					// a.attr('title', item.text);
					// a.attr('target', '_blank')
					// }
					li.append(a);
				}
				target.append(li);
			});
		}
	}

	$.fn.sidebarMenu.defaults = {
		url : null,
		param : null,
		data : null
	};
})(jQuery);

sidebar - menu.js
$(function() {
	$('#menu').sidebarMenu({
		data : [ {
			id : '1',
			text : '系统设置',
			icon : 'icon-cog',
			url : '',
			menus : [ {
				id : '11',
				text : '编码管理',
				icon : 'icon-pencil',
				url : '/index'
			} ]
		}, {
			id : '2',
			text : '基础数据',
			icon : 'icon-leaf',
			url : '',
			menus : [ {
				id : '21',
				text : '基础特征',
				icon : 'icon-glass',
				url : '/index'
			}, {
				id : '22',
				text : '特征管理',
				icon : 'icon-glass',
				url : '/index'
			}, {
				id : '23',
				text : '物料维护',
				icon : 'icon-glass',
				url : '/index'
			}, {
				id : '24',
				text : '站点管理',
				icon : 'icon-glass',
				url : '/index'
			} ]
		}, {
			id : '3',
			text : '权限管理',
			icon : 'icon-user',
			url : '',
			menus : [ {
				id : '31',
				text : '用户管理',
				icon : 'icon-user',
				url : '/index'
			}, {
				id : '32',
				text : '角色管理',
				icon : 'icon-apple',
				url : '/index'
			}, {
				id : '33',
				text : '菜单管理',
				icon : 'icon-list',
				url : '/index'
			}, {
				id : '34',
				text : '部门管理',
				icon : 'icon-glass',
				url : '/index'
			} ]
		}, {
			id : '4',
			text : '订单管理',
			icon : 'icon-envelope',
			url : '',
			menus : [ {
				id : '41',
				text : '订单查询',
				icon : 'icon-glass',
				url : '/index'
			}, {
				id : '42',
				text : '订单排产',
				icon : 'icon-glass',
				url : '/index'
			}, {
				id : '43',
				text : '订单撤排',
				icon : 'icon-glass',
				url : '/index'
			}, {
				id : '44',
				text : '订单HOLD',
				icon : 'icon-glass',
				url : '/index'
			}, {
				id : '45',
				text : '订单删除',
				icon : 'icon-glass',
				url : '/index'
			}, {
				id : '47',
				text : '订单插单',
				icon : 'icon-glass',
				url : '/index'
			}, {
				id : '48',
				text : '订单导入',
				icon : 'icon-glass',
				url : '/index'
			}, {
				id : '49',
				text : '订单插单',
				icon : 'icon-glass',
				url : '/index'
			}, {
				id : '50',
				text : '订单导入',
				icon : 'icon-glass',
				url : '/index'
			} ]
		} ]
	});
});
$(function () {
    //固定左边菜单的高度
    $('#sidebar').height($(window).height() - 80);
});