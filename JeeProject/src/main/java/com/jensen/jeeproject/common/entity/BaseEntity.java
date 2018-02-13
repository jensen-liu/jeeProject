package com.jensen.jeeproject.common.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.jensen.jeeproject.system.entity.User;

/**
 * 基础实体类
 * 
 * @author Jensen
 *
 */
public abstract class BaseEntity {
	/**
	 * 主键标识
	 */
	@TableId(type = IdType.UUID)
	private String id;
	/**
	 * 创建人
	 */
	private User createBy;
	/**
	 * 编辑人
	 */
	private User updateBy;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 编辑时间
	 */
	private Date updateDate;
	/**
	 * 删除时间
	 */
	private Date deleteDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	public User getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

}
