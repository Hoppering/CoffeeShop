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
@Entity(name = "CustomerPhone")
@Table(name = "customer_phone")
public class CustomerPhone {
  @Id
  @GeneratedValue
  private Long phone_id;
  @Column(
      name = "phone",
      nullable = false,
      columnDefinition = "varchar",
      length = 15
  )
  private String phone;

}
