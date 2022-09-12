package com.mienekleinepupkin.CoffeeShop.service.customer.customerInformation;

import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerPhone;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CustomerPhoneService {
  CustomerPhone saveCustomerPhone(CustomerPhone CustomerPhone, Long id);
  List<CustomerPhone> getAllCustomerPhones(Long id);
  CustomerPhone getCustomerPhoneById(Long id);
  CustomerPhone updateCustomerPhoneById(CustomerPhone CustomerPhone, Long id);
  String deleteCustomerPhoneById(Long id);

}
