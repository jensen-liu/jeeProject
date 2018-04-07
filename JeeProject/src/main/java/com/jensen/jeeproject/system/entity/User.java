package com.jensen.jeeproject.system.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jensen.jeeproject.common.entity.DataEntity;
import com.jensen.jeeproject.common.enumeration.SwitchEnum;
import com.jensen.jeeproject.system.vo.UserInsertVO;
import com.jensen.jeeproject.system.vo.UserUpdateVO;

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
	private Integer state;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
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

	// public void changeState() {
	// switch (state) {
	// case ENABLE:
	// this.state = UserStateEnum.DISABLE;
	// break;
	// case DISABLE:
	// this.state = UserStateEnum.ENABLE;
	// break;
	// default:
	// this.state = UserStateEnum.DISABLE;
	// break;
	// }
	// }

	public static User getInstance() {

		return new User();
	}

	public static User getInstance(UserInsertVO vo) {

		User user = new User();
		user.setId(UUID.randomUUID().toString().replace("-", ""));
		user.setLoginName(vo.getLoginName());
		user.setSalt(RandomStringUtils.randomNumeric(8));
		user.encrypt(vo.getPassword());
		user.setEmail(vo.getEmail());
		user.setMobile(vo.getMobile());
		user.setPhone(vo.getPhone());
		user.setCompany(new Office(vo.getCompanyId()));
		user.setOffice(new Office(vo.getOfficeId()));
		user.setName(vo.getName());
		user.setUserNo(vo.getUserNo());
		user.setDelFlag(SwitchEnum.NO.getId());
		user.setCreateDate(new Date());
		user.setState(vo.getState());
		return user;
	}

	public static User getInstance(UserUpdateVO vo) {

		User user = new User();
		user.setId(vo.getId());
		user.setEmail(vo.getEmail());
		user.setMobile(vo.getMobile());
		user.setPhone(vo.getPhone());
		user.setCompany(new Office(vo.getCompanyId()));
		user.setOffice(new Office(vo.getOfficeId()));
		user.setName(vo.getName());
		user.setUserNo(vo.getUserNo());
		user.setState(vo.getState());
		user.setUpdateDate(new Date());
		return user;
	}

	/**
	 * 将用户对象转换为可对外展示的Map集合
	 * 
	 * @return
	 * @author Jensen
	 * @date 2018年2月16日
	 * @since 1.0
	 */
	public Map<String, Object> toMap() {

		Map<String, Object> map = Maps.newHashMap();
		map.put("id", id);
		map.put("loginName", loginName);
		map.put("userNo", userNo);
		if (null != company) {
			map.put("companyId", company.getId());
			map.put("companyName", company.getName());
		}
		if (null != office) {
			map.put("officeId", office.getId());
			map.put("officeName", office.getName());
		}
		map.put("email", email);
		map.put("mobile", mobile);
		map.put("phone", phone);
		map.put("loginIp", loginIp);
		map.put("oldLoginIp", oldLoginIp);
		map.put("loginDate", loginDate);
		map.put("oldLoginDate", oldLoginDate);
		map.put("photo", photo);
		map.put("state", state);
		return map;
	}

	public void encrypt(String password){
		
		int hashIterations = 10;// 加密的次数
		this.password = new SimpleHash("MD5", password, this.salt, hashIterations).toString();
	}
	
}
