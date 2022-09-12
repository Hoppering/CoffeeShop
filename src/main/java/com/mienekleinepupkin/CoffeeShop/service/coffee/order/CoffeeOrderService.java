package com.mienekleinepupkin.CoffeeShop.service.coffee.order;

import com.mienekleinepupkin.CoffeeShop.entity.coffee.order.CoffeeOrder;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CoffeeOrderService {
  CoffeeOrder saveCoffeeOrder(CoffeeOrder coffeeOrder, Long id);
  List<CoffeeOrder> getAllCoffeeOrders();
  CoffeeOrder getCoffeeOrderById(Long id);
  CoffeeOrder updateCoffeeOrderById(CoffeeOrder Coffee, Long id);
  String deleteCoffeeOrderById(Long id);

}
