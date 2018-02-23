package com.jensen.jeeproject.system.dao;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jensen.jeeproject.system.entity.Permission;

public interface PermissionDao extends BaseMapper<Permission, String> {

	Permission getPermById(String id);

	List<Permission> getList();

	List<Permission> getListByRole();

	int insert(Permission perm);

	int update(Permission perm);

	int delete(String id);

}
