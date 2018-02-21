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
import com.jensen.jeeproject.system.entity.Office;
import com.jensen.jeeproject.system.service.OfficeService;

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

	public String insert() {

		ResponseResult result = new ResponseResult();
		return result.toSuccessString();
	}

	public String update() {

		ResponseResult result = new ResponseResult();
		return result.toSuccessString();
	}

	public String delete(String id) {

		ResponseResult result = new ResponseResult();
		return result.toSuccessString();
	}

}
