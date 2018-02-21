package com.jensen.jeeproject.system.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.annotations.TableName;
import com.google.common.collect.Maps;
import com.jensen.jeeproject.common.entity.BaseEntity;
import com.jensen.jeeproject.common.enumeration.OfficeTypeEnum;

@TableName(value = "t_office")
public class Office extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Office parent; // 父级编号
	private String path; // 路径
	private String code; // 机构编码
	private String name; // 机构名称
	private Integer type; // 机构类型（1：公司；2：部门；3：小组）
	private Integer grade; // 机构等级
	private String address; // 联系地址
	private String master; // 负责人
	private String phone; // 电话
	private String fax; // 传真
	private String email; // 邮箱
	private Integer sort; // 排序
	private List<String> childDeptList;// 快速添加子部门

	public Office() {

	}

	public Office(String id) {
		this.id = id;
	}

	public Map<String, Object> toMap() {

		Map<String, Object> map = Maps.newHashMap();
		map.put("id", id);
		if (null == parent) {
			map.put("parentId", parent.getId());
			map.put("parentName", parent.getName());
		}
		map.put("path", parent.getPath());
		map.put("code", code);
		map.put("type", type);
		map.put("typeName", OfficeTypeEnum.getEnumName(type));
		map.put("grade", grade);
		map.put("address", address);
		map.put("master", master);
		map.put("phone", phone);
		map.put("fax", fax);
		map.put("email", email);
		map.put("sort", sort);
		return map;
	}

	public Office getParent() {
		return parent;
	}

	public void setParent(Office parent) {
		this.parent = parent;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public List<String> getChildDeptList() {
		return childDeptList;
	}

	public void setChildDeptList(List<String> childDeptList) {
		this.childDeptList = childDeptList;
	}

}
