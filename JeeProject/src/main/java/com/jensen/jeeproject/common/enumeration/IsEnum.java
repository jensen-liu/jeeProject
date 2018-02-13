package com.jensen.jeeproject.common.enumeration;

/**
 * 是否枚举
 * 
 * @author Jensen
 *
 */
public enum IsEnum {
	/**
	 * 是
	 */
	YES(1),
	/**
	 * 否
	 */
	No(0);

	private Integer id;

	IsEnum(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}
