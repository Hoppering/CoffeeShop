package com.mienekleinepupkin.CoffeeShop.repository.coffee;

import com.mienekleinepupkin.CoffeeShop.entity.coffee.CoffeeReviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoffeeReviewsRepository extends JpaRepository<CoffeeReviews, Long> {

}
