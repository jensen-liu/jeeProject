package com.jensen.jeeproject.common.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class AreaUpdateVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 区域ID
	 */
	@NotBlank(message = "{area.id.NotBlank}")
	private String id;
	/**
	 * 区域名称
	 */
	@NotBlank(message = "{area.name.NotBlank}")
	@Length(max = 50, message = "{area.name.Length}")
	private String name;
	/**
	 * 区域编码
	 */
	@NotBlank(message = "{area.code.NotBlank}")
	@Length(max = 10, message = "{area.code.Length}")
	private String code;
	/**
	 * 上级ID
	 */
	private String parentId;
	/**
	 * 区域类型
	 */
	@NotNull(message = "{area.type.NotNull}")
	private Integer type;
	/**
	 * 区号
	 */
	@NotBlank(message = "{area.cityCode.NotBlank}")
	@Length(max = 10, message = "{area.cityCode.Length}")
	private String cityCode;
	/**
	 * 邮编
	 */
	private String postCode;
	/**
	 * 全称
	 */
	private String mergerName;
	/**
	 * x坐标
	 */
	private String lng;
	/**
	 * y坐标
	 */
	private String lat;
	/**
	 * 拼音
	 */
	@Length(max = 100, message = "{area.phonics.Length}")
	private String phonics;
	/**
	 * 排序
	 */
	@NotBlank(message = "{area.sort.NotBlank}")
	@Length(max = 2147483647, message = "{area.sort.Length}")
	private Integer sort;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getMergerName() {
		return mergerName;
	}

	public void setMergerName(String mergerName) {
		this.mergerName = mergerName;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getPhonics() {
		return phonics;
	}

	public void setPhonics(String phonics) {
		this.phonics = phonics;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
