package com.mienekleinepupkin.CoffeeShop.entity.coffee.order;

import com.mienekleinepupkin.CoffeeShop.entity.customer.Customer;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "CoffeeOrder")
@Table(name = "coffee_order")
public class CoffeeOrder {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long coffee_order_id;
  @Column(
      name = "total_price",
      nullable = false
  )
  private Long totalPrice;
  @Column(
      name = "date_add",
      nullable = false
  )
  private Date dateAdd;
  @Column(
      name = "date_update",
      nullable = false
  )
  private Date dateUpdate;

  @OneToMany(targetEntity = CoffeeOrderDetail.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_coffee_detail", referencedColumnName = "coffee_order_id")
  private List<CoffeeOrderDetail> CoffeeOrderDetailList;

}
