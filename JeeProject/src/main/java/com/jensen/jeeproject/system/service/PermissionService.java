package com.jensen.jeeproject.system.service;

import java.util.List;

import com.jensen.jeeproject.system.entity.Permission;

public interface PermissionService {

	Permission getPermById(String id);

	List<Permission> getList();

	List<Permission> getListByRole();

	int insert(Permission perm);

	int update(Permission perm);

	int delete(Permission perm);

}
