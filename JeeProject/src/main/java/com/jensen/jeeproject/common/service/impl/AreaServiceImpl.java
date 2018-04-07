package com.jensen.jeeproject.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jensen.jeeproject.common.dao.AreaDao;
import com.jensen.jeeproject.common.entity.Area;
import com.jensen.jeeproject.common.service.AreaService;
@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;

	@Override
	public Area getArea(String id) {

		return areaDao.getArea(id);
	}

	@Override
	public List<Area> list() {

		return areaDao.list();
	}

	@Override
	public Page<Area> getPage(Page<Area> page, Map<String, Object> condition) {

		List<Area> areaList = areaDao.list(page, condition);
		page.setSearchCount(true);
		page.setRecords(areaList);

		return page;
	}

	@Override
	public Integer insert(Area area) {

		return areaDao.insert(area);
	}

	@Override
	public Integer update(Area area) {

		return areaDao.update(area);
	}

	@Override
	public Integer remove(String id) {

		return areaDao.remove(id);
	}

}
