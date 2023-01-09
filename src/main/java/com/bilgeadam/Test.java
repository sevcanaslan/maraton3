package com.bilgeadam;

import java.util.Arrays;

import com.bilgeadam.entity.Musteri;
import com.bilgeadam.entity.Siparis;
import com.bilgeadam.entity.SiparisKalemi;
import com.bilgeadam.entity.Urun;
import com.bilgeadam.repository.MusteriDao;
import com.bilgeadam.repository.MusteriRapor;
import com.bilgeadam.repository.SiparisDao;
import com.bilgeadam.repository.SiparisKalemiDao;
import com.bilgeadam.repository.UrunDao;
import com.bilgeadam.service.SiparisService;
import com.bilgeadam.util.HibernateUtils;

public class Test {
	

	
	public static void main(String[] args) {
		MusteriDao musteriDao= new MusteriDao();
		SiparisKalemiDao skD= new SiparisKalemiDao();
		SiparisDao sd= new SiparisDao();
		UrunDao urunDao= new UrunDao();
		
		Musteri m1 = new Musteri("Ali", "Kaya");
		Musteri m2 = new Musteri("Veli", "Özkan");
		Urun u1 = new Urun("Iphone 11", 17000);
		Urun u2 = new Urun("Samsung s21", 18000);
		Urun u3 = new Urun("LG LED TV", 8500);
		Urun u4 = new Urun("Iphone 11", 2500);
		SiparisKalemi sk1= new SiparisKalemi(u1,1);
		SiparisKalemi sk2= new SiparisKalemi(u2,2);
		SiparisKalemi sk3= new SiparisKalemi(u2,2);
		SiparisKalemi sk4= new SiparisKalemi(u3,1);
		SiparisKalemi sk5= new SiparisKalemi(u4,2);
		
		Siparis s1= new Siparis(m1, Arrays.asList(sk1,sk2));
		Siparis s2= new Siparis(m2, Arrays.asList(sk3,sk4));
		Siparis s3= new Siparis(m1, Arrays.asList(sk5));
		Siparis s4= new Siparis(m2, Arrays.asList(new SiparisKalemi(u1,1)));
		Siparis s5= new Siparis(m2, Arrays.asList(new SiparisKalemi(u2,1)));
		
		
//		musteriDao.save(m1);
//		musteriDao.save(m2);

//		urunDao.save(u1);
//		urunDao.save(u2);
//		urunDao.save(u3);
//		urunDao.save(u4);
		
//		skD.save(sk1);
//		skD.save(sk2);	
//		skD.save(sk3);
//		skD.save(sk4);	
//		skD.save(sk5);
		
//		sd.save(s1);
//		sd.save(s2);
//		sd.save(s3);
//		sd.save(s4);
//		sd.save(s5);
		
		//skD.SiparisToplami();
		MusteriRapor mr= new MusteriRapor();
		mr.musteriAl(m1);
		
	}
	
	


}
