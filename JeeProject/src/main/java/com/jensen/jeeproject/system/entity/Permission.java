package com.jensen.jeeproject.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jensen.jeeproject.common.entity.BaseEntity;

@TableName("t_permission")
public class Permission extends BaseEntity implements Serializable {
	@TableField(exist = false)
	private static final long serialVersionUID = -8231326179680315136L;
	/**
	 * 父级ID
	 */
	private Permission parentId;
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

	public Permission getParentId() {
		return parentId;
	}

	public void setParentId(Permission parentId) {
		this.parentId = parentId;
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
