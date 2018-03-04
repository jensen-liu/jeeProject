package com.jensen.jeeproject.common.enumeration;

/**
 * 角色类型枚举
 * 
 * @author Jensen
 * @date 下午2:06:19
 * @version V1.0
 */
public enum RoleTypeEnum {
	/**
	 * 任务分配角色
	 */
	ASSIGNMENT(0, "任务分配角色"),
	/**
	 * 管理角色
	 */
	SECURITY(1, "管理角色"),
	/**
	 * 普通角色
	 */
	NORMAL(2, "普通角色");

	private Integer id;

	private String text;

	private RoleTypeEnum(Integer id, String text) {

		this.id = id;
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public static String getEnumName(Integer id) {

		for (RoleTypeEnum e : RoleTypeEnum.values()) {
			if (e.getId().equals(id)) {
				return e.getText();
			}
		}
		return "";
	}
}
