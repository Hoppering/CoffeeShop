package com.mienekleinepupkin.CoffeeShop.repository.customer.customerInformation;

import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPhoneRepository extends JpaRepository<CustomerPhone, Long> {

}
