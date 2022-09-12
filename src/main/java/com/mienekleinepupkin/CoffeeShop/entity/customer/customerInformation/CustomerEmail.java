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
@Entity(name = "CustomerEmail")
@Table(name = "customer_email")
public class CustomerEmail {
  @Id
  @GeneratedValue
  private Long email_id;
  @Column(
      name = "email",
      nullable = false,
      columnDefinition = "text"
  )
  private String email;

}
