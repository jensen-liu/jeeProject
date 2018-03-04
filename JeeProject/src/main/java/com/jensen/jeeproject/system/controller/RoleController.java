package com.jensen.jeeproject.system.controller;

import static com.jensen.jeeproject.common.util.PropUtil.getPropMessage;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jensen.jeeproject.common.cache.OfficeCache;
import com.jensen.jeeproject.common.controller.BaseController;
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
public class RoleController extends BaseController{

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
	@RequestMapping("selectAll")
	public String selectAll(HttpServletRequest request, @RequestParam(defaultValue = "1", name = "page") Integer page,
			@RequestParam(defaultValue = "20", name = "pageSize") Integer pageSize,
			@RequestParam(defaultValue = "sort", name = "sort") String sort,
			@RequestParam(defaultValue = "desc", name = "order") String orde) {

		List<Map<String, Object>> rows = Lists.newArrayList();
		Map<String, Object> condition = WebUtils.getParametersStartingWith(request, "search_");
		Page<Role> rolePage = new Page<Role>(page, pageSize);
		rolePage = roleService.getListByCondition(rolePage, condition);

		for (Role role : rolePage.getRecords()) {
			rows.add(role.toMap());
		}

		Map<String, Object> map = Maps.newHashMap();
		map.put("total", rolePage.getTotal());
		map.put("rows", rows);
		return JSONObject.toJSONString(map);
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
			LOGGER.error("删除角色异常：{}", id, e);
			return result.toFailString(getPropMessage("exception"));
		}
	}

	@RequestMapping("toHome")
	public String toHome() {

		return "role/role_home";
	}

	@RequestMapping("toAdd")
	public String toAdd() {

		return "role/role_add";
	}

	@RequestMapping("toEdit")
	public String toEdit() {

		return "role/role_edit";
	}

}
