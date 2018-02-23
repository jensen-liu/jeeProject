package com.jensen.jeeproject.system.vo;

import java.io.Serializable;

import com.jensen.jeeproject.system.entity.Permission;

public class PermissionUpdateVO implements Serializable {

	private String id;
	/**
	 * 父级ID
	 */
	private String parentId;
	/**
	 * 名称
	 */
	private String name;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "PermissionUpdateVO [id=" + id + ", parentId=" + parentId + ", name=" + name + ", href=" + href
				+ ", target=" + target + ", icon=" + icon + ", sort=" + sort + ", showAble=" + showAble
				+ ", permission=" + permission + "]";
	}

}
