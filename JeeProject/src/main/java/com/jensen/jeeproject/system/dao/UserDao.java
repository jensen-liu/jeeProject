package com.jensen.jeeproject.system.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jensen.jeeproject.system.entity.User;

public interface UserDao extends BaseMapper<User, String> {

	User getUserById(String id);

	User getUserByLoginName(String loginName);

	List<User> getUserList();

	List<User> getUserListByCondition(Page<User> page, Map<String, Object> condition);

	int insert(User user);

	void update(User user);

	int delete(User user);

	int resetPassword(User user);
}
