package com.jensen.jeeproject.system.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.jensen.jeeproject.common.exception.ServiceException;
import com.jensen.jeeproject.system.entity.Office;
import com.jensen.jeeproject.system.entity.User;

public interface OfficeService {

	Office getOfficeById(String id);

	Office getOfficeByName(String name);

	Office getOfficeByCode(String code);

	List<Office> getList();

	Page<Office> getListByCondition(Page<Office> page, Map<String, Object> condition);

	int insert(Office office) throws ServiceException;

	int update(Office office) throws ServiceException;

	int delete(String id) throws ServiceException;

}
