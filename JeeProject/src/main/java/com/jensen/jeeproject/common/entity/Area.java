package com.jensen.jeeproject.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableName;
import com.jensen.jeeproject.system.vo.TreeVO;

/**
 * 区域类
 * 
 * @author Jensen
 *
 */
@TableName(value = "t_area")
public class Area extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 区域名称
	 */
	private String name;
	/**
	 * 区域编码
	 */
	private String code;
	/**
	 * 上级ID
	 */
	private Area parent;
	/**
	 * 区域类型
	 */
	private Integer type;
	/**
	 * 区号
	 */
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
	private String phonics;
	/**
	 * 排序
	 */
	private Integer sort;

	public Area() {

	}

	public Area(String id) {
		this.id = id;
	}

	public TreeVO formatTreeData() {

		TreeVO vo = new TreeVO();
		vo.setId(id);
		vo.setText(name);
		if (null != parent) {
			vo.setParentId(parent.getId());
		}
		return vo;
	}

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

	public Area getParent() {
		return parent;
	}

	public void setParent(Area parent) {
		this.parent = parent;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
