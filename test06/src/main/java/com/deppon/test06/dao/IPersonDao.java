package com.deppon.test06.dao;

import java.util.List;

import com.deppon.test06.entity.PersonEntity;

public interface IPersonDao {
	
	/**
	 * 插入一条记录
	 * @param person
	 */
	public void save(PersonEntity person);
	
	/**
	 * 查询所有记录
	 * @return
	 */
	public List<PersonEntity> queryAll();
}
