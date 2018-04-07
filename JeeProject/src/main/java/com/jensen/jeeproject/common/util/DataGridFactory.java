package com.jensen.jeeproject.common.util;

import java.util.List;

import com.jensen.jeeproject.common.vo.DataGridVO;

public class DataGridFactory {

	public static <T> DataGridVO getInstance() {

		return new DataGridVO<T>();
	}

	public static <T> DataGridVO getInstance(Integer total, List<T> rows) {

		return new DataGridVO<T>(total, rows);
	}

}
