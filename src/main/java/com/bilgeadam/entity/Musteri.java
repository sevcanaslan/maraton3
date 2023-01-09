package com.bilgeadam.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@Entity
public class Musteri {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="musteri_ad")
	private String ad;
	
	@Column(name="musteri_soyad")
	private String soyad;
	
	@OneToMany(mappedBy = "musteri", cascade = CascadeType.ALL)
	private List<Siparis> siparisList;
	
	
	public Musteri() {
		
	}




	public Musteri(String ad, String soyad) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.siparisList= new ArrayList();
	
	}




	@Override
	public String toString() {
		return "Musteri [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", siparisList=" + siparisList + "]";
	}
	
	
	

}
