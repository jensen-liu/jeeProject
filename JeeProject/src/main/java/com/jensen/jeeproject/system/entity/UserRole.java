package com.jensen.jeeproject.system.entity;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 用户-角色
 * 
 * @author Jensen
 * @date 上午11:31:06
 * @version V1.0
 */
@TableName("t_user_role")
public class UserRole {

	private User user;

	private Role role;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
