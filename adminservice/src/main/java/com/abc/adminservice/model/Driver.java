package com.abc.adminservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Driver {
    
    private Long id;

    private String licenseNo;
    private String rating;
    private String availableCab;
    private String tripBooking;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getAvailableCab() {
		return availableCab;
	}
	public void setAvailableCab(String availableCab) {
		this.availableCab = availableCab;
	}
	public String getTripBooking() {
		return tripBooking;
	}
	public void setTripBooking(String tripBooking) {
		this.tripBooking = tripBooking;
	}

   
}
