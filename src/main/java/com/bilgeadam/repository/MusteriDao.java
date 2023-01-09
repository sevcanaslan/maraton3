package com.bilgeadam.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bilgeadam.entity.Musteri;

public class MusteriDao implements IRepository<Musteri>{

	@Override
	public void save(Musteri t) {
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
	public void update(Musteri m, long id) {
		Session session = null;
		try {
			Musteri musteri = find(id);

			if (musteri != null) {
				musteri.setAd(m.getAd());
				musteri.setSoyad(m.getSoyad());;
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.update(musteri);
				session.getTransaction().commit();
				System.out.println("Müşteri bilgileri güncellendi");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Müşteri bilgileri güncellenirken bir sorun yaşandı");
		} finally {
			session.close();
		}
		
	}
	

	@Override
	public void delete(long id) {
		Session session = null;
		try {
			Musteri deletedMusteri = find(id);
			if (deletedMusteri != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deletedMusteri);
				session.getTransaction().commit();
				System.out.println("Müşteri bilgileri silindi!");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Müşteri bilgileri güncellenirken bir sorun yaşandı");
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<Musteri> listAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select musteri from Musteri as musteri";
		TypedQuery<Musteri> typedQuery = session.createQuery(query, Musteri.class);
		List<Musteri> musteriList = typedQuery.getResultList();
		musteriList.forEach(System.out::println);
		return musteriList;
	
	}

	@Override
	public Musteri find(long id) {
		Session session = dataBaseConnectionHibernate();
		Musteri musteri;
		try {
			musteri = session.find(Musteri.class, id);
			if (musteri != null) {
				System.out.println("Müşteri bulundu--> " + musteri);
				return musteri;
			} else {
				System.out.println("Müşteri bulunamadı!");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Müşteri bilgileri güncellenirken bir sorun yaşandı");
		} finally {
			session.close();
		}
		return null;
	
	}





}
