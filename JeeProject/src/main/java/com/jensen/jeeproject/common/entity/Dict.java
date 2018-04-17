package com.jensen.jeeproject.common.entity;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 数据字典
 * 
 * @author Jensen
 * @date 下午10:55:30
 * @version V1.0
 */
@TableName(value = "t_dict")
public class Dict extends DataEntity {
	/**
	 * 数据字典值
	 */
	private String value;
	/**
	 * 数据字典标签
	 */
	private String label;
	/**
	 * 数据字典类型
	 */
	private String type;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 上级
	 */
	private Dict parent;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Dict getParent() {
		return parent;
	}

	public void setParent(Dict parent) {
		this.parent = parent;
	}

}
