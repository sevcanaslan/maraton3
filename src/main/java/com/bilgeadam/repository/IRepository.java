package com.bilgeadam.repository;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.util.HibernateUtils;

public interface IRepository<T> {
	
	void save(T t);

	void update(T t, long id);

	void delete(long id);

	List<T> listAll();

	public T find(long id);


	default Session dataBaseConnectionHibernate() {

		return HibernateUtils.getSessionFactory().openSession();
	}
}
