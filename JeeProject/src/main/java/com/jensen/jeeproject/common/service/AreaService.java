package com.jensen.jeeproject.common.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.jensen.jeeproject.common.entity.Area;

public interface AreaService {

	Area getArea(String id);

	List<Area> list();

	Page<Area> getPage(Page<Area> page, Map<String, Object> condition);

	Integer insert(Area area);

	Integer update(Area area);

	Integer remove(String id);
}
