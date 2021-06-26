package com.InnohubGroup.mobileHandset.models;

import javax.persistence.Embeddable;

@Embeddable
public class Release {

	private String announceDate;
	private String priceEur;
	public String getAnnounceDate() {
		return announceDate;
	}
	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}
	public String getPriceEur() {
		return priceEur;
	}
	public void setPriceEur(String priceEur) {
		this.priceEur = priceEur;
	}
}
