package com.bilgeadam.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.bilgeadam.entity.Urun;

public class UrunDao  implements IRepository<Urun>{

	@Override
	public void save(Urun t) {
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
		}
		
		
	}

	@Override
	public void update(Urun u, long id) {
		Session session = null;
		try {
			Urun urun = find(id);

			if (urun != null) {
				urun.setUrunAd(u.getUrunAd());
				urun.setStok(u.getStok());
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.update(urun);
				session.getTransaction().commit();
				System.out.println("Urun bilgileri güncellendi");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Urun bilgileri güncellenirken bir sorun yaşandı");
		} finally {
			session.close();
		}
		
	}

	@Override
	public void delete(long id) {
		Session session = null;
		try {
			Urun deletedurun = find(id);
			if (deletedurun != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deletedurun);
				session.getTransaction().commit();
				System.out.println("Urun bilgileri silindi!");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Urun bilgileri silinirken bir sorun yaşandı");
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<Urun> listAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select urun from Urun as urun";
		TypedQuery<Urun> typedQuery = session.createQuery(query, Urun.class);
		List<Urun> urunList = typedQuery.getResultList();
		urunList.forEach(System.out::println);
		return urunList;
	}

	@Override
	public Urun find(long id) {
		Session session = dataBaseConnectionHibernate();
		Urun urun;
		try {
			urun = session.find(Urun.class, id);
			if (urun != null) {
				System.out.println("Urun bulundu--> " + urun);
				return urun;
			} else {
				System.out.println("Urun bulunamadı!");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Urun bilgileri getirilirken bir sorun yaşandı");
		} finally {
			session.close();
		}
		return null;
	}

}
