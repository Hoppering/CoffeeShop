package com.mienekleinepupkin.CoffeeShop.request.coffee.order;

import com.mienekleinepupkin.CoffeeShop.entity.coffee.order.CoffeeOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestCoffeeOrder {
private CoffeeOrder coffeeOrder;
}
