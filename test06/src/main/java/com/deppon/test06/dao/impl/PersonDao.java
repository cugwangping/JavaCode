package com.deppon.test06.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.deppon.test06.dao.IPersonDao;
import com.deppon.test06.entity.PersonEntity;

public class PersonDao implements IPersonDao {
	private SessionFactory factory;
	
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void save(PersonEntity person) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			session.save(person);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally{
			session.close();
		}
		
		
	}

	@Override
	public List<PersonEntity> queryAll() {
		Session session = factory.openSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<PersonEntity> personList = session.createQuery("from PersonEntity p").list();
		
		session.getTransaction().commit();
		session.close();
		
		return personList;
	}

}
