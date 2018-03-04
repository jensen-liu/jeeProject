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
	YES(1, "是"),
	/**
	 * 否
	 */
	NO(0, "否");

	private Integer id;
	private String text;

	SwitchEnum(Integer id, String text) {
		this.id = id;
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public static String getEnumText(Integer id) {

		for (SwitchEnum e : values()) {
			if (e.getId().equals(id)) {
				return e.getText();
			}
		}
		return "";
	}

}
