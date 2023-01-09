package com.bilgeadam.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
public class Siparis {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	

	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="musteri_id")
	 private Musteri musteri;
	
	 @OneToMany(mappedBy="siparis", cascade=CascadeType.ALL)
	 private List<SiparisKalemi> siparisKalemleri;
	

	public Siparis(Musteri musteri, List<SiparisKalemi> siparisKalemiList) {
		super();
		this.musteri = musteri;
		this.siparisKalemleri = new ArrayList();
	}

	public Siparis() {

	}

	@Override
	public String toString() {
		return "Siparis [id=" + id + ", musteri=" + musteri + ", siparisKalemleri=" + siparisKalemleri + "]";
	}

	
	

}
