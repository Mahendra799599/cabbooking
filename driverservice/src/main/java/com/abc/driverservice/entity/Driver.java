package com.abc.driverservice.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;
    private int cabId;
    private String licenseNo;
    private float rating;
    private String availableCab;
    private String tripBooking;
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public int getCabId() {
		return cabId;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
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