package com.jensen.jeeproject.system.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.google.common.collect.Lists;
import com.jensen.jeeproject.common.entity.DataEntity;
import com.jensen.jeeproject.common.enumeration.UserStateEnum;

/**
 * 用户类
 * 
 * @className User
 * @description
 * @author JensenLiu
 * @date 2017年9月13日
 * @version V1.0
 */
@TableName("t_user")
public class User extends DataEntity implements Serializable {
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;
	/**
	 * 登录帐号
	 */
	private String loginName;
	/**
	 * 工号
	 */
	private String userNo;
	/**
	 * 登录密码（加密）
	 */
	private String password;
	/**
	 * 加密因子
	 */
	private String salt;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 归属公司
	 */
	private Office company;
	/**
	 * 归属部门
	 */
	private Office office;
	/**
	 * 用户状态 0=启用，1=禁用
	 */
	private UserStateEnum state;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 最后登陆IP
	 */
	private String loginIp;
	/**
	 * 最后登陆日期
	 */
	private Date loginDate;
	/**
	 * 是否允许登陆
	 */
	private String loginFlag;
	/**
	 * 头像
	 */
	private String photo;
	/**
	 * 上次登陆IP
	 */
	private String oldLoginIp;
	/**
	 * 上次登陆日期
	 */
	private Date oldLoginDate;
	/**
	 * 拥有角色列表
	 */
	private List<Role> roleList;

	public User() {
		roleList = Lists.newArrayList();
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Office getCompany() {
		return company;
	}

	public void setCompany(Office company) {
		this.company = company;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public UserStateEnum getState() {
		return state;
	}

	public void setState(UserStateEnum state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getOldLoginIp() {
		return oldLoginIp;
	}

	public void setOldLoginIp(String oldLoginIp) {
		this.oldLoginIp = oldLoginIp;
	}

	public Date getOldLoginDate() {
		return oldLoginDate;
	}

	public void setOldLoginDate(Date oldLoginDate) {
		this.oldLoginDate = oldLoginDate;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public void changeState() {
		switch (state) {
		case ENABLE:
			this.state = UserStateEnum.DISABLE;
			break;
		case DISABLE:
			this.state = UserStateEnum.ENABLE;
			break;
		default:
			this.state = UserStateEnum.DISABLE;
			break;
		}
	}

}
