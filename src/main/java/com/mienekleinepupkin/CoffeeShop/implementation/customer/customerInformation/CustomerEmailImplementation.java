package com.mienekleinepupkin.CoffeeShop.implementation.customer.customerInformation;

import com.mienekleinepupkin.CoffeeShop.entity.customer.Customer;
import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerEmail;
import com.mienekleinepupkin.CoffeeShop.exception.ResourceNoContent;
import com.mienekleinepupkin.CoffeeShop.exception.ResourceNotFoundException;
import com.mienekleinepupkin.CoffeeShop.repository.customer.CustomerRepository;
import com.mienekleinepupkin.CoffeeShop.service.customer.customerInformation.CustomerEmailService;
import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerEmail;
import com.mienekleinepupkin.CoffeeShop.repository.customer.customerInformation.CustomerEmailRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerEmailImplementation implements CustomerEmailService {

  @Autowired
  private CustomerEmailRepository customerEmailRepository;
  @Autowired
  private CustomerRepository customerRepository;

  public CustomerEmail saveCustomerEmail(CustomerEmail customerEmail, Long id) {
    CustomerEmail existingCustomerEmail = Optional.ofNullable(customerEmail)
        .orElseThrow(ResourceNoContent::new);
    Customer existingCustomer = customerRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    existingCustomer.getCustomerEmailList().add(customerEmail);
    return customerEmailRepository.save(existingCustomerEmail);
  }

  @Override
  public List<CustomerEmail> getAllCustomerEmails(Long id) {
    Customer existingCustomer = customerRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    return existingCustomer.getCustomerEmailList();
  }

  @Override
  public CustomerEmail getCustomerEmailById(Long id) {
    return customerEmailRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public CustomerEmail updateCustomerEmailById(CustomerEmail customerEmail, Long id) {
    CustomerEmail existingCustomerEmail = customerEmailRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    existingCustomerEmail.setEmail(customerEmail.getEmail());
    return customerEmailRepository.save(existingCustomerEmail);
  }

  @Override
  public String deleteCustomerEmailById(Long id) {
    customerEmailRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    customerEmailRepository.deleteById(id);
    return "Successfully deleted";
  }
}
