package com.bilgeadam.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
public class SiparisKalemi {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	

	
	@Column(name="urun_adet")
	private int urunAdet;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="urun_id")
	 private Urun urun;
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="siparis_id")
	 private Siparis siparis;
	
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Siparis siparis;

	public SiparisKalemi(Urun urun, int urunAdet) {
		super();
		this.urun = urun;
		this.urunAdet = urunAdet;

	}


	public SiparisKalemi() {
	
	}


	@Override
	public String toString() {
		return "SiparisKalemi [id=" + id + ", urunAdet=" + urunAdet + ", urun=" + urun + "]";
	}


	
	

	
	

}
