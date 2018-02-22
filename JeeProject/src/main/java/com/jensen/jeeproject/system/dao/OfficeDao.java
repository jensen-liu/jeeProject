package com.jensen.jeeproject.system.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jensen.jeeproject.system.entity.Office;

public interface OfficeDao extends BaseMapper<Office, String> {

	Office getOfficeById(String id);

	Office getOfficeByName(String name);

	Office getOfficeByCode(String code);

	List<Office> getList();

	List<Office> getListByCondition(Page<Office> page, Map<String, Object> condition);

	int insert(Office office);

	int update(Office office);

	int delete(Office office);
}
