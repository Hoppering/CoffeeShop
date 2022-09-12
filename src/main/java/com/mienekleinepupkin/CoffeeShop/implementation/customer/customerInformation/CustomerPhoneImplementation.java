package com.mienekleinepupkin.CoffeeShop.implementation.customer.customerInformation;

import com.mienekleinepupkin.CoffeeShop.entity.customer.Customer;
import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerPhone;
import com.mienekleinepupkin.CoffeeShop.exception.ResourceNoContent;
import com.mienekleinepupkin.CoffeeShop.exception.ResourceNotFoundException;
import com.mienekleinepupkin.CoffeeShop.repository.customer.CustomerRepository;
import com.mienekleinepupkin.CoffeeShop.service.customer.customerInformation.CustomerPhoneService;
import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerPhone;
import com.mienekleinepupkin.CoffeeShop.repository.customer.customerInformation.CustomerPhoneRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerPhoneImplementation implements CustomerPhoneService {

  @Autowired
  private CustomerPhoneRepository customerPhoneRepository;
  @Autowired
  private CustomerRepository customerRepository;

  public CustomerPhone saveCustomerPhone(CustomerPhone customerPhone, Long id) {
    CustomerPhone existingCustomerPhone = Optional.ofNullable(customerPhone)
        .orElseThrow(ResourceNoContent::new);
    Customer existingCustomer = customerRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    existingCustomer.getCustomerPhoneList().add(customerPhone);
    return customerPhoneRepository.save(existingCustomerPhone);
  }

  @Override
  public List<CustomerPhone> getAllCustomerPhones(Long id) {
    Customer existingCustomer = customerRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    return existingCustomer.getCustomerPhoneList();
  }

  @Override
  public CustomerPhone getCustomerPhoneById(Long id) {
    return customerPhoneRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public CustomerPhone updateCustomerPhoneById(CustomerPhone customerPhone, Long id) {
    CustomerPhone existingCustomerPhone = customerPhoneRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    existingCustomerPhone.setPhone(customerPhone.getPhone());
    return customerPhoneRepository.save(existingCustomerPhone);
  }

  @Override
  public String deleteCustomerPhoneById(Long id) {
    customerPhoneRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    customerPhoneRepository.deleteById(id);
    return "Successfully deleted";
  }
}
