package com.bilgeadam.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@Entity
public class Urun {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="urun_ad")
	private String urunAd;
	
	@Column(name="stok_adet")
	private int stok;
	
	@OneToMany(mappedBy = "urun", cascade = CascadeType.ALL)
	private List<SiparisKalemi> sipariskalemiList;
	
	 private double fiyat;

	public Urun(String urunAd, int stok) {
		super();
		this.urunAd = urunAd;
		this.stok = stok;
	}

	public Urun() {
	
	}

	@Override
	public String toString() {
		return "Urun [id=" + id + ", urunAd=" + urunAd + ", stok=" + stok + ", sipariskalemiList=" + sipariskalemiList
				+ "]";
	}
	
	

}
