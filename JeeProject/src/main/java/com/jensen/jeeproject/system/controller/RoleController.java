package com.jensen.jeeproject.system.controller;

import static com.jensen.jeeproject.common.util.PropUtil.getPropMessage;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jensen.jeeproject.common.exception.ServiceException;
import com.jensen.jeeproject.common.util.ResponseResult;
import com.jensen.jeeproject.system.entity.Role;
import com.jensen.jeeproject.system.service.RoleService;
import com.jensen.jeeproject.system.vo.RoleInsertVO;
import com.jensen.jeeproject.system.vo.RoleUpdateVO;

/**
 * 用户角色Controller类
 * 
 * @author Jensen
 * @date 下午7:45:59
 * @version V1.0
 */
@Controller
@RequestMapping("role")
public class RoleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;

	@ResponseBody
	@RequestMapping("select")
	public String select(String id) {

		ResponseResult result = new ResponseResult();
		if (isBlank(id)) {
			return result.toFailString(getPropMessage("role.id.NotBlank"));
		} else {
			Role role = roleService.getRoleById(id);
			if (null == role) {
				return result.toFailString(getPropMessage("role.NotNull"));
			} else {
				result.setRespMap(role.toMap());
				return result.toStringForMap();
			}
		}
	}

	@ResponseBody
	@RequestMapping("insert")
	public String insert(@Valid RoleInsertVO vo, BindingResult rs) {

		ResponseResult result = new ResponseResult();
		if (rs.hasErrors()) {
			return result.toFailString(rs.getAllErrors().get(0).getDefaultMessage());
		} else {
			try {
				roleService.insert(Role.getInstance(vo));
				return result.toSuccessString();
			} catch (ServiceException e) {
				return result.toFailString(e.getMessage());
			} catch (Exception e) {
				LOGGER.error("角色添加异常：{}", vo, e);
				return result.toFailString(getPropMessage("exception"));
			}
		}
	}

	@ResponseBody
	@RequestMapping("update")
	public String update(@Valid RoleUpdateVO vo, BindingResult rs) {

		ResponseResult result = new ResponseResult();
		if (rs.hasErrors()) {
			return result.toFailString(rs.getAllErrors().get(0).getDefaultMessage());
		} else {
			try {
				roleService.update(Role.getInstance(vo));
				return result.toSuccessString();
			} catch (ServiceException e) {
				return result.toFailString(e.getMessage());
			} catch (Exception e) {
				LOGGER.error("角色修改异常：{}", vo, e);
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
				roleService.delete(id);
				return result.toSuccessString();
			} else {
				return result.toFailString(getPropMessage("role.id.NotBlank"));
			}
		} catch (Exception e) {
			return result.toFailString(getPropMessage("exception"));
		}
	}

}
