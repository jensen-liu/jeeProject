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
public class UserInsertVO implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotBlank(message = "{user.loginName.NotBlank}")
	private String loginName;
	@NotBlank(message = "{user.password.NotBlank}")
	private String password;

	private String userNo;
	@NotBlank(message = "{user.name.NotBlank}")
	private String name;

	private String companyId;

	private String officeId;
	@NotNull(message = "{user.state.NotNull}")
	private Integer state;

	private String mobile;

	private String phone;

	private String email;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	@Override
	public String toString() {
		return "UserInsertVO [loginName=" + loginName + ", password=" + password + ", userNo=" + userNo + ", name="
				+ name + ", companyId=" + companyId + ", officeId=" + officeId + ", state=" + state + ", mobile="
				+ mobile + ", phone=" + phone + ", email=" + email + "]";
	}

}
