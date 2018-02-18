package com.jensen.jeeproject.system.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jensen.jeeproject.common.entity.DataEntity;

@TableName("t_role")
public class Role extends DataEntity implements Serializable {
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;
	/**
	 * 归属机构
	 */
	private Office office;
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
	/**
	 * 是否可用 1=是，0=否
	 */
	private Integer useable;
	/**
	 * 分配资源
	 */
	private List<Permission> PermissionList;

	public Role() {
		PermissionList = new ArrayList<Permission>();
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
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

	public Integer getUseable() {
		return useable;
	}

	public void setUseable(Integer useable) {
		this.useable = useable;
	}

	public List<Permission> getPermissionList() {
		return PermissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		PermissionList = permissionList;
	}

}
