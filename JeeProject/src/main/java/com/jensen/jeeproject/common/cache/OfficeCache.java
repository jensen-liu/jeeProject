package com.jensen.jeeproject.common.cache;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;
import com.jensen.jeeproject.common.util.CacheUtils;
import com.jensen.jeeproject.common.util.SpringContextUtil;
import com.jensen.jeeproject.system.dao.OfficeDao;
import com.jensen.jeeproject.system.entity.Office;
import com.jensen.jeeproject.system.vo.TreeVO;

/**
 * 机构数据缓存
 * 
 * @author Jensen
 * @date 下午10:51:58
 * @version V1.0
 */
public class OfficeCache {

	private static OfficeDao officeDao = SpringContextUtil.getBean(OfficeDao.class);
	public static final String TREE_DATA_CACHE_KEY = "officeTreeData";

	public static synchronized List<TreeVO> getTreeDate() {

		if (null == CacheUtils.get(TREE_DATA_CACHE_KEY)) {
			List<Office> offices = officeDao.getList();
			List<TreeVO> voList = Lists.newArrayList();

			for (Office office : offices) {
				voList.add(office.formatTreeData());
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
