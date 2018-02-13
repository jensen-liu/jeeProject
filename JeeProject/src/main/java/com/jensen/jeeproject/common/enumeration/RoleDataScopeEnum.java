package com.jensen.jeeproject.common.enumeration;

/**
 * 角色数据范围枚举
 * 
 * @author Jensen
 *
 */
public enum RoleDataScopeEnum {
	/**
	 * 所有数据
	 */
	DATA_SCOPE_ALL(1, ""),
	/**
	 * 所在公司及以下数据
	 */
	DATA_SCOPE_COMPANY_AND_CHILD(2, ""),
	/**
	 * 所在公司数据
	 */
	DATA_SCOPE_COMPANY(3, ""),
	/**
	 * 所在部门及以下数据
	 */
	DATA_SCOPE_OFFICE_AND_CHILD(4, ""),
	/**
	 * 所在部门数据
	 */
	DATA_SCOPE_OFFICE(5, ""),
	/**
	 * 仅本人数据
	 */
	DATA_SCOPE_SELF(6, ""),
	/**
	 * 按明细设置
	 */
	DATA_SCOPE_CUSTOM(7, "");

	private Integer id;
	private String name;

	RoleDataScopeEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
