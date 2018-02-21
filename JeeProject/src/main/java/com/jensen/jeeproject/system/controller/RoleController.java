package com.jensen.jeeproject.system.controller;

import static com.jensen.jeeproject.common.util.PropUtil.getPropMessage;
import static org.apache.commons.lang3.StringUtils.isBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jensen.jeeproject.common.util.ResponseResult;
import com.jensen.jeeproject.system.entity.Role;
import com.jensen.jeeproject.system.service.RoleService;

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

}
