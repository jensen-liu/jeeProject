package com.jensen.jeeproject.system.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.annotations.TableName;
import com.google.common.collect.Maps;
import com.jensen.jeeproject.common.entity.DataEntity;
import com.jensen.jeeproject.common.enumeration.OfficeTypeEnum;
import com.jensen.jeeproject.system.vo.TreeVO;

@TableName(value = "t_office")
public class Office extends DataEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 父级编号
	 */
	private Office parent;
	/**
	 * 路径
	 */
	private String path;
	/**
	 * 机构编码
	 */
	private String code;
	/**
	 * 机构名称
	 */
	private String name;
	/**
	 * 机构类型（1：公司；2：部门；3：小组）
	 */
	private Integer type;
	/**
	 * 联系地址
	 */
	private String address;
	/**
	 * 联系人
	 */
	private String contact;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 传真
	 */
	private String fax;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 快速添加子部门
	 */
	private List<String> childDeptList;

	public Office() {

	}

	public Office(String id) {
		this.id = id;
	}

	public Map<String, Object> toMap() {

		Map<String, Object> map = Maps.newHashMap();
		map.put("id", id);
		if (null != parent) {
			map.put("parentId", parent.getId());
			map.put("parentName", parent.getName());
		}
		map.put("path", path);
		map.put("code", code);
		map.put("type", type);
		map.put("typeName", OfficeTypeEnum.getEnumName(type));
		map.put("address", address);
		map.put("contact", contact);
		map.put("phone", phone);
		map.put("fax", fax);
		map.put("email", email);
		map.put("sort", sort);
		return map;
	}

	public static Office getInstance() {

		return new Office();
	}

	public static Office getInstance(String id) {

		Office office = getInstance();
		office.setId(id);
		return office;
	}

	public TreeVO formatTreeData() {

		TreeVO vo = new TreeVO();
		vo.setId(id);
		vo.setText(name);
		if(null != parent){
			vo.setParentId(parent.getId());	
		}
		return vo;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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
