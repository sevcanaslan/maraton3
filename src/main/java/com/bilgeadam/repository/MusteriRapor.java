package com.bilgeadam.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bilgeadam.entity.Musteri;
import com.bilgeadam.entity.Siparis;
import com.bilgeadam.entity.SiparisKalemi;
import com.bilgeadam.entity.Urun;
import com.bilgeadam.util.HibernateUtils;

public class MusteriRapor {
	
	 private Musteri musteri;
	    private List<SiparisKalemRapor> siparisKalemleri;
	    private Double toplamHarcama;
	    
	    
		public Musteri getMusteri() {
			return musteri;
		}
		public void setMusteri(Musteri musteri) {
			this.musteri = musteri;
		}
		public List<SiparisKalemRapor> getSiparisKalemleri() {
			return siparisKalemleri;
		}
		public void setSiparisKalemleri(List<SiparisKalemRapor> siparisKalemleri) {
			this.siparisKalemleri = siparisKalemleri;
		}
		public Double getToplamHarcama() {
			 Double toplam = 0.0;
		        for (SiparisKalemRapor skRapor : siparisKalemleri) {
		            toplam += skRapor.getToplamFiyat();
		        }
		        return toplam;
		}
		
		
		
		
		public void setToplamHarcama(Double toplamHarcama) {
			this.toplamHarcama = toplamHarcama;
		}
		
		
		
	    public List<MusteriRapor> musteriAl(Musteri musteri1) {
	    	
	    	
	    	Session session = HibernateUtils.getSessionFactory().openSession();

	  
	    	    String hql = "SELECT m, s, sk, u FROM Musteri m " +
	    	                 "JOIN m.siparisList s " +
	    	                 "JOIN s.siparisKalemleri sk " +
	    	                 "JOIN sk.urun u " +
	    	                 "WHERE m.id = :musteriId";

	    	    Query query = session.createQuery(hql);
	    	    query.setParameter("musteriId", musteri.getId());

	    	    List<Object[]> results = query.list();

	    	    Map<Long, MusteriRapor> raporlar = new HashMap<>();
	    	    for (Object[] result : results) {
	    	        Musteri m = (Musteri) result[(int)musteri1.getId()];
	    	        Siparis s = (Siparis) result[1];
	    	        SiparisKalemi sk = (SiparisKalemi) result[2];
	    	        Urun u = (Urun) result[3];

	    	        MusteriRapor rapor = raporlar.get(m.getId());
	    	        if (rapor == null) {
	    	            rapor = new MusteriRapor();
	    	            rapor.setMusteri(m);
	    	            rapor.setSiparisKalemleri(new ArrayList<>());
	    	            raporlar.put(m.getId(), rapor);
	    	        }

	    	        SiparisKalemRapor skRapor = new SiparisKalemRapor();
	    	        skRapor.setUrun(u);
	    	        skRapor.setAdet(sk.getUrunAdet());
	    	 
	    	        skRapor.setFiyat(u.getFiyat());
	    	        rapor.getSiparisKalemleri().add(skRapor);
	    	    }

	    	    List<MusteriRapor> raporListesi = new ArrayList<>(raporlar.values());

	    	    return raporListesi;
	    	
	    
	    }
	    

}
