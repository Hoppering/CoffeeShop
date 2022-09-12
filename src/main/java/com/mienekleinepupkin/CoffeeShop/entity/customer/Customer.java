package com.mienekleinepupkin.CoffeeShop.entity.customer;

import com.mienekleinepupkin.CoffeeShop.entity.coffee.order.CoffeeOrder;
import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerAddress;
import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerEmail;
import com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation.CustomerPhone;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Customer")
@Table(name = "customer")
public class Customer {
  @Id
  @GeneratedValue
  private Long customer_id;
  @Column(
      name = "first_name",
      nullable = false,
      columnDefinition = "varchar",
      length = 20
  )
  private String firstName;
  @Column(
      name = "second_name",
      nullable = false,
      columnDefinition = "varchar",
      length = 20
  )
  private String secondName;

  @OneToMany(targetEntity = CustomerPhone.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_phone_number", referencedColumnName = "customer_id")
  private List<CustomerPhone> customerPhoneList;

  @OneToMany(targetEntity = CustomerEmail.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_email", referencedColumnName = "customer_id")
  private List<CustomerEmail> customerEmailList;

  @OneToMany(targetEntity = CustomerAddress.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_address", referencedColumnName = "customer_id")
  private List<CustomerAddress> customerAddressList;

  @OneToMany(targetEntity = CoffeeOrder.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_coffee_order", referencedColumnName = "customer_id")
  private List<CoffeeOrder> coffeeOrderList;
}
