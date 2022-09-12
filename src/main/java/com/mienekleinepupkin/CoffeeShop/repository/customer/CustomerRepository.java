package com.mienekleinepupkin.CoffeeShop.repository.customer;

import com.mienekleinepupkin.CoffeeShop.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
