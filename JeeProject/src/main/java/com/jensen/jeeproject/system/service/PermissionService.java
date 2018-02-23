package com.jensen.jeeproject.system.service;

import java.util.List;

import com.jensen.jeeproject.common.exception.ServiceException;
import com.jensen.jeeproject.system.entity.Permission;

public interface PermissionService {

	Permission getPermById(String id);

	List<Permission> getList();

	List<Permission> getListByRole();

	int insert(Permission perm) throws ServiceException;

	int update(Permission perm) throws ServiceException;;

	int delete(String id) throws ServiceException;;

}
