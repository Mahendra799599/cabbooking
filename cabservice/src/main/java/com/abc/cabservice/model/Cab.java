package com.abc.cabservice.model;


public class Cab {

    private int cabId;
    private String cartype;
    private float ratePerKm;
    private String driver;
	public int getCabId() {
		return cabId;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public String getCartype() {
	  return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public float getRatePerKm() {
		return ratePerKm;
	}
	public void setRatePerKm(float ratePerKm) {
		this.ratePerKm = ratePerKm;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
    
    

}