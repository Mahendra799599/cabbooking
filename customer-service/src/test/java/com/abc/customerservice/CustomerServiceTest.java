package com.abc.customerservice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.customerservice.entity.Customer;
import com.abc.customerservice.repository.CustomerRepository;
import com.abc.customerservice.service.CustomerServiceImpl;

@SpringBootTest(properties = "eureka.client.enabled=false")
public class CustomerServiceTest {

    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void testGetAllCustomers() {
        Customer customer1 = new Customer();
        customer1.setCustomerId(1);
        customer1.setName("John");
        customer1.setEmail("john@example.com");
        customer1.setCustomerjourneystatus("Onboard");

        Customer customer2 = new Customer();
        customer2.setCustomerId(2);
        customer2.setName("Alice");
        customer2.setEmail("alice@example.com");
        customer2.setCustomerjourneystatus("Offboard");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> customerList = customerServiceImpl.getAllCustomers();
        assertEquals(2, customerList.size());
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setName("John");
        customer.setEmail("john@example.com");
        customer.setCustomerjourneystatus("Onboard");

        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        Customer foundCustomer = customerServiceImpl.getCustomerById(1);
        assertNotNull(foundCustomer);
        assertEquals(customer, foundCustomer);
    }

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setName("John");
        customer.setEmail("john@example.com");
        customer.setCustomerjourneystatus("Onboard");

        when(customerRepository.save(customer)).thenReturn(customer);

        Customer savedCustomer = customerServiceImpl.addCustomer(customer);
        assertNotNull(savedCustomer);
        assertEquals(customer, savedCustomer);
    }

    @Test
    public void testUpdateCustomer() {
        Customer existingCustomer = new Customer();
        existingCustomer.setCustomerId(1);
        existingCustomer.setName("John");
        existingCustomer.setEmail("john@example.com");
        existingCustomer.setCustomerjourneystatus("Onboard");

        Customer updatedCustomer = new Customer();
        updatedCustomer.setCustomerId(1);
        updatedCustomer.setName("John Doe");
        updatedCustomer.setEmail("johndoe@example.com");
        updatedCustomer.setCustomerjourneystatus("Offboard");

        when(customerRepository.findById(1)).thenReturn(Optional.of(existingCustomer));
        when(customerRepository.save(existingCustomer)).thenReturn(updatedCustomer);

        Customer returnedCustomer = customerServiceImpl.updateCustomer(1, updatedCustomer);
        assertNotNull(returnedCustomer);
        assertEquals(updatedCustomer, returnedCustomer);
    }

    @Test
    public void testDeleteCustomer() {
        doNothing().when(customerRepository).deleteById(1);
        customerServiceImpl.deleteCustomer(1);
        verify(customerRepository, times(1)).deleteById(1);
    }

   
}
