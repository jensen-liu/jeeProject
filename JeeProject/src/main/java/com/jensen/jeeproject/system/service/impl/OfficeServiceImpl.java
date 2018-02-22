package com.jensen.jeeproject.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jensen.jeeproject.common.enumeration.SwitchEnum;
import com.jensen.jeeproject.common.exception.ServiceException;
import com.jensen.jeeproject.common.util.PropUtil;
import com.jensen.jeeproject.system.dao.OfficeDao;
import com.jensen.jeeproject.system.entity.Office;
import com.jensen.jeeproject.system.service.OfficeService;

@Service
public class OfficeServiceImpl implements OfficeService {

	@Autowired
	private OfficeDao officeDao;

	@Override
	public Office getOfficeById(String id) {

		return officeDao.getOfficeById(id);
	}

	@Override
	public Office getOfficeByName(String name) {

		return officeDao.getOfficeByName(name);
	}

	@Override
	public Office getOfficeByCode(String code) {

		return officeDao.getOfficeByCode(code);
	}

	@Override
	public List<Office> getList() {

		return officeDao.getList();
	}

	@Override
	public Page<Office> getUserListByCondition(Page<Office> page, Map<String, Object> condition) {

		List<Office> officeList = officeDao.getListByCondition(page, condition);
		page.setSearchCount(true);
		page.setRecords(officeList);

		return page;
	}

	@Override
	public int insert(Office office) throws ServiceException {

		return officeDao.insert(office);
	}

	@Override
	public int update(Office office) throws ServiceException {

		return officeDao.update(office);
	}

	@Override
	public int delete(String id) throws ServiceException {

		Office office = officeDao.getOfficeById(id);
		if (null != office) {
			office.setDelFlag(SwitchEnum.YES.getId());
			office.setDeleteDate(new Date());
			return officeDao.delete(office);
		} else {
			throw new ServiceException(PropUtil.getPropMessage("office.NotNull"));
		}
	}
}
