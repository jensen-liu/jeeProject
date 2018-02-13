package com.jensen.jeeproject.common.enumeration;

/**
 * 区域类型枚举
 * 
 * @author Jensen
 *
 */
public enum AreaTypeEnum {

	/**
	 * 国家
	 */
	COUNTRY(1, "国家"),
	/**
	 * 省份
	 */
	PROVINCE(2, "省份、直辖市"),
	/**
	 * 城市
	 */
	CITY(3, "城市"),
	/**
	 * 区县
	 */
	COUNTY(4, "区县");

	private Integer id;
	private String name;

	AreaTypeEnum(Integer id, String name) {
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
