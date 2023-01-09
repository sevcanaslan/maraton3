package com.bilgeadam.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.entity.Musteri;
import com.bilgeadam.entity.Siparis;
import com.bilgeadam.entity.SiparisKalemi;
import com.bilgeadam.entity.Urun;


public class HibernateUtils {
	private static SessionFactory sessionFactory;
	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();
	private static SessionFactory sessionFactoryHibernate() {
		try {
			Configuration configuration = new Configuration();


			configuration.addAnnotatedClass(Musteri.class);
			configuration.addAnnotatedClass(Siparis.class);
			configuration.addAnnotatedClass(SiparisKalemi.class);
			configuration.addAnnotatedClass(Urun.class);

			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}