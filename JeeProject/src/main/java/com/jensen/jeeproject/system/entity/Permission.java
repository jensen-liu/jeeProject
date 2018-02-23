package com.jensen.jeeproject.system.entity;

import java.io.Serializable;
import java.util.Map;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.google.common.collect.Maps;
import com.jensen.jeeproject.common.entity.BaseEntity;
import com.jensen.jeeproject.common.util.IdUtil;
import com.jensen.jeeproject.system.vo.PermissionInsertVO;
import com.jensen.jeeproject.system.vo.PermissionUpdateVO;

@TableName("t_permission")
public class Permission extends BaseEntity implements Serializable {
	@TableField(exist = false)
	private static final long serialVersionUID = -8231326179680315136L;
	/**
	 * 父级ID
	 */
	private Permission parent;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 路径
	 */
	private String path;
	/**
	 * 链接
	 */
	private String href;
	/**
	 * 目标 （详见PermTargetEnum类）
	 */
	private String target;
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 是否显示（1：显示；0：不显示）
	 */
	private Integer showAble;
	/**
	 * 权限标识
	 */
	private String permission;

	public Permission() {

	}

	public static Permission getInstance() {

		return new Permission();
	}

	public static Permission getInstance(String id) {

		Permission permission = getInstance();
		permission.setId(id);
		return permission;
	}

	public static Permission getInstance(PermissionInsertVO vo) {

		Permission permission = getInstance();
		permission.setId(IdUtil.getId());
		permission.setName(vo.getName());
		permission.setParent(Permission.getInstance(vo.getParentId()));
		permission.setIcon(vo.getIcon());
		permission.setPermission(vo.getPermission());
		permission.setTarget(vo.getTarget());
		permission.setSort(vo.getSort());
		permission.setShowAble(vo.getShowAble());

		return permission;
	}

	public static Permission getInstance(PermissionUpdateVO vo) {

		Permission permission = getInstance();
		permission.setId(vo.getId());
		permission.setName(vo.getName());
		permission.setParent(Permission.getInstance(vo.getParentId()));
		permission.setIcon(vo.getIcon());
		permission.setPermission(vo.getPermission());
		permission.setTarget(vo.getTarget());
		permission.setSort(vo.getSort());
		permission.setShowAble(vo.getShowAble());

		return permission;
	}

	public Map<String, Object> toMap() {

		Map<String, Object> map = Maps.newHashMap();
		map.put("id", id);
		map.put("name", name);
		map.put("parentId", parent.getId());
		map.put("path", path);
		map.put("href", href);
		map.put("target", target);
		map.put("icon", icon);
		map.put("permission", permission);
		map.put("showAble", showAble);
		map.put("sort", sort);

		return map;
	}

	public Permission getParent() {
		return parent;
	}

	public void setParent(Permission parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getShowAble() {
		return showAble;
	}

	public void setShowAble(Integer showAble) {
		this.showAble = showAble;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
