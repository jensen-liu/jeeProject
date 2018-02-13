package com.jensen.jeeproject.login.vo;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 登录请求参数
 * 
 * @className LoginVO
 * @description
 * @author JensenLiu
 * @date 2018年2月2日
 * @version V1.0
 */
public class LoginVO {
	/**
	 * 登录帐号
	 */
	@NotBlank(message = "{login.loginName.NotBlank}")
	private String loginName;
	/**
	 * 登录密码
	 */
	@NotBlank(message = "{login.password.NotBlank}")
	private String password;
	/**
	 * 验证码
	 */
	@NotBlank(message = "{login.verifyCode.NotBlank}")
	private String verifyCode;
	/**
	 * 记住我
	 */
	private String rememberMe;

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

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

}
