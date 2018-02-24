package com.jensen.jeeproject.system.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 树结构数据值对象
 * 
 * @author Jensen
 * @date 下午4:33:11
 * @version V1.0
 */
public class TreeVO implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 节点ID
	 */
	private String id;
	/**
	 * 节点文本
	 */
	private String text;
	/**
	 * 节点状态，'open' 或 'closed'，默认：'open'<br/>
	 * 如果为'closed'的时候，将不自动展开该节点
	 */
	private String state;
	/**
	 * 表示该节点是否被选中。 true = 已选中，false = 未选中
	 */
	private String checked;
	/**
	 * 被添加到节点的自定义属
	 */
	private Map<String, Object> attributes;
	/**
	 * 父节点ID
	 */
	private String parentId;
	/**
	 * 一个节点数组声明了若干节点
	 */
	private List<TreeVO> children;

	public TreeVO() {
		state = "open";
		checked = "false";
		attributes = Maps.newHashMap();
		children = Lists.newArrayList();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public List<TreeVO> getChildren() {
		return children;
	}

	public void setChildren(List<TreeVO> children) {
		this.children = children;
	}

}
