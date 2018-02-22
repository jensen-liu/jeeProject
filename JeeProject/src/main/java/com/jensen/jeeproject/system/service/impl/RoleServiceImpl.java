package com.jensen.jeeproject.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jensen.jeeproject.system.dao.RoleDao;
import com.jensen.jeeproject.system.entity.Role;
import com.jensen.jeeproject.system.entity.User;
import com.jensen.jeeproject.system.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public Role getRoleById(String id) {

		return roleDao.getRoleById(id);
	}

	@Override
	public List<Role> getList() {

		return roleDao.getList();
	}

	@Override
	public Page<Role> getListByCondition(Page<Role> page, Map<String, Object> condition) {

		List<Role> list = roleDao.getListByCondition(page, condition);
		page.setSearchCount(true);
		page.setRecords(list);

		return page;
	}

	@Override
	public int insert(Role role) {

		return roleDao.insert(role);
	}

	@Override
	public int update(Role role) {

		return roleDao.update(role);
	}

	@Override
	public int delete(String id) {

		return roleDao.delete(id);
	}
}
