package com.jensen.jeeproject.system.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class UserResetPasswordVO implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotBlank(message = "{user.id.NotBlank}")
	private String id;
	@NotBlank(message = "{user.password.NotBlank}")
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserResetPasswordVO [id=" + id + ", password=" + password + "]";
	}

}
