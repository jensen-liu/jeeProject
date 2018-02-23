package com.jensen.jeeproject.system.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.jensen.jeeproject.common.exception.ServiceException;
import com.jensen.jeeproject.system.entity.Role;
import com.jensen.jeeproject.system.entity.User;

public interface RoleService {

	Role getRoleById(String id);

	List<Role> getList();

	Page<Role> getListByCondition(Page<Role> page, Map<String, Object> condition);

	int insert(Role role) throws ServiceException;

	int update(Role role) throws ServiceException;

	int delete(String id) throws ServiceException;

}
