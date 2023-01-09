package com.bilgeadam.service;


import java.util.List;

import com.bilgeadam.entity.Urun;
import com.bilgeadam.repository.UrunDao;

public class UrunService implements IService<Urun>{
	
	private UrunDao urunDao;
	
	public UrunService() {
		this.urunDao= new UrunDao();
	}

	@Override
	public void create(Urun entity) {
		urunDao.save(entity);
	}

	@Override
	public void delete(long id) {
		urunDao.delete(id);
		
	}

	@Override
	public void update(long id, Urun entity) {
		urunDao.update(entity, id);
		
	}

	@Override
	public List<Urun> listAll() {
		
		return urunDao.listAll();
	}

	@Override
	public Urun find(long id) {
		Urun urun= urunDao.find(id);
		return urun;
	}

}
