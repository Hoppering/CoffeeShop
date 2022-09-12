package com.mienekleinepupkin.CoffeeShop.request.customer;

import com.mienekleinepupkin.CoffeeShop.entity.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestCustomer {
  private Customer customer;
}
