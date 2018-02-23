package com.jensen.jeeproject.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jensen.jeeproject.system.entity.UserRole;

public interface UserRoleDao extends BaseMapper<UserRole, String> {

	int deleteByRole(String roleId);

}
