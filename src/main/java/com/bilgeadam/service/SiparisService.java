package com.bilgeadam.service;

import java.util.List;

import com.bilgeadam.entity.Siparis;
import com.bilgeadam.repository.SiparisDao;

public class SiparisService implements IService<Siparis>{
	
	private SiparisDao siparisDao;
	
	public SiparisService() {
		this.siparisDao= new SiparisDao();
	}
	
	@Override
	public void create(Siparis entity) {
		siparisDao.save(entity);
		
	}

	@Override
	public void delete(long id) {
		siparisDao.delete(id);
		
	}

	@Override
	public void update(long id, Siparis entity) {
		siparisDao.update(entity, id);
		
	}

	@Override
	public List<Siparis> listAll() {
		return  siparisDao.listAll();
	}

	@Override
	public Siparis find(long id) {
		Siparis siparis= siparisDao.find(id);
		return siparis;
	}

}
