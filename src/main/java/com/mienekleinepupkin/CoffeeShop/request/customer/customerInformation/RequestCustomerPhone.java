package com.mienekleinepupkin.CoffeeShop.request.customer.customerInformation;

import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerPhone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestCustomerPhone {
  private CustomerPhone customerPhone;

}
