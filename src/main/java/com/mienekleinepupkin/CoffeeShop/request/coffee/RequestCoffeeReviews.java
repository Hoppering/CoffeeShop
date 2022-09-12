package com.mienekleinepupkin.CoffeeShop.request.coffee;

import com.mienekleinepupkin.CoffeeShop.entity.coffee.CoffeeReviews;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestCoffeeReviews {

  private CoffeeReviews coffeeReviews;
}
