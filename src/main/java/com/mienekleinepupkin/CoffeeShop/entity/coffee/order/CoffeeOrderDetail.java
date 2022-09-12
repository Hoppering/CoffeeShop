package com.mienekleinepupkin.CoffeeShop.entity.coffee.order;

import com.mienekleinepupkin.CoffeeShop.entity.coffee.Coffee;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "CoffeeOrderDetail")
@Table(name = "coffee_order_detail")
public class CoffeeOrderDetail {
  @Id
  @GeneratedValue
  private Long coffee_detail_id;
  @Column(
      name = "amount",
      nullable = false
  )
  private int amount;

  @OneToOne(targetEntity = Coffee.class, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "fk_coffee", referencedColumnName = "coffee_id")
  private Coffee Coffee;

}
