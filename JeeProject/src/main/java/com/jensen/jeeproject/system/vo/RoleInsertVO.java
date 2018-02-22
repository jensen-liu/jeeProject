package com.jensen.jeeproject.system.vo;

import java.io.Serializable;

public class RoleInsertVO implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 归属机构
	 */
	private String officeId;
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
	private String roleType;
	/**
	 * 数据范围
	 */
	private Integer dataScope;

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
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

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public Integer getDataScope() {
		return dataScope;
	}

	public void setDataScope(Integer dataScope) {
		this.dataScope = dataScope;
	}

	@Override
	public String toString() {
		return "RoleInsertVO [officeId=" + officeId + ", name=" + name + ", enName=" + enName + ", roleType=" + roleType
				+ ", dataScope=" + dataScope + "]";
	}

}
