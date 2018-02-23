package com.jensen.jeeproject.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jensen.jeeproject.system.dao.PermissionDao;
import com.jensen.jeeproject.system.entity.Permission;
import com.jensen.jeeproject.system.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionDao permDao;

	@Override
	public Permission getPermById(String id) {

		return permDao.getPermById(id);
	}

	@Override
	public List<Permission> getList() {

		return permDao.getList();
	}

	@Override
	public List<Permission> getListByRole() {

		return permDao.getListByRole();
	}

	@Override
	public int insert(Permission perm) {

		return permDao.insert(perm);
	}

	@Override
	public int update(Permission perm) {

		return permDao.update(perm);
	}

	@Override
	public int delete(String id) {

		return permDao.delete(id);
	}

}
