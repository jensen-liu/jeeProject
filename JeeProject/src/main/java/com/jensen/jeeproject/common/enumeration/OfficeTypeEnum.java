package com.jensen.jeeproject.common.enumeration;

/**
 * 组织机构类型枚举
 * 
 * @author Jensen
 * @date 下午3:42:28
 * @version V1.0
 */
public enum OfficeTypeEnum {
	/**
	 * 公司
	 */
	COMPANY(0, "公司"),
	/**
	 * 部门
	 */
	DEPT(1, "部门"),
	/**
	 * 小组
	 */
	GROUP(2, "小组");

	private Integer id;

	private String name;

	private OfficeTypeEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static String getEnumName(Integer id) {

		for (OfficeTypeEnum e : OfficeTypeEnum.values()) {
			if (e.getId().equals(id)) {
				return e.getName();
			}
		}
		return "";
	}

}
