package com.jensen.jeeproject.common.enumeration;

/**
 * 用户状态枚举
 * 
 * @author Jensen
 * @date 下午8:47:07
 * @version V1.0
 */
public enum UserStateEnum {
	/**
	 * 启用
	 */
	ENABLE(0, "启用"),
	/**
	 * 禁用
	 */
	DISABLE(1, "禁用");

	private Integer id;
	private String name;

	UserStateEnum(Integer id, String name) {
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
