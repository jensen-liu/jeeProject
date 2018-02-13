package com.jensen.jeeproject.system.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableName;
import com.jensen.jeeproject.common.entity.BaseEntity;

@TableName(value = "t_office")
public class Office extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Office parent; // 父级编号
	private String path; // 路径
	private String code; // 机构编码
	private String name; // 机构名称
	private String type; // 机构类型（1：公司；2：部门；3：小组）
	private String grade; // 机构等级（1：一级；2：二级；3：三级；4：四级）
	private String address; // 联系地址
	private String postCode; // 邮政编码
	private String master; // 负责人
	private String phone; // 电话
	private String fax; // 传真
	private String email; // 邮箱
	private String useable;// 是否可用
	private Integer sort; // 排序
	private List<String> childDeptList;// 快速添加子部门

}
