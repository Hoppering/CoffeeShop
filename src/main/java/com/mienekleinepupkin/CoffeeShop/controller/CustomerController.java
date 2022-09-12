package com.mienekleinepupkin.CoffeeShop.controller;

import com.mienekleinepupkin.CoffeeShop.entity.customer.Customer;
import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerAddress;
import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerEmail;
import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerPhone;
import com.mienekleinepupkin.CoffeeShop.request.customer.RequestCustomer;
import com.mienekleinepupkin.CoffeeShop.request.customer.customerInformation.RequestCustomerAddress;
import com.mienekleinepupkin.CoffeeShop.request.customer.customerInformation.RequestCustomerEmail;
import com.mienekleinepupkin.CoffeeShop.request.customer.customerInformation.RequestCustomerPhone;
import com.mienekleinepupkin.CoffeeShop.service.customer.CustomerService;
import com.mienekleinepupkin.CoffeeShop.service.customer.customerInformation.CustomerAddressService;
import com.mienekleinepupkin.CoffeeShop.service.customer.customerInformation.CustomerEmailService;
import com.mienekleinepupkin.CoffeeShop.service.customer.customerInformation.CustomerPhoneService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

  @Autowired
  private CustomerService customerService;
  @Autowired
  private CustomerAddressService customerAddressService;
  @Autowired
  private CustomerEmailService customerEmailService;
  @Autowired
  private CustomerPhoneService customerPhoneService;

  @PostMapping("")
  public ResponseEntity<Customer> addCustomer(@RequestBody RequestCustomer requestCustomer) {
    Customer customer = requestCustomer.getCustomer();
    System.out.println(customer);
    return ResponseEntity.status(201)
        .body(customerService.saveCustomer(customer));
  }

  @GetMapping("")
  public ResponseEntity<List<Customer>> getAllCustomers() {
    return ResponseEntity.ok()
        .body(customerService.getAllCustomers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Customer> getCustomerById(
      @PathVariable("id") Long id) {
    return ResponseEntity.ok()
        .body(customerService.getCustomerById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Customer> updateCustomerById(
      @PathVariable("id") Long id,
      @RequestBody RequestCustomer requestCustomer) {
    Customer customer = requestCustomer.getCustomer();
    return ResponseEntity.status(202)
        .body(customerService.updateCustomer(customer, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCustomerById(
      @PathVariable("id") Long id) {
    return ResponseEntity.ok()
        .body(customerService.deleteCustomer(id));
  }

  @PostMapping("/{id}/customerAddress")
  public ResponseEntity<CustomerAddress> addCustomerAddress(
      @PathVariable("id") Long id,
      @RequestBody RequestCustomerAddress requestCustomerAddress) {
    CustomerAddress customerAddress = requestCustomerAddress.getCustomerAddress();
    return ResponseEntity.status(201)
        .body(customerAddressService.saveCustomerAddress(customerAddress, id));
  }

  @GetMapping("/{id}/customerAddress")
  public ResponseEntity<List<CustomerAddress>> getAllCustomerAddresses(
      @PathVariable("id") Long id) {
    return ResponseEntity.ok()
        .body(customerAddressService.getAllCustomerAddresses(id));
  }

  @GetMapping("/customerAddress/{id_address}")
  public ResponseEntity<CustomerAddress> getCustomerAddressById(
      @PathVariable("id_address") Long id) {
    return ResponseEntity.ok()
        .body(customerAddressService.getCustomerAddressById(id));
  }

  @PutMapping("/customerAddress/{id_address}")
  public ResponseEntity<CustomerAddress> updateCustomerAddressById(
      @PathVariable("id_address") Long id,
      @RequestBody RequestCustomerAddress requestCustomerAddress) {
    CustomerAddress customerAddress = requestCustomerAddress.getCustomerAddress();
    return ResponseEntity.status(202)
        .body(customerAddressService.updateCustomerAddressById(customerAddress, id));
  }

  @DeleteMapping("/customerAddress/{id_address}")
  public ResponseEntity<String> deleteCustomerAddressById(
      @PathVariable("id_address") Long id) {
    return ResponseEntity.ok()
        .body(customerAddressService.deleteCustomerAddressById(id));
  }

  @PostMapping("/{id}/customerEmail")
  public ResponseEntity<CustomerEmail> addCustomerEmail(
      @PathVariable("id") Long id,
      @RequestBody RequestCustomerEmail requestCustomerEmail) {
    CustomerEmail customerEmail = requestCustomerEmail.getCustomerEmail();
    return ResponseEntity.status(201)
        .body(customerEmailService.saveCustomerEmail(customerEmail, id));
  }

  @GetMapping("/{id}/customerEmail")
  public ResponseEntity<List<CustomerEmail>> getAllCustomerEmail(
      @PathVariable("id") Long id) {
    return ResponseEntity.ok()
        .body(customerEmailService.getAllCustomerEmails(id));
  }

  @GetMapping("/customerEmail/{id_email}")
  public ResponseEntity<CustomerEmail> getCustomerEmailById(
      @PathVariable("id_email") Long id) {
    return ResponseEntity.ok()
        .body(customerEmailService.getCustomerEmailById(id));
  }

  @PutMapping("/customerEmail/{id_email}")
  public ResponseEntity<CustomerEmail> updateCustomerEmailById(
      @PathVariable("id_email") Long id,
      @RequestBody RequestCustomerEmail requestCustomerEmail) {
    CustomerEmail customerEmail = requestCustomerEmail.getCustomerEmail();
    return ResponseEntity.status(202)
        .body(customerEmailService.updateCustomerEmailById(customerEmail, id));
  }

  @DeleteMapping("/customerEmail/{id_Email}")
  public ResponseEntity<String> deleteCustomerEmailById(
      @PathVariable("id_Email") Long id) {
    return ResponseEntity.ok()
        .body(customerEmailService.deleteCustomerEmailById(id));
  }

  @PostMapping("/{id}/customerPhone")
  public ResponseEntity<CustomerPhone> addCustomerPhone(
      @PathVariable("id") Long id,
      @RequestBody RequestCustomerPhone requestCustomerPhone) {
    CustomerPhone customerPhone = requestCustomerPhone.getCustomerPhone();
    return ResponseEntity.status(201)
        .body(customerPhoneService.saveCustomerPhone(customerPhone, id));
  }

  @GetMapping("/{id}/customerPhone")
  public ResponseEntity<List<CustomerPhone>> getAllCustomerPhone(
      @PathVariable("id") Long id) {
    return ResponseEntity.ok()
        .body(customerPhoneService.getAllCustomerPhones(id));
  }

  @GetMapping("/customerPhone/{id_Phone}")
  public ResponseEntity<CustomerPhone> getCustomerPhoneById(
      @PathVariable("id_Phone") Long id) {
    return ResponseEntity.ok()
        .body(customerPhoneService.getCustomerPhoneById(id));
  }

  @PutMapping("/customerPhone/{id_Phone}")
  public ResponseEntity<CustomerPhone> updateCustomerPhoneById(
      @PathVariable("id_Phone") Long id,
      @RequestBody RequestCustomerPhone requestCustomerPhone) {
    CustomerPhone customerPhone = requestCustomerPhone.getCustomerPhone();
    return ResponseEntity.status(202)
        .body(customerPhoneService.updateCustomerPhoneById(customerPhone, id));
  }

  @DeleteMapping("/customerPhone/{id_Phone}")
  public ResponseEntity<String> deleteCustomerPhoneById(
      @PathVariable("id_Phone") Long id) {
    return ResponseEntity.ok()
        .body(customerPhoneService.deleteCustomerPhoneById(id));
  }
}
