package com.jensen.jeeproject.system.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jensen.jeeproject.common.entity.DataEntity;
import com.jensen.jeeproject.common.enumeration.RoleDataScopeEnum;
import com.jensen.jeeproject.common.enumeration.RoleTypeEnum;
import com.jensen.jeeproject.common.enumeration.SwitchEnum;
import com.jensen.jeeproject.common.util.IdUtil;
import com.jensen.jeeproject.system.vo.RoleInsertVO;
import com.jensen.jeeproject.system.vo.RoleUpdateVO;

@TableName("t_role")
public class Role extends DataEntity implements Serializable {
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;
	/**
	 * 归属机构
	 */
	private Office office;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 英文名称
	 */
	private String enName;
	/**
	 * 角色类型
	 */
	private Integer type;
	/**
	 * 是否系统数据 1=是，0=否
	 */
	private Integer sysData;
	/**
	 * 数据范围
	 */
	private Integer dataScope;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 分配资源
	 */
	private List<Permission> PermissionList;

	public Role() {
		PermissionList = new ArrayList<Permission>();
	}

	public static Role getInstance(RoleInsertVO vo) {

		Role role = new Role();
		role.setId(IdUtil.getId());
		role.setName(vo.getName());
		role.setCreateDate(new Date());
		role.setDataScope(vo.getDataScope());
		role.setDelFlag(SwitchEnum.NO.getId());
		role.setEnName(vo.getEnName());
		role.setOffice(Office.getInstance(vo.getOffice()));
		role.setType(vo.getType());
		role.setSort(vo.getSort());
		List<Permission> permissions = Lists.newArrayList();
		for (String id : vo.getPermissions().split(",")) {
			permissions.add(Permission.getInstance(id));
		}
		role.setPermissionList(permissions);
		role.setSysData(SwitchEnum.NO.getId());
		return role;
	}

	public static Role getInstance(RoleUpdateVO vo) {

		Role role = new Role();
		role.setId(vo.getId());
		role.setName(vo.getName());
		role.setEnName(vo.getEnName());
		role.setUpdateDate(new Date());
		role.setDataScope(vo.getDataScope());
		role.setOffice(Office.getInstance(vo.getOffice()));
		role.setType(vo.getType());
		List<Permission> permissions = Lists.newArrayList();
		for (String id : vo.getPermissions().split(",")) {
			permissions.add(Permission.getInstance(id));
		}
		role.setPermissionList(permissions);
		role.setSort(vo.getSort());
		return role;
	}

	public Map<String, Object> toMap() {

		Map<String, Object> map = Maps.newHashMap();
		map.put("id", id);
		map.put("name", name);
		if (null != office) {
			map.put("office", office.getId());
			map.put("officeName", office.getName());
		}
		map.put("enName", enName);
		map.put("type", type);
		map.put("typeText", RoleTypeEnum.getEnumName(type));
		map.put("sysData", sysData);
		map.put("sysDataText", SwitchEnum.getEnumText(sysData));
		map.put("dataScope", dataScope);
		map.put("dataScopeText", RoleDataScopeEnum.getEnumText(dataScope));
		map.put("sort", sort);
		return map;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getDataScope() {
		return dataScope;
	}

	public void setDataScope(Integer dataScope) {
		this.dataScope = dataScope;
	}

	public List<Permission> getPermissionList() {
		return PermissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		PermissionList = permissionList;
	}

	public Integer getSysData() {
		return sysData;
	}

	public void setSysData(Integer sysData) {
		this.sysData = sysData;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
