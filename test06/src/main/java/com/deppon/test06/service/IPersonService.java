package com.deppon.test06.service;

import java.util.List;

import com.deppon.test06.entity.PersonEntity;

public interface IPersonService {
	
	/**
	 * 处理添加记录
	 */
	public void processSave(PersonEntity person);
	
	/**
	 * 处理查询所有记录
	 * @return
	 */
	public List<PersonEntity> processQueryAll();
}
