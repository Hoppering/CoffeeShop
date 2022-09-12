package com.mienekleinepupkin.CoffeeShop.implementation.coffee.order;

import com.mienekleinepupkin.CoffeeShop.entity.coffee.Coffee;
import com.mienekleinepupkin.CoffeeShop.entity.coffee.order.CoffeeOrder;
import com.mienekleinepupkin.CoffeeShop.exception.ResourceNoContent;
import com.mienekleinepupkin.CoffeeShop.exception.ResourceNotFoundException;
import com.mienekleinepupkin.CoffeeShop.repository.coffee.CoffeeRepository;
import com.mienekleinepupkin.CoffeeShop.repository.coffee.order.CoffeeOrderRepository;
import com.mienekleinepupkin.CoffeeShop.service.coffee.order.CoffeeOrderDetailService;
import com.mienekleinepupkin.CoffeeShop.entity.coffee.order.CoffeeOrderDetail;
import com.mienekleinepupkin.CoffeeShop.repository.coffee.order.CoffeeOrderDetailRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeOrderDetailImplementation implements CoffeeOrderDetailService {

  @Autowired
  private CoffeeOrderDetailRepository coffeeOrderDetailRepository;
  @Autowired
  private CoffeeOrderRepository coffeeOrderRepository;
  @Autowired
  private CoffeeRepository coffeeRepository;

  @Override
  public CoffeeOrderDetail saveCoffeeOrderDetail(CoffeeOrderDetail coffeeOrderDetail,
      Long id_coffee, Long id_coffeeOrder) {
    CoffeeOrderDetail existingCoffeeOrderDetail = Optional.ofNullable(coffeeOrderDetail)
        .orElseThrow(ResourceNoContent::new);
    Coffee existingCoffee = coffeeRepository.findById(id_coffee)
        .orElseThrow(ResourceNotFoundException::new);
    CoffeeOrder existingCoffeeOrder = coffeeOrderRepository.findById(id_coffeeOrder)
        .orElseThrow(ResourceNotFoundException::new);
    existingCoffeeOrderDetail.setCoffee(existingCoffee);
    existingCoffeeOrder.getCoffeeOrderDetailList().add(existingCoffeeOrderDetail);
    return coffeeOrderDetailRepository.save(existingCoffeeOrderDetail);
  }

  @Override
  public List<CoffeeOrderDetail> getAllCoffeeOrderDetails() {
    return coffeeOrderDetailRepository.findAll();
  }

  @Override
  public CoffeeOrderDetail getCoffeeOrderDetailById(Long id) {
    return coffeeOrderDetailRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public CoffeeOrderDetail updateCoffeeOrderDetailById(CoffeeOrderDetail coffee, Long id) {
    CoffeeOrderDetail existingCoffeeOrderDetail = coffeeOrderDetailRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    existingCoffeeOrderDetail.setAmount(coffee.getAmount());
    return coffeeOrderDetailRepository.save(existingCoffeeOrderDetail);
  }

  @Override
  public String deleteCoffeeOrderDetailById(Long id) {
    coffeeOrderDetailRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    coffeeOrderDetailRepository.deleteById(id);
    return "Successfully deleted";
  }
}
