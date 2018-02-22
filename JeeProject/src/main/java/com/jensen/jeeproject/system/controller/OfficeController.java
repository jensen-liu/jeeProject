package com.jensen.jeeproject.system.controller;

import static com.jensen.jeeproject.common.util.PropUtil.getPropMessage;
import static org.apache.commons.lang3.StringUtils.isBlank;

import static org.apache.commons.lang3.StringUtils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jensen.jeeproject.common.exception.ServiceException;
import com.jensen.jeeproject.common.util.PropUtil;
import com.jensen.jeeproject.common.util.ResponseResult;
import com.jensen.jeeproject.system.entity.Office;
import com.jensen.jeeproject.system.service.OfficeService;
import com.jensen.jeeproject.system.vo.OfficeInsertVO;
import com.jensen.jeeproject.system.vo.OfficeUpdateVO;
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
	@RequestMapping("treeData")
	public String treeData() {

		return null;
	}

	@ResponseBody
	@RequestMapping("insert")
	public String insert(OfficeInsertVO vo) {

		ResponseResult result = new ResponseResult();
		return result.toSuccessString();
	}

	@ResponseBody
	@RequestMapping("update")
	public String update(OfficeUpdateVO vo) {

		ResponseResult result = new ResponseResult();
		return result.toSuccessString();
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
