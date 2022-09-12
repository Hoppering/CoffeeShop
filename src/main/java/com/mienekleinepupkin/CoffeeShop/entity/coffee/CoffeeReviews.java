package com.mienekleinepupkin.CoffeeShop.entity.coffee;

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
@Entity(name = "CoffeeReviews")
@Table(name = "coffee_reviews")
public class CoffeeReviews {
  @Id
  @GeneratedValue
  private Long review_id;
  @Column(
      name = "username",
      nullable = false,
      columnDefinition = "varchar",
      length = 100
  )
  private String username;
  @Column(
      name = "raiting",
      nullable = false,
      columnDefinition = "smallint"
  )
  private int raiting;
  @Column(
      name = "content",
      nullable = false,
      columnDefinition = "text"
  )
  private String content;
}
