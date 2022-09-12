package com.mienekleinepupkin.CoffeeShop.controller;

import com.mienekleinepupkin.CoffeeShop.entity.coffee.order.CoffeeOrder;
import com.mienekleinepupkin.CoffeeShop.entity.coffee.order.CoffeeOrderDetail;
import com.mienekleinepupkin.CoffeeShop.request.coffee.order.RequestCoffeeOrder;
import com.mienekleinepupkin.CoffeeShop.request.coffee.order.RequestCoffeeOrderDetail;
import com.mienekleinepupkin.CoffeeShop.service.coffee.order.CoffeeOrderDetailService;
import com.mienekleinepupkin.CoffeeShop.service.coffee.order.CoffeeOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/order")
public class OrderController {

  @Autowired
  private CoffeeOrderService coffeeOrderService;
  @Autowired
  private CoffeeOrderDetailService coffeeOrderDetailService;

  @PostMapping("/customer/{id}")
  public ResponseEntity<CoffeeOrder> addCoffeeOrder(
      @PathVariable("id") Long id,
      @RequestBody RequestCoffeeOrder requestCoffeeOrder) {
    CoffeeOrder coffeeOrder = requestCoffeeOrder.getCoffeeOrder();
    return ResponseEntity.status(201)
        .body(coffeeOrderService.saveCoffeeOrder(coffeeOrder, id));
  }

  @GetMapping("")
  public ResponseEntity<List<CoffeeOrder>> getAllCoffeeOrder() {
    return ResponseEntity.ok()
        .body(coffeeOrderService.getAllCoffeeOrders());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CoffeeOrder> getCoffeeOrderById(
      @PathVariable("id") Long id) {
    return ResponseEntity.ok()
        .body(coffeeOrderService.getCoffeeOrderById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<CoffeeOrder> updateCoffeeOrderById(
      @PathVariable("id") Long id,
      @RequestBody RequestCoffeeOrder requestCoffeeOrder) {
    CoffeeOrder coffeeOrder = requestCoffeeOrder.getCoffeeOrder();
    return ResponseEntity.status(202)
        .body(coffeeOrderService.updateCoffeeOrderById(coffeeOrder, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCoffeeOrderById(
      @PathVariable(value = "id") Long id) {
    return ResponseEntity.ok()
        .body(coffeeOrderService.deleteCoffeeOrderById(id));
  }

  @PostMapping("{id_coffeeOrder}/coffee/{id_coffee}")
  public ResponseEntity<CoffeeOrderDetail> saveCoffeeOrderDetail(
      @PathVariable(value = "id_coffeeOrder") Long id_coffeeOrder,
      @PathVariable(value = "id_coffee") Long id_coffee,
      @RequestBody RequestCoffeeOrderDetail requestCoffeeOrderDetail) {
    CoffeeOrderDetail coffeeOrderDetail = requestCoffeeOrderDetail.getCoffeeOrderDetail();
    return ResponseEntity.status(201)
        .body(coffeeOrderDetailService.saveCoffeeOrderDetail(coffeeOrderDetail, id_coffee,
            id_coffeeOrder));
  }

  @GetMapping("/detail")
  public ResponseEntity<List<CoffeeOrderDetail>> getAllCoffeeOrderDetail() {
    return ResponseEntity.ok()
        .body(coffeeOrderDetailService.getAllCoffeeOrderDetails());
  }

  @GetMapping("/detail/{id}")
  public ResponseEntity<CoffeeOrderDetail> getCoffeeOrderDetailById(
      @PathVariable("id") Long id) {
    return ResponseEntity.ok()
        .body(coffeeOrderDetailService.getCoffeeOrderDetailById(id));
  }

  @PutMapping("/detail/{id}")
  public ResponseEntity<CoffeeOrderDetail> updateCoffeeOrderDetailById(
      @PathVariable("id") Long id,
      @RequestBody RequestCoffeeOrderDetail requestCoffeeOrderDetail) {
    CoffeeOrderDetail coffeeOrderDetail = requestCoffeeOrderDetail.getCoffeeOrderDetail();
    return ResponseEntity.status(202)
        .body(coffeeOrderDetailService.updateCoffeeOrderDetailById(coffeeOrderDetail, id));
  }

  @DeleteMapping("/detail/{id}")
  public ResponseEntity<String> deleteCoffeeOrderDetailById(
      @PathVariable("id") Long id) {
    return ResponseEntity.ok()
        .body(coffeeOrderDetailService.deleteCoffeeOrderDetailById(id));
  }
}
