package com.mienekleinepupkin.CoffeeShop.implementation.coffee.order;

import com.mienekleinepupkin.CoffeeShop.entity.customer.Customer;
import com.mienekleinepupkin.CoffeeShop.exception.ResourceNoContent;
import com.mienekleinepupkin.CoffeeShop.exception.ResourceNotFoundException;
import com.mienekleinepupkin.CoffeeShop.repository.customer.CustomerRepository;
import com.mienekleinepupkin.CoffeeShop.service.coffee.order.CoffeeOrderService;
import com.mienekleinepupkin.CoffeeShop.entity.coffee.order.CoffeeOrder;
import com.mienekleinepupkin.CoffeeShop.repository.coffee.order.CoffeeOrderRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeOrderImplementation implements CoffeeOrderService {

  @Autowired
  private CoffeeOrderRepository coffeeOrderRepository;
  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public CoffeeOrder saveCoffeeOrder(CoffeeOrder coffeeOrder, Long id) {
    CoffeeOrder existingCoffeeOrder = Optional.ofNullable(coffeeOrder)
        .orElseThrow(ResourceNoContent::new);
    Customer existingCustomer = customerRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    existingCustomer.getCoffeeOrderList().add(existingCoffeeOrder);
    Date date = new Date();
    existingCoffeeOrder.setDateAdd(date);
    existingCoffeeOrder.setDateUpdate(date);
    return coffeeOrderRepository.save(existingCoffeeOrder);
  }

  @Override
  public List<CoffeeOrder> getAllCoffeeOrders() {
    return coffeeOrderRepository.findAll();
  }

  @Override
  public CoffeeOrder getCoffeeOrderById(Long id) {
    return coffeeOrderRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public CoffeeOrder updateCoffeeOrderById(CoffeeOrder coffeeOrder, Long id) {
    CoffeeOrder existingCoffeeOrder = coffeeOrderRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    existingCoffeeOrder.setTotalPrice(coffeeOrder.getTotalPrice());
    Date date = new Date();
    existingCoffeeOrder.setDateUpdate(date);
    return coffeeOrderRepository.save(existingCoffeeOrder);
  }

  @Override
  public String deleteCoffeeOrderById(Long id) {
    coffeeOrderRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    coffeeOrderRepository.deleteById(id);
    return "Successfully deleted";
  }
}
