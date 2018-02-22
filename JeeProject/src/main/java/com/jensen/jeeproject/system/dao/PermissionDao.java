package com.jensen.jeeproject.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jensen.jeeproject.system.entity.Permission;

public interface PermissionDao extends BaseMapper<Permission, String> {

	Permission getPermById(String id);

	int insert();

	int update();

	int delete();

}
