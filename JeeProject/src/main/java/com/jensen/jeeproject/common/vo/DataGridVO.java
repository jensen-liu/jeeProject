package com.jensen.jeeproject.common.vo;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * 数据列表值对象（EasyUI框架Datagrid控件所需数据格式）
 * 
 * @author Jensen
 * @date 下午9:16:53
 * @version V1.0
 * @param <T>
 */
public class DataGridVO<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 总记录数
	 */
	private Integer total;
	/**
	 * 数据集合
	 */
	private List<T> rows;

	public DataGridVO() {

	}

	public DataGridVO(Integer total, List<T> rows) {
		this.total = total;
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "DataGridVO [total=" + total + ", rows=" + rows + "]";
	}

	public String toJson() {
		return JSONObject.toJSONString(this);
	}

}
