package com.jensen.jeeproject.system.controller;

import static com.jensen.jeeproject.common.util.PropUtil.getPropMessage;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jensen.jeeproject.common.cache.OfficeCache;
import com.jensen.jeeproject.common.exception.ServiceException;
import com.jensen.jeeproject.common.util.CacheUtils;
import com.jensen.jeeproject.common.util.PropUtil;
import com.jensen.jeeproject.common.util.ResponseResult;
import com.jensen.jeeproject.system.entity.Office;
import com.jensen.jeeproject.system.service.OfficeService;
import com.jensen.jeeproject.system.vo.OfficeInsertVO;
import com.jensen.jeeproject.system.vo.OfficeUpdateVO;
import com.jensen.jeeproject.system.vo.TreeVO;

/**
 * 组织机构Controller类
 * 
 * @author Jensen
 * @date 下午7:45:03
 * @version V1.0
 */
@Controller
@RequestMapping("office")
public class OfficeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OfficeController.class);
	@Autowired
	private OfficeService officeService;

	/**
	 * 跳转至机构管理首页
	 * 
	 * @return
	 * @author Jensen
	 * @date 2018年2月24日
	 * @since 1.0
	 */
	@RequestMapping("toHome")
	public String toHome() {

		return "office/office_home";
	}

	/**
	 * 跳转至添加机构表单页面
	 * 
	 * @return
	 * @author Jensen
	 * @date 2018年2月24日
	 * @since 1.0
	 */
	@RequestMapping("toAdd")
	public String toAdd() {

		return "office/office_add";
	}

	/**
	 * 跳转至修改机构表单页面
	 * 
	 * @return
	 * @author Jensen
	 * @date 2018年2月24日
	 * @since 1.0
	 */
	@RequestMapping("toEdit")
	public String toEdit() {

		return "office/office_edit";
	}

	@ResponseBody
	@RequestMapping("select")
	public String select(String id) {

		ResponseResult result = new ResponseResult();
		if (isBlank(id)) {
			return result.toFailString(getPropMessage("office.id.NotBlank"));
		} else {
			Office office = officeService.getOfficeById(id);
			if (null == office) {
				return result.toFailString(getPropMessage("office.NotNull"));
			} else {
				result.setRespMap(office.toMap());
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
		Page<Office> officePage = new Page<Office>(page, pageSize);
		officePage = officeService.getListByCondition(officePage, condition);

		for (Office office : officePage.getRecords()) {
			rows.add(office.toMap());
		}

		Map<String, Object> map = Maps.newHashMap();
		map.put("total", officePage.getTotal());
		map.put("rows", rows);
		return JSONObject.toJSONString(map);
	}

	@ResponseBody
	@RequestMapping("treeData")
	public String treeData() {

		List<TreeVO> voList = OfficeCache.getTreeDate();
		return JSONArray.toJSONString(voList);
	}

	@ResponseBody
	@RequestMapping("insert")
	public String insert(OfficeInsertVO vo) {

		ResponseResult result = new ResponseResult();
		try {
			Office office = Office.getInstance(vo);
			officeService.insert(office);
			return result.toSuccessString();
		} catch (ServiceException e) {
			return result.toFailString(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("添加组织机构异常：{}", vo.toString(), e);
			return result.toFailString(getPropMessage("exception"));
		}
	}

	@ResponseBody
	@RequestMapping("update")
	public String update(OfficeUpdateVO vo) {

		ResponseResult result = new ResponseResult();
		try {
			Office office = Office.getInstance(vo);
			officeService.update(office);
			return result.toSuccessString();
		} catch (ServiceException e) {
			return result.toFailString(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("修改组织机构异常：{}", vo.toString(), e);
			return result.toFailString(getPropMessage("exception"));
		}
	}

	@ResponseBody
	@RequestMapping("delete")
	public String delete(String id) {

		ResponseResult result = new ResponseResult();
		try {
			if (isNotBlank(id)) {
				officeService.delete(id);
				return result.toSuccessString();
			} else {
				return result.toFailString(PropUtil.getPropMessage("office.id.NotBlank"));
			}
		} catch (ServiceException e) {
			return result.toFailString(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("机构删除异常：id:{}", id, e);
			return result.toFailString(PropUtil.getPropMessage("exception"));
		}
	}

}
