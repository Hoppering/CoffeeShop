package com.mienekleinepupkin.CoffeeShop.request.coffee;

import com.mienekleinepupkin.CoffeeShop.entity.coffee.Coffee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestCoffee {
  private Coffee coffee;
}
