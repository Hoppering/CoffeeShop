package com.mienekleinepupkin.CoffeeShop.entity.coffee;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
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
@Entity(name = "Coffee")
@Table(name = "coffee")
public class Coffee {
  @Id
  @GeneratedValue
  private Long coffee_id;
  @Column(
      name = "country",
      nullable = false,
      columnDefinition = "varchar",
      length = 100
  )
  private String country;
  @Column(
      name = "acidity",
      nullable = false,
      columnDefinition = "smallint"
  )
  private int acidity;
  @Column(
      name = "density",
      nullable = false,
      columnDefinition = "smallint"
  )
  private int density;
  @Enumerated(EnumType.STRING)
  @Column(length = 10)
  private CoffeeMethodPreparation coffeeMethodPreparation;
  @Column(
      name = "treatment",
      nullable = false,
      columnDefinition = "varchar",
      length = 20
  )
  private String treatment;
  @Column(
      name = "content",
      nullable = false,
      columnDefinition = "text"
  )
  private String content;
  @Column(
      name = "size",
      nullable = false
  )
  private int size;
  @Column(
      name = "price",
      nullable = false
  )
  private int price;
  @Column(
      name = "amount",
      nullable = false
  )
  private int amount;
  @Column(
      name = "image",
      nullable = false,
      columnDefinition = "text"
  )
  private String image;

  @OneToMany(targetEntity = CoffeeReviews.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_reviews", referencedColumnName = "coffee_id")
  private List<CoffeeReviews> coffeeReviewsList;

}
