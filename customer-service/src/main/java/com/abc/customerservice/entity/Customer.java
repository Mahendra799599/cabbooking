package com.abc.customerservice.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer_tbl")
public class Customer {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int customerId;
 private String name;
 private String email;
 private  String customerjourneystatus;
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCustomerjourneystatus() {
	return customerjourneystatus;
}
public void setCustomerjourneystatus(String customerjourneystatus) {
	this.customerjourneystatus = customerjourneystatus;
}
 
}
