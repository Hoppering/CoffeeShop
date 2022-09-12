package com.mienekleinepupkin.CoffeeShop.implementation.customer.customerInformation;

import com.mienekleinepupkin.CoffeeShop.entity.customer.Customer;
import com.mienekleinepupkin.CoffeeShop.exception.ResourceNoContent;
import com.mienekleinepupkin.CoffeeShop.exception.ResourceNotFoundException;
import com.mienekleinepupkin.CoffeeShop.repository.customer.CustomerRepository;
import com.mienekleinepupkin.CoffeeShop.service.customer.customerInformation.CustomerAddressService;
import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerAddress;
import com.mienekleinepupkin.CoffeeShop.repository.customer.customerInformation.CustomerAddressRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerAddressImplementation implements CustomerAddressService {

  @Autowired
  private CustomerAddressRepository customerAddressRepository;
  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public CustomerAddress saveCustomerAddress(CustomerAddress customerAddress, Long id) {
    CustomerAddress existingCustomerAddress = Optional.ofNullable(customerAddress)
        .orElseThrow(ResourceNoContent::new);
    Customer existingCustomer = customerRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    existingCustomer.getCustomerAddressList().add(customerAddress);
    return customerAddressRepository.save(existingCustomerAddress);
  }

  @Override
  public List<CustomerAddress> getAllCustomerAddresses(Long id) {
    Customer existingCustomer = customerRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    return existingCustomer.getCustomerAddressList();
  }

  @Override
  public CustomerAddress getCustomerAddressById(Long id) {
    return customerAddressRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public CustomerAddress updateCustomerAddressById(CustomerAddress customerAddress, Long id) {
    CustomerAddress existingCustomerAddress = customerAddressRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    existingCustomerAddress.setAddress(customerAddress.getAddress());
    return customerAddressRepository.save(existingCustomerAddress);
  }

  @Override
  public String deleteCustomerAddressById(Long id) {
    customerAddressRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    customerAddressRepository.deleteById(id);
    return "Successfully deleted";
  }
}
