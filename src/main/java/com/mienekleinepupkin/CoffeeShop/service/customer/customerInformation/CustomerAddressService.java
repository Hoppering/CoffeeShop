package com.mienekleinepupkin.CoffeeShop.service.customer.customerInformation;

import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerAddress;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CustomerAddressService {
  CustomerAddress saveCustomerAddress(CustomerAddress CustomerAddress, Long id);
  List<CustomerAddress> getAllCustomerAddresses(Long id);
  CustomerAddress getCustomerAddressById(Long id);
  CustomerAddress updateCustomerAddressById(CustomerAddress customerAddress, Long id);
  String deleteCustomerAddressById(Long id);

}
