package com.jensen.jeeproject.common.entity;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableId;

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
	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
