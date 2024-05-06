package com.abc.adminservice.model;

import java.time.LocalDateTime;

public class Booking {

	private int bookingId;
    private int driverId;
    private int customerId;
    private String fromLocation;
    private String toLocation;
    private LocalDateTime fromDateAndTime;
    private LocalDateTime toDateAndTime;
    private boolean status;
    private float distanceInKm;
    private float bill;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public LocalDateTime getFromDateAndTime() {
		return fromDateAndTime;
	}
	public void setFromDateAndTime(LocalDateTime fromDateAndTime) {
		this.fromDateAndTime = fromDateAndTime;
	}
	public LocalDateTime getToDateAndTime() {
		return toDateAndTime;
	}
	public void setToDateAndTime(LocalDateTime toDateAndTime) {
		this.toDateAndTime = toDateAndTime;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public float getDistanceInKm() {
		return distanceInKm;
	}
	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
    
    
    
    
    
    
	
}
