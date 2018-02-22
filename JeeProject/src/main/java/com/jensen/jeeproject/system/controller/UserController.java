package com.jensen.jeeproject.system.controller;

import static org.apache.commons.lang3.StringUtils.isBlank;

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

import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jensen.jeeproject.common.controller.BaseController;
import com.jensen.jeeproject.common.exception.ServiceException;
import static com.jensen.jeeproject.common.util.PropUtil.*;
import com.jensen.jeeproject.common.util.ResponseResult;
import com.jensen.jeeproject.system.entity.User;
import com.jensen.jeeproject.system.service.UserService;
import com.jensen.jeeproject.system.vo.UserInsertVO;
import com.jensen.jeeproject.system.vo.UserResetPasswordVO;
import com.jensen.jeeproject.system.vo.UserUpdateVO;

/**
 * 用户Controller类
 * 
 * @author Jensen
 * @date 下午7:46:13
 * @version V1.0
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * 列表查询
	 * 
	 * @param request
	 * @param page
	 * @param pageSize
	 * @param sort
	 * @param orde
	 * @return
	 * @author Jensen
	 * @date 2018年2月18日
	 * @since 1.0
	 */
	@ResponseBody
	@RequestMapping("selectAll")
	public String selectAll(HttpServletRequest request, @RequestParam(defaultValue = "1", name = "page") Integer page,
			@RequestParam(defaultValue = "20", name = "pageSize") Integer pageSize,
			@RequestParam(defaultValue = "createDate", name = "sort") String sort,
			@RequestParam(defaultValue = "desc", name = "order") String orde) {

		ResponseResult result = new ResponseResult();

		List<Map<String, Object>> rows = Lists.newArrayList();
		Map<String, Object> condition = WebUtils.getParametersStartingWith(request, "search_");
		Page<User> userPage = new Page<User>(page, pageSize);
		userPage = userService.getUserListByCondition(userPage, condition);

		for (User user : userPage.getRecords()) {
			rows.add(user.toMap());
		}

		Map<String, Object> map = Maps.newHashMap();
		map.put("total", userPage.getTotal());
		map.put("rows", rows);
		result.setRespMap(map);
		return result.toStringForMap();
	}

	/**
	 * 详情查询
	 * 
	 * @param id
	 * @return
	 * @author Jensen
	 * @date 2018年2月18日
	 * @since 1.0
	 */
	@ResponseBody
	@RequestMapping("select")
	public String select(String id) {

		ResponseResult result = new ResponseResult();
		if (isBlank(id)) {
			return result.toFailString(getPropMessage("user.id.NotBlank"));
		} else {
			User user = userService.getUserById(id);
			if (null == user) {
				return result.toFailString(getPropMessage("user.NotNull"));
			} else {
				result.setRespMap(user.toMap());
				return result.toStringForMap();
			}
		}
	}

	/**
	 * 添加用户
	 * 
	 * @param vo
	 * @param rs
	 * @return
	 * @author Jensen
	 * @date 2018年2月18日
	 * @since 1.0
	 */
	@ResponseBody
	@RequestMapping("insert")
	public String insert(@Valid UserInsertVO vo, BindingResult rs) {

		ResponseResult result = new ResponseResult();
		try {
			if (rs.hasErrors()) {
				return result.toFailString(rs.getAllErrors().get(0).getDefaultMessage());
			} else {
				userService.insertUser(User.getInstance(vo));
				return result.toSuccessString();
			}
		} catch (Exception e) {
			LOGGER.error("添加新用户异常：{}", vo.toString(), e);
			return result.toFailString(getPropMessage("exception"));
		}
	}

	/**
	 * 修改用户
	 * 
	 * @param vo
	 * @param rs
	 * @return
	 * @author Jensen
	 * @date 2018年2月18日
	 * @since 1.0
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(@Valid UserUpdateVO vo, BindingResult rs) {

		ResponseResult result = new ResponseResult();
		try {
			if (rs.hasErrors()) {
				return result.toFailString(rs.getAllErrors().get(0).getDefaultMessage());
			} else {
				userService.updateUser(User.getInstance(vo));
				return result.toSuccessString();
			}
		} catch (Exception e) {
			LOGGER.error("修改用户异常：{}", vo.toString(), e);
			return result.toFailString(getPropMessage("exception"));
		}
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 * @author Jensen
	 * @date 2018年2月18日
	 * @since 1.0
	 */
	@ResponseBody
	@RequestMapping("delete")
	public String delete(String id) {

		ResponseResult result = new ResponseResult();
		if (isBlank(id)) {
			return result.toFailString(getPropMessage("user.id.NotBlank"));
		} else {
			User user = userService.getUserById(id);
			if (null == user) {
				return result.toFailString(getPropMessage("user.NotNull"));
			} else {
				userService.deleteUser(user);
				return result.toSuccessString();
			}
		}
	}

	@ResponseBody
	@RequestMapping(value = "resetPassword")
	public String resetPassword(@Valid UserResetPasswordVO vo, BindingResult rs) {

		ResponseResult result = new ResponseResult();
		try {
			if (rs.hasErrors()) {
				LOGGER.info(rs.getFieldErrors().get(0).getDefaultMessage());
				return result.toFailString(rs.getFieldErrors().get(0).getDefaultMessage());
			} else {
				userService.resetPassword(vo.getId(), vo.getPassword());
				return result.toSuccessString();
			}
		} catch (ServiceException e) {
			return result.toFailString(e.getMessage());
		}
	}

}
