package com.jensen.jeeproject.common.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.jensen.jeeproject.system.entity.User;

/**
 * 数据实体类
 * 
 * @className DataEntity
 * @description
 * @author JensenLiu
 * @date 2018年2月2日
 * @version V1.0
 */
public abstract class DataEntity extends BaseEntity {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;
	/**
	 * 创建者
	 */
	protected User createBy;
	/**
	 * 创建日期
	 */
	protected Date createDate;
	/**
	 * 更新者
	 */
	protected User updateBy;
	/**
	 * 删除者
	 */
	protected User deleteBy;
	/**
	 * 更新日期
	 */
	protected Date updateDate;
	/**
	 * 删除日期
	 */
	protected Date deleteDate;
	/**
	 * 删除标记（0：正常；1：删除；2：审核）
	 */
	protected Integer delFlag;

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}

	public User getDeleteBy() {
		return deleteBy;
	}

	public void setDeleteBy(User deleteBy) {
		this.deleteBy = deleteBy;
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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

}
