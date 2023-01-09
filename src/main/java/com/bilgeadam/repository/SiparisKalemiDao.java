package com.bilgeadam.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bilgeadam.entity.Siparis;
import com.bilgeadam.entity.SiparisKalemi;
import com.bilgeadam.entity.Urun;
import com.bilgeadam.util.HibernateUtils;

public class SiparisKalemiDao  implements IRepository<SiparisKalemi>{

	@Override
	public void save(SiparisKalemi t) {
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
	public void SiparisToplami() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
	
		List<Siparis> siparisler = session.createQuery("FROM Siparis", Siparis.class).list();
	
		
	        for (Siparis siparis : siparisler) {
	        	double toplamUcret = 0;

	            List<SiparisKalemi> kalemler = siparis.getSiparisKalemleri();

	            // Her kalem için, ürünü çekin ve toplam ücreti hesaplayın.
	            for (SiparisKalemi kalem : kalemler) {
	                Urun urun = kalem.getUrun();
	                int adet = kalem.getUrunAdet();
	                double fiyat = urun.getFiyat();

	                toplamUcret += adet * fiyat;
	            }

	            // Siparişin toplam ücretini ekrana yazdırın.
	            System.out.println("Sipariş ID: " + siparis.getId() +" Musteri: " +siparis.getMusteri().getAd()+" Musteri ID:"+siparis.getMusteri().getId()+ 
	            		kalemler.toString()+ " Sipariş toplamı: " +toplamUcret);
	            
	        }
	        
			
			
		}

	      
	    
	    
	

	@Override
	public void update(SiparisKalemi sK, long id) {
		Session session = null;
		try {
			SiparisKalemi siparisKalemi = find(id);

			if (siparisKalemi != null) {
				siparisKalemi.setUrunAdet(sK.getUrunAdet());
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.update(siparisKalemi);
				session.getTransaction().commit();
				System.out.println("Siparis Kalemi bilgileri güncellendi");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Siparis Kalemi bilgileri güncellenirken bir sorun yaşandı");
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(long id) {
		
		Session session = null;
		try {
			SiparisKalemi deletedsiparisKalemi = find(id);
			if (deletedsiparisKalemi != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deletedsiparisKalemi);
				session.getTransaction().commit();
				System.out.println("Siparis Kalemi bilgileri silindi!");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Siparis Kalemi bilgileri güncellenirken bir sorun yaşandı");
		} finally {
			session.close();
		}
	}

	@Override
	public List<SiparisKalemi> listAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select sipariskalemi from SiparisKalemi as sipariskalemi";
		TypedQuery<SiparisKalemi> typedQuery = session.createQuery(query, SiparisKalemi.class);
		List<SiparisKalemi> sipariskalemiList = typedQuery.getResultList();
		sipariskalemiList.forEach(System.out::println);
		return sipariskalemiList;
	}

	@Override
	public SiparisKalemi find(long id) {
		Session session = dataBaseConnectionHibernate();
		SiparisKalemi siparisKalemi;
		try {
			siparisKalemi = session.find(SiparisKalemi.class, id);
			if (siparisKalemi != null) {
				System.out.println("Siparis Kalemi bulundu--> " + siparisKalemi);
				return siparisKalemi;
			} else {
				System.out.println("Siparis Kalemi bulunamadı!");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Siparis Kalemi bilgileri güncellenirken bir sorun yaşandı");
		} finally {
			session.close();
		}
		return null;
	}

}
