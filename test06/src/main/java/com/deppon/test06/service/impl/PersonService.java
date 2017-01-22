package com.deppon.test06.service.impl;

import java.util.List;

import com.deppon.test06.dao.IPersonDao;
import com.deppon.test06.entity.PersonEntity;
import com.deppon.test06.service.IPersonService;

public class PersonService implements IPersonService {
	private IPersonDao personDao;
	
	public void setPersonDao(IPersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void processSave(PersonEntity person) {
		personDao.save(person);
	}

	@Override
	public List<PersonEntity> processQueryAll() {
		return personDao.queryAll();
	}

}
