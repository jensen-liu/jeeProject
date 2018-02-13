package com.jensen.jeeproject.system.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableName;
import com.google.common.collect.Lists;
import com.jensen.jeeproject.common.entity.BaseEntity;
import com.jensen.jeeproject.common.enumeration.IsEnum;
import com.jensen.jeeproject.common.enumeration.RoleDataScopeEnum;

/**
 * 角色类
 * 
 * @author Jensen
 *
 */
@TableName(value = "t_role")
public class Role extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 英文名称
	 */
	private String enName;
	/**
	 * 所属机构
	 */
	private Office office;
	/**
	 * 角色类型
	 */
	private String roleType;
	/**
	 * 是否系统数据
	 */
	private IsEnum isSys;
	/**
	 * 是否启用
	 */
	private IsEnum useAble;
	/**
	 * 数据范围
	 */
	private RoleDataScopeEnum dataScope;
	/**
	 * 按明细设置数据范围
	 */
	private List<Menu> menuList;

	private List<Office> officeList = Lists.newArrayList();

	public Role() {
		menuList = Lists.newArrayList();
		officeList = Lists.newArrayList();
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

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public IsEnum getIsSys() {
		return isSys;
	}

	public void setIsSys(IsEnum isSys) {
		this.isSys = isSys;
	}

	public IsEnum getUseAble() {
		return useAble;
	}

	public void setUseAble(IsEnum useAble) {
		this.useAble = useAble;
	}

	public RoleDataScopeEnum getDataScope() {
		return dataScope;
	}

	public void setDataScope(RoleDataScopeEnum dataScope) {
		this.dataScope = dataScope;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public List<Office> getOfficeList() {
		return officeList;
	}

	public void setOfficeList(List<Office> officeList) {
		this.officeList = officeList;
	}

}
