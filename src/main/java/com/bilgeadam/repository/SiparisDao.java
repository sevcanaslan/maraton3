package com.bilgeadam.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bilgeadam.entity.Siparis;


public class SiparisDao  implements IRepository<Siparis>{

	@Override
	public void save(Siparis t) {
		Transaction transaction = null;

		try (Session session = dataBaseConnectionHibernate()) {
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("Saved Error");
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void update(Siparis s, long id) {
		Session session = null;
		try {
			Siparis siparis = find(id);

			if (siparis != null) {
				siparis.setMusteri(s.getMusteri());
	
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.update(siparis);
				session.getTransaction().commit();
				System.out.println("Siparis bilgileri güncellendi");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Siparis bilgileri güncellenirken bir sorun yaşandı");
		} finally {
			session.close();
		}
		
	}

	@Override
	public void delete(long id) {
		Session session = null;
		try {
			Siparis deletedsiparis = find(id);
			if (deletedsiparis != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deletedsiparis);
				session.getTransaction().commit();
				System.out.println("Siparis bilgileri silindi!");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Siparis bilgileri silinirken bir sorun yaşandı");
		} finally {
			session.close();
		}
		
	}
	
	@Override
	public List<Siparis> listAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select siparis from Siparis as siparis";
		TypedQuery<Siparis> typedQuery = session.createQuery(query, Siparis.class);
		List<Siparis> siparisList = typedQuery.getResultList();
		siparisList.forEach(System.out::println);
		return siparisList;
	}

	@Override
	public Siparis find(long id) {
		Session session = dataBaseConnectionHibernate();
		Siparis siparis;
		try {
			siparis = session.find(Siparis.class, id);
			if (siparis != null) {
				System.out.println("Siparis bulundu--> " + siparis);
				return siparis;
			} else {
				System.out.println("Siparis bulunamadı!");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Siparis bilgileri getirilirken bir sorun yaşandı");
		} finally {
			session.close();
		}
		return null;
	

	}



}
