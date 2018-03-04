package com.jensen.jeeproject.system.vo;

import java.io.Serializable;

public class RoleInsertVO implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 归属机构
	 */
	private String office;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 英文名称
	 */
	private String enName;
	/**
	 * 权限类型
	 */
	private Integer type;
	/**
	 * 数据范围
	 */
	private Integer dataScope;
	/**
	 * 分配权限
	 */
	private String permissions;
	/**
	 * 排序
	 */
	private Integer sort;

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getDataScope() {
		return dataScope;
	}

	public void setDataScope(Integer dataScope) {
		this.dataScope = dataScope;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "RoleInsertVO [office=" + office + ", name=" + name + ", enName=" + enName + ", type=" + type
				+ ", dataScope=" + dataScope + ", permissions=" + permissions + ", sort=" + sort + "]";
	}

}
