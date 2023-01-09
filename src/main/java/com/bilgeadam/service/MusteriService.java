package com.bilgeadam.service;

import java.util.List;

import com.bilgeadam.entity.Musteri;
import com.bilgeadam.repository.MusteriDao;

public class MusteriService implements IService<Musteri>{

	private MusteriDao musteriDao;
	
	public MusteriService() {
		this.musteriDao= new MusteriDao();
	}
	
	@Override
	public void create(Musteri entity) {
		musteriDao.save(entity);
	}

	@Override
	public void delete(long id) {
		musteriDao.delete(id);
		
	}

	@Override
	public void update(long id, Musteri entity) {
		musteriDao.update(entity, id);
		
	}

	@Override
	public List<Musteri> listAll() {
		
		return musteriDao.listAll();
	}

	@Override
	public Musteri find(long id) {
		Musteri musteri = musteriDao.find(id);
		return musteri;
	}

}
