package com.mienekleinepupkin.CoffeeShop.service.customer;

import com.mienekleinepupkin.CoffeeShop.entity.customer.Customer;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
  Customer saveCustomer(Customer customer);
  List<Customer> getAllCustomers();
  Customer getCustomerById(Long id);
  Customer updateCustomer(Customer customer, Long id);
  String deleteCustomer(Long id);

}
