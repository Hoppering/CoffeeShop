package com.mienekleinepupkin.CoffeeShop.repository.customer.customerInformation;

import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long> {

}
