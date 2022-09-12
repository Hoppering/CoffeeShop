package com.mienekleinepupkin.CoffeeShop.repository.customer.customerInformation;

import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerEmailRepository extends JpaRepository<CustomerEmail, Long> {

}
