package com.jensen.jeeproject.system.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 添加新用户参数值对象
 * 
 * @author Jensen
 * @date 下午6:28:22
 * @version V1.0
 */
public class UserUpdateVO implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 主键ID
	 */
	@NotBlank(message = "{user.id.NotBlank}")
	private String id;
	/**
	 * 员工工号
	 */
	private String userNo;
	/**
	 * 姓名
	 */
	@NotBlank(message = "{user.name.NotBlank}")
	private String name;
	/**
	 * 所属公司
	 */
	private String companyId;
	/**
	 * 所属部门
	 */
	private String officeId;
	/**
	 * 用户状态
	 */
	@NotNull(message = "{user.state.NotNull}")
	private Integer state;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 固话号码
	 */
	private String phone;
	/**
	 * 电子邮箱
	 */
	private String email;

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserUpdateVO [id=" + id + ", userNo=" + userNo + ", name=" + name + ", companyId=" + companyId
				+ ", officeId=" + officeId + ", state=" + state + ", mobile=" + mobile + ", phone=" + phone + ", email="
				+ email + "]";
	}

}
