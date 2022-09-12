package com.mienekleinepupkin.CoffeeShop.service.coffee.order;

import com.mienekleinepupkin.CoffeeShop.entity.coffee.order.CoffeeOrderDetail;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CoffeeOrderDetailService {
  CoffeeOrderDetail saveCoffeeOrderDetail(CoffeeOrderDetail CoffeeOrderDetail, Long id_coffee, Long id_coffeeOrder);
  List<CoffeeOrderDetail> getAllCoffeeOrderDetails();
  CoffeeOrderDetail getCoffeeOrderDetailById(Long id);
  CoffeeOrderDetail updateCoffeeOrderDetailById(CoffeeOrderDetail Coffee, Long id);
  String deleteCoffeeOrderDetailById(Long id);

}
