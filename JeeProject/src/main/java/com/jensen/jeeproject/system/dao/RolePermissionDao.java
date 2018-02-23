package com.jensen.jeeproject.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jensen.jeeproject.system.entity.RolePermission;

public interface RolePermissionDao extends BaseMapper<RolePermission, String> {

	int deleteByRole(String roleId);

}
