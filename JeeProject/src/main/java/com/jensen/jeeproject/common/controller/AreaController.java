package com.jensen.jeeproject.common.controller;

import static com.jensen.jeeproject.common.util.PropUtil.getPropMessage;
import static org.apache.commons.lang3.StringUtils.isBlank;

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
import com.baomidou.mybatisplus.plugins.Page;
import com.jensen.jeeproject.common.cache.AreaCache;
import com.jensen.jeeproject.common.entity.Area;
import com.jensen.jeeproject.common.service.AreaService;
import com.jensen.jeeproject.common.util.DataGridFactory;
import com.jensen.jeeproject.common.util.ResponseResult;
import com.jensen.jeeproject.common.vo.AreaInsertVO;
import com.jensen.jeeproject.common.vo.AreaUpdateVO;
import com.jensen.jeeproject.system.vo.TreeVO;

@Controller
@RequestMapping("area")
public class AreaController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AreaController.class);

	@Autowired
	private AreaService areaService;

	@ResponseBody
	@RequestMapping("getArea")
	public String getArea(String id) {

		ResponseResult result = new ResponseResult();
		if (isBlank(id)) {
			return result.toFailString(getPropMessage("area.id.NotBlank"));
		} else {
			Area area = areaService.getArea(id);
			if (null == area) {
				return result.toFailString(getPropMessage("area.NotNull"));
			} else {
				result.setRespObject(area);
				return result.toStringForObject();
			}
		}
	}

	@ResponseBody
	@RequestMapping("list")
	public String list(HttpServletRequest request, @RequestParam(defaultValue = "1", name = "page") Integer page,
			@RequestParam(defaultValue = "20", name = "pageSize") Integer pageSize,
			@RequestParam(defaultValue = "sort", name = "sort") String sort,
			@RequestParam(defaultValue = "desc", name = "order") String orde) {

		Map<String, Object> condition = WebUtils.getParametersStartingWith(request, "search_");
		Page<Area> areaPage = new Page<Area>(page, pageSize);
		areaPage = areaService.getPage(areaPage, condition);

		return DataGridFactory.getInstance(areaPage.getTotal(), areaPage.getRecords()).toJson();
	}

	@ResponseBody
	@RequestMapping("tree")
	public String tree() {

		List<TreeVO> voList = AreaCache.getTreeDate();
		return JSONArray.toJSONString(voList);
	}

	@ResponseBody
	@RequestMapping("insert")
	public String insert(AreaInsertVO vo) {

		ResponseResult result = new ResponseResult();

		return result.toSuccessString();
	}

	@ResponseBody
	@RequestMapping("update")
	public String update(AreaUpdateVO vo) {

		ResponseResult result = new ResponseResult();

		return result.toSuccessString();
	}

	@ResponseBody
	@RequestMapping("remove")
	public String remove(String id) {

		ResponseResult result = new ResponseResult();
		if (isBlank(id)) {
			return result.toFailString(getPropMessage("area.id.NotBlank"));
		} else {
			areaService.remove(id);
			return result.toSuccessString();
		}
	}

}
