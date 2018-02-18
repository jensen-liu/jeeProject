package com.jensen.jeeproject.system.service;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.baomidou.mybatisplus.plugins.Page;
import com.jensen.jeeproject.common.exception.ServiceException;
import com.jensen.jeeproject.system.entity.User;

public interface UserService {
	/**
	 * 根据用户ID查询用户
	 * 
	 * @param id
	 * @return
	 * @author Jensen
	 * @date 2018年2月4日
	 * @since 1.0
	 */
	User getUserById(String id);

	/**
	 * 根据登录帐号查询用户
	 * 
	 * @param loginName
	 * @return
	 * @author Jensen
	 * @date 2018年2月4日
	 * @since 1.0
	 */
	User getUserByLoginName(String loginName);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 * @author Jensen
	 * @date 2018年2月4日
	 * @since 1.0
	 */
	List<User> getList();

	/**
	 * 根据角色ID查询其下分配的用户
	 * 
	 * @param roleId
	 * @return
	 * @author Jensen
	 * @date 2018年2月4日
	 * @since 1.0
	 */
	List<User> getListByRoleId(String roleId);

	/**
	 * 分页、条件查询用户列表
	 * 
	 * @param page
	 * @param condition
	 * @author Jensen
	 * @date 2018年2月4日
	 * @since 1.0
	 */
	Page<User> getUserListByCondition(Page<User> page, Map<String, Object> condition);

	/**
	 * 保存添加用户
	 * 
	 * @param user
	 * @author Jensen
	 * @date 2018年2月4日
	 * @since 1.0
	 */
	@RequiresPermissions("account_settings:add")
	void insertUser(User user);

	/**
	 * 保存编辑用户
	 * 
	 * @param user
	 *            用户对象
	 * @author Jensen
	 * @date 2018年2月4日
	 * @since 1.0
	 */
	void updateUser(User user);

	/**
	 * 删除用户
	 * 
	 * @param user
	 * @author Jensen
	 * @date 2018年2月18日
	 * @since 1.0
	 */
	void deleteUser(User user);

	/**
	 * 切换禁用、启用状态
	 * 
	 * @param id
	 *            用户ID
	 * @author Jensen
	 * @date 2018年2月4日
	 * @since 1.0
	 */
	void updateState(String id);

	/**
	 * 修改密码
	 * 
	 * @param id
	 *            用户ID
	 * @param oldPassword
	 *            旧密码
	 * @param newPassword
	 *            新密码
	 * @author Jensen
	 * @date 2018年2月4日
	 * @since 1.0
	 */
	void updatePassword(String id, String oldPassword, String newPassword);

	/**
	 * 重置密码
	 * 
	 * @param id
	 *            用户ID
	 * @param newPwd
	 *            新密码
	 * @author Jensen
	 * @date 2018年2月4日
	 * @since 1.0
	 */
	void resetPassword(String id, String newPwd) throws ServiceException;
}
