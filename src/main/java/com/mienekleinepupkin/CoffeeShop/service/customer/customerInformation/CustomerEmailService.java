package com.mienekleinepupkin.CoffeeShop.service.customer.customerInformation;

import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerEmail;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CustomerEmailService {
  CustomerEmail saveCustomerEmail(CustomerEmail customerEmail, Long id);
  List<CustomerEmail> getAllCustomerEmails(Long id);
  CustomerEmail getCustomerEmailById(Long id);
  CustomerEmail updateCustomerEmailById(CustomerEmail CustomerEmail, Long id);
  String deleteCustomerEmailById(Long id);
}
