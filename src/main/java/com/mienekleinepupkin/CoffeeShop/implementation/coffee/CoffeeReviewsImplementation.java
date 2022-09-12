package com.mienekleinepupkin.CoffeeShop.implementation.coffee;

import com.mienekleinepupkin.CoffeeShop.entity.coffee.Coffee;
import com.mienekleinepupkin.CoffeeShop.exception.ResourceNoContent;
import com.mienekleinepupkin.CoffeeShop.exception.ResourceNotFoundException;
import com.mienekleinepupkin.CoffeeShop.repository.coffee.CoffeeRepository;
import com.mienekleinepupkin.CoffeeShop.service.coffee.CoffeeReviewService;
import com.mienekleinepupkin.CoffeeShop.entity.coffee.CoffeeReviews;
import com.mienekleinepupkin.CoffeeShop.repository.coffee.CoffeeReviewsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeReviewsImplementation implements CoffeeReviewService {

  @Autowired
  private CoffeeReviewsRepository coffeeReviewsRepository;
  @Autowired
  private CoffeeRepository coffeeRepository;

  @Override
  public CoffeeReviews saveCoffeeReviews(CoffeeReviews coffeeReviews, Long id) {
    CoffeeReviews existingCoffeeReviews =  Optional.ofNullable(coffeeReviews)
        .orElseThrow(ResourceNoContent::new);
    Coffee existingCoffee = coffeeRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    existingCoffee.getCoffeeReviewsList().add(coffeeReviews);
    return coffeeReviewsRepository.save(existingCoffeeReviews);
  }

  @Override
  public List<CoffeeReviews> getAllCoffeeReviews(Long id) {
    Coffee existingCoffee = coffeeRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    return existingCoffee.getCoffeeReviewsList();
  }

  @Override
  public CoffeeReviews getCoffeeReviewsById(Long id) {
    return coffeeReviewsRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public CoffeeReviews updateCoffeeReviewById(CoffeeReviews coffeeReviews, Long id) {
    CoffeeReviews existingCoffeeReviews = coffeeReviewsRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    existingCoffeeReviews.setRaiting(coffeeReviews.getRaiting());
    existingCoffeeReviews.setContent(coffeeReviews.getContent());
    return coffeeReviewsRepository.save(existingCoffeeReviews);
  }

  @Override
  public String deleteCoffeeReviewById(Long id) {
    coffeeReviewsRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    coffeeReviewsRepository.deleteById(id);
    return "Successfully deleted";
  }
}
