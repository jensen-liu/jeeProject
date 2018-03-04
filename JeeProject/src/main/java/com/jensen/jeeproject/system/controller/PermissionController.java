package com.jensen.jeeproject.system.controller;

import static com.jensen.jeeproject.common.util.PropUtil.*;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.jensen.jeeproject.common.exception.ServiceException;
import com.jensen.jeeproject.common.util.ResponseResult;
import com.jensen.jeeproject.system.entity.Office;
import com.jensen.jeeproject.system.entity.Permission;
import com.jensen.jeeproject.system.service.PermissionService;
import com.jensen.jeeproject.system.vo.PermissionInsertVO;
import com.jensen.jeeproject.system.vo.PermissionUpdateVO;
import com.jensen.jeeproject.system.vo.TreeVO;

/**
 * 资源权限Controller类
 * 
 * @author Jensen
 * @date 下午7:45:36
 * @version V1.0
 */
@Controller
@RequestMapping("permission")
public class PermissionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);
	@Autowired
	private PermissionService permService;

	@ResponseBody
	@RequestMapping("select")
	public String select(String id) {

		ResponseResult result = new ResponseResult();
		if (isBlank(id)) {
			return result.toFailString(getPropMessage("permission.id.NotBlank"));
		} else {
			Permission permission = permService.getPermById(id);
			if (null == permission) {
				return result.toFailString(getPropMessage("permission.NotNull"));
			} else {
				result.setRespMap(permission.toMap());
				return result.toStringForMap();
			}
		}
	}

	@ResponseBody
	@RequestMapping("treeDate")
	public String treeDate() {

		List<TreeVO> voList = Lists.newArrayList();
		List<Permission> permissions = permService.getList();

		for (Permission permission : permissions) {
			voList.add(permission.formatTreeData());
		}

		for (TreeVO vo : voList) {
			for (TreeVO vo2 : voList) {
				if (vo.getId().equals(vo2.getParentId())) {
					vo.getChildren().add(vo2);
				}
			}
		}

		Iterator<TreeVO> iterator = voList.iterator();
		while (iterator.hasNext()) {
			TreeVO vo = iterator.next();
			if (isNotBlank(vo.getParentId())) {
				iterator.remove();
			}
		}
		return JSONArray.toJSONString(voList);
	}

	@ResponseBody
	@RequestMapping("insert")
	public String insert(@Valid PermissionInsertVO vo, BindingResult rs) {

		ResponseResult result = new ResponseResult();
		if (rs.hasErrors()) {
			return result.toFailString(rs.getAllErrors().get(0).getDefaultMessage());
		} else {
			try {
				permService.insert(Permission.getInstance(vo));
				return result.toSuccessString();
			} catch (ServiceException e) {
				return result.toFailString(e.getMessage());
			} catch (Exception e) {
				LOGGER.error("权限添加异常：{}", vo, e);
				return result.toFailString(getPropMessage("exception"));
			}
		}
	}

	@ResponseBody
	@RequestMapping("update")
	public String update(@Valid PermissionUpdateVO vo, BindingResult rs) {

		ResponseResult result = new ResponseResult();
		if (rs.hasErrors()) {
			return result.toFailString(rs.getAllErrors().get(0).getDefaultMessage());
		} else {
			try {
				permService.update(Permission.getInstance(vo));
				return result.toSuccessString();
			} catch (ServiceException e) {
				return result.toFailString(e.getMessage());
			} catch (Exception e) {
				LOGGER.error("权限修改异常：{}", vo, e);
				return result.toFailString(getPropMessage("exception"));
			}
		}
	}

	@ResponseBody
	@RequestMapping("delete")
	public String delete(String id) {

		ResponseResult result = new ResponseResult();
		try {
			if (isNotBlank(id)) {
				permService.delete(id);
				return result.toSuccessString();
			} else {
				return result.toFailString(getPropMessage("permission.id.NotBlank"));
			}
		} catch (Exception e) {
			return result.toFailString(getPropMessage("exception"));
		}
	}

}
