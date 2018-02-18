package com.jensen.jeeproject.common.enumeration;

/**
 * 是否枚举
 * 
 * @author Jensen
 *
 */
public enum SwitchEnum {
	/**
	 * 是
	 */
	YES(1),
	/**
	 * 否
	 */
	NO(0);

	private Integer id;

	SwitchEnum(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}
