package com.jensen.jeeproject.common.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jensen.jeeproject.common.entity.Area;

public interface AreaDao extends BaseMapper<Area, String> {

	Area getArea(String id);

	List<Area> list();

	List<Area> list(Page<Area> page, Map<String, Object> condition);

	Integer update(Area area);

	Integer remove(String id);

}
