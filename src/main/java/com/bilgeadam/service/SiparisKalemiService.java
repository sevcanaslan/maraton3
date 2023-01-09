package com.bilgeadam.service;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.entity.Siparis;
import com.bilgeadam.entity.Urun;
import com.bilgeadam.entity.SiparisKalemi;
import com.bilgeadam.repository.SiparisKalemiDao;


public class SiparisKalemiService implements IService<SiparisKalemi>{
	
	private SiparisKalemiDao siparisKalemiDao;
	private Urun urun;
	
	public SiparisKalemiService() {
		this.siparisKalemiDao= new SiparisKalemiDao();
	}
	@Override
	public void create(SiparisKalemi entity) {
		siparisKalemiDao.save(entity);
		
	}

	@Override
	public void delete(long id) {
		siparisKalemiDao.delete(id);
		
	}
	

	@Override
	public void update(long id, SiparisKalemi entity) {
		siparisKalemiDao.update(entity, id);
		
	}

	@Override
	public List<SiparisKalemi> listAll() {
		
		return siparisKalemiDao.listAll();
	}

	@Override
	public SiparisKalemi find(long id) {
		SiparisKalemi siparisKalemi= siparisKalemiDao.find(id);
		return siparisKalemi;
	}

}
