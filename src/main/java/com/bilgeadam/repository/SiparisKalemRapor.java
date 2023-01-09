package com.bilgeadam.repository;

import com.bilgeadam.entity.Urun;

public class SiparisKalemRapor {
	
	   private Urun urun;
	    private Integer adet;
	    private Double fiyat;
	    private Double toplamFiyat;
	    

	   
	  
	    
		public Urun getUrun() {
			return urun;
		}
		public void setUrun(Urun urun) {
			this.urun = urun;
		}
		public Integer getAdet() {
			return adet;
		}
		public void setAdet(Integer adet) {
			this.adet = adet;
		}
		public Double getFiyat() {
			return fiyat;
		}
		public void setFiyat(Double fiyat) {
			this.fiyat = fiyat;
		}
		public Double getToplamFiyat() {
			return adet * fiyat;
		}
		public void setToplamFiyat(Double toplamFiyat) {
			this.toplamFiyat = toplamFiyat;
		}

	    

}
