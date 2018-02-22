package com.jensen.jeeproject.system.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jensen.jeeproject.system.entity.Role;

public interface RoleDao extends BaseMapper<Role, String> {

	Role getRoleById(String id);

	List<Role> getList();

	List<Role> getListByCondition(Page<Role> page, Map<String, Object> condition);

	int insert(Role role);

	int update(Role role);

	int delete(String id);

}
