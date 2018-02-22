package com.jensen.jeeproject.system.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 组织机构添加表单值对象
 * 
 * @author Jensen
 * @date 上午10:30:20
 * @version V1.0
 */
public class OfficeUpdateVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 机构ID
	 */
	@NotBlank(message = "{office.id.NotBlank}")
	private String id;
	/**
	 * 机构名称
	 */
	@NotBlank(message = "{office.name.NotBlank}")
	private String name;
	/**
	 * 机构编码
	 */
	@NotBlank(message = "{office.code.NotBlank}")
	private String code;
	/**
	 * 父级编号
	 */
	private String parentId;
	/**
	 * 机构类型
	 */
	@NotBlank(message = "{office.type.NotBlank}")
	private String type;
	/**
	 * 联系地址
	 */
	private String address;
	/**
	 * 联系人
	 */
	private String master;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "OfficeUpdateVO [id=" + id + ", name=" + name + ", code=" + code + ", parentId=" + parentId + ", type="
				+ type + ", address=" + address + ", master=" + master + ", phone=" + phone + ", fax=" + fax
				+ ", email=" + email + ", sort=" + sort + "]";
	}

}
