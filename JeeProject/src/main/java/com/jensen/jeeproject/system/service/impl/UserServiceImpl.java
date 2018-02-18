package com.jensen.jeeproject.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jensen.jeeproject.common.exception.ServiceException;
import com.jensen.jeeproject.common.util.PropUtil;
import com.jensen.jeeproject.system.dao.UserDao;
import com.jensen.jeeproject.system.entity.User;
import com.jensen.jeeproject.system.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserById(String id) {

		return userDao.getUserById(id);
	}

	@Override
	public User getUserByLoginName(String loginName) {

		return userDao.getUserByLoginName(loginName);
	}

	@Override
	public List<User> getList() {

		return null;
	}

	@Override
	public List<User> getListByRoleId(String roleId) {

		return null;
	}

	@Override
	public Page<User> getUserListByCondition(Page<User> page, Map<String, Object> condition) {

		List<User> userList = userDao.getUserListByCondition(page, condition);
		page.setSearchCount(true);
		page.setRecords(userList);
		
		return page;
	}

	@Override
	public void insertUser(User user) {

		userDao.insert(user);
	}

	@Override
	public void updateUser(User user) {

		userDao.update(user);
	}

	@Override
	public void deleteUser(User user) {
	
		user.setDeleteDate(new Date());
		userDao.delete(user);
	}
	
	@Override
	public void updateState(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePassword(String id, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetPassword(String id, String newPwd) throws ServiceException{
		
		User user = userDao.getUserById(id);
		if(null == user){
			throw new ServiceException(PropUtil.getPropMessage("user.NotNull"));
		}else{
			user.encrypt(newPwd);
			userDao.resetPassword(user);
		}
	}

}
