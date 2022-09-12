package com.mienekleinepupkin.CoffeeShop.implementation.customer;

import com.mienekleinepupkin.CoffeeShop.exception.ResourceNoContent;
import com.mienekleinepupkin.CoffeeShop.exception.ResourceNotFoundException;
import com.mienekleinepupkin.CoffeeShop.service.customer.CustomerService;
import com.mienekleinepupkin.CoffeeShop.entity.customer.Customer;
import com.mienekleinepupkin.CoffeeShop.repository.customer.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImplementation implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public Customer saveCustomer(Customer customer) {
    Customer existingCustomer = Optional.ofNullable(customer)
        .orElseThrow(ResourceNoContent::new);
    return customerRepository.save(existingCustomer);
  }

  @Override
  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  @Override
  public Customer getCustomerById(Long id) {
    return customerRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public Customer updateCustomer(Customer customer, Long id) {
    Customer existingCustomer = customerRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    existingCustomer.setFirstName(customer.getFirstName());
    existingCustomer.setSecondName(customer.getSecondName());
    return customerRepository.save(existingCustomer);
  }

  @Override
  public String deleteCustomer(Long id) {
    customerRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    customerRepository.deleteById(id);
    return "Successfully deleted";
  }
}
