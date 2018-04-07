package com.jensen.jeeproject.common.cache;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.jensen.jeeproject.common.dao.AreaDao;
import com.jensen.jeeproject.common.entity.Area;
import com.jensen.jeeproject.common.util.CacheUtils;
import com.jensen.jeeproject.common.util.SpringContextUtil;
import com.jensen.jeeproject.system.vo.TreeVO;

public class AreaCache {

	private static Logger LOGGER = LoggerFactory.getLogger(AreaCache.class);
	private static AreaDao areaDao = SpringContextUtil.getBean(AreaDao.class);
	public static final String TREE_DATA_CACHE_KEY = "areaTreeData";

	public static synchronized List<TreeVO> getTreeDate() {

		if (null == CacheUtils.get(TREE_DATA_CACHE_KEY)) {
			List<Area> areaList = areaDao.list();
			LOGGER.info("集合大小：{}", areaList.size());
			List<TreeVO> voList = Lists.newArrayList();

			for (Area area : areaList) {
				voList.add(area.formatTreeData());
			}
			for (TreeVO vo : voList) {
				for (TreeVO vo2 : voList) {
					if (vo.getId().equals(vo2.getParentId())) {
						vo.getChildren().add(vo2);
					}
				}
			}
			Iterator<TreeVO> iterator = voList.iterator();
			while (iterator.hasNext()) {
				TreeVO vo = iterator.next();
				if (isNotBlank(vo.getParentId())) {
					iterator.remove();
				}
			}
			CacheUtils.put(TREE_DATA_CACHE_KEY, voList);
		}
		return (List<TreeVO>) CacheUtils.get(TREE_DATA_CACHE_KEY);
	}

	public static void clear() {

		CacheUtils.remove(TREE_DATA_CACHE_KEY);
	}

}
