package com.jensen.jeeproject.system.entity;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 角色-权限
 * 
 * @author Jensen
 * @date 上午11:30:56
 * @version V1.0
 */
@TableName("t_role_permission")
public class RolePermission {

	private Role role;

	private Permission permission;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

}
