package com.mienekleinepupkin.CoffeeShop.entity.customer.customerInformation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "CustomerAddress")
@Table(name = "customer_address")
public class CustomerAddress {
  @Id
  @GeneratedValue
  private Long address_id;
  @Column(
      name = "address",
      nullable = false,
      columnDefinition = "text"
  )
  private String address;

}
