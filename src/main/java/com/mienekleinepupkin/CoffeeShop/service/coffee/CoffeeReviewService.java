package com.mienekleinepupkin.CoffeeShop.service.coffee;
import com.mienekleinepupkin.CoffeeShop.entity.coffee.CoffeeReviews;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CoffeeReviewService {
  CoffeeReviews saveCoffeeReviews(CoffeeReviews CoffeeReviews, Long id);
  List<CoffeeReviews> getAllCoffeeReviews(Long id);
  CoffeeReviews getCoffeeReviewsById(Long id);
  CoffeeReviews updateCoffeeReviewById(CoffeeReviews CoffeeReviews, Long id);
  String deleteCoffeeReviewById(Long id);

}
