package com.jensen.jeeproject.common.enumeration;

public enum DelFlagEnum {

	YES(0), NO(1);

	private Integer id;

	DelFlagEnum(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
