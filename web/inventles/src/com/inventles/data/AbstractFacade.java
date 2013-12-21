package com.inventles.data;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inventles.data.management.InventlesSessionManagement;

public abstract class AbstractFacade<T> {
	private Class<T> entityClass;

	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected SessionFactory getSessionFactory() {
		return InventlesSessionManagement.INSTANCE.getSessionFactory();
	}

	/*
	 * public void create(T entity) { getEntityManager().persist(entity); }
	 * 
	 * public void edit(T entity) { getEntityManager().merge(entity); }
	 * 
	 * public void remove(T entity) {
	 * getEntityManager().remove(getEntityManager().merge(entity)); }
	 */

	public T find(Serializable id) {
		Session session = getSessionFactory().openSession();
		return (T) session.get(entityClass, id);
	}

	public List<T> findAll() {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(entityClass);
		return criteria.list();
	}

}
