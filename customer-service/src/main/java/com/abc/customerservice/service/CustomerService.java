package com.abc.customerservice.service;


import com.abc.customerservice.entity.Customer;

import java.util.List;

public interface CustomerService {

 List<Customer> getAllCustomers();

 Customer getCustomerById(int id);

 Customer addCustomer(Customer customer);

 Customer updateCustomer(int id, Customer customer);

 void deleteCustomer(int id);
}
