package com.mienekleinepupkin.CoffeeShop.controller;

import com.mienekleinepupkin.CoffeeShop.entity.coffee.Coffee;
import com.mienekleinepupkin.CoffeeShop.entity.coffee.CoffeeReviews;
import com.mienekleinepupkin.CoffeeShop.request.coffee.RequestCoffee;
import com.mienekleinepupkin.CoffeeShop.request.coffee.RequestCoffeeReviews;
import com.mienekleinepupkin.CoffeeShop.service.coffee.CoffeeReviewService;
import com.mienekleinepupkin.CoffeeShop.service.coffee.CoffeeService;
import com.mienekleinepupkin.CoffeeShop.storage.StorageFile;
import java.io.File;
import java.io.IOException;
import java.util.List;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/coffee")
public class CoffeeController {

  @Autowired
  private CoffeeService coffeeService;
  @Autowired
  private CoffeeReviewService coffeeReviewService;
  @Autowired
  private StorageFile storageFile;

  @PostMapping("")
  public ResponseEntity<Coffee> addCoffee(
      @RequestBody RequestCoffee requestCoffee) {
    Coffee coffee = requestCoffee.getCoffee();
    return ResponseEntity.status(201)
        .body(coffeeService.saveCoffee(coffee));
  }

  @GetMapping("")
  public ResponseEntity<List<Coffee>> getAllCoffee() {
    return ResponseEntity.ok()
        .body(coffeeService.getAllCoffee());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Coffee> getCoffeeById(
      @PathVariable("id") Long id) {
    return ResponseEntity.ok()
        .body(coffeeService.getCoffeeById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Coffee> updateCoffeeById(
      @PathVariable("id") Long id,
      @RequestBody RequestCoffee requestCoffee) {
    Coffee coffee = requestCoffee.getCoffee();
    return ResponseEntity.status(202)
        .body(coffeeService.updateCoffeeById(coffee, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCoffeeById(
      @PathVariable("id") Long id) throws IOException {
    return ResponseEntity.ok()
        .body(coffeeService.deleteCoffeeById(id));
  }

  @PostMapping("/{id}/reviews")
  public ResponseEntity<CoffeeReviews> addReview(
      @PathVariable("id") Long id,
      @RequestBody RequestCoffeeReviews requestCoffeeReviews) {
    CoffeeReviews coffeeReviews = requestCoffeeReviews.getCoffeeReviews();
    return ResponseEntity.status(201)
        .body(coffeeReviewService.saveCoffeeReviews(coffeeReviews, id));
  }

  @GetMapping("/{id}/reviews")
  public ResponseEntity<List<CoffeeReviews>> getAllReviews(
      @PathVariable("id") Long id) {
    return ResponseEntity.ok()
        .body(coffeeReviewService.getAllCoffeeReviews(id));
  }

  @GetMapping("/reviews/{id}")
  public ResponseEntity<CoffeeReviews> getReviewById(
      @PathVariable("id") Long id) {
    return ResponseEntity.ok()
        .body(coffeeReviewService.getCoffeeReviewsById(id));
  }

  @PutMapping("/reviews/{id}")
  public ResponseEntity<CoffeeReviews> updateReviewById(
      @PathVariable("id") Long id,
      @RequestBody RequestCoffeeReviews requestCoffeeReviews) {
    CoffeeReviews coffeeReviews = requestCoffeeReviews.getCoffeeReviews();
    return ResponseEntity.status(202)
        .body(coffeeReviewService.updateCoffeeReviewById(coffeeReviews, id));
  }

  @DeleteMapping("/reviews/{id}")
  public ResponseEntity<String> deleteReviewById(
      @PathVariable("id") Long id) {
    return ResponseEntity.ok()
        .body(coffeeReviewService.deleteCoffeeReviewById(id));
  }

  @GetMapping("/images/{name}")
  public ResponseEntity<ByteArrayResource> getImageCoffee(
      @PathVariable("name") String name) throws IOException {
    File imageFile = storageFile.getFile(name);
    ByteArrayResource resource = storageFile.getFileByteArrayResource(name);
    return ResponseEntity.ok()
        .contentLength(imageFile.length())
        .contentType(MediaType.IMAGE_PNG)
        .body(resource);
  }

  @PostMapping("{id}/images")
  public ResponseEntity<Coffee> addImageCoffee(
      @PathVariable("id") Long id,
      @RequestParam("file") MultipartFile file
  ) throws IOException {
    return ResponseEntity.status(201)
        .body(coffeeService.saveCoffeeImageById(id, file));
  }

  @PutMapping("{id}/images")
  public ResponseEntity<Coffee> updateImageCoffee(
      @PathVariable("id") Long id,
      @RequestParam("file") MultipartFile file
  ) throws IOException {
    return ResponseEntity.status(202)
        .body(coffeeService.updateCoffeeImageById(id, file));
  }

  @DeleteMapping("{id}/images")
  public ResponseEntity<String> deleteImageCoffee(
      @PathVariable("id") Long id) throws IOException {
    return ResponseEntity.ok()
        .body(coffeeService.deleteCoffeeImageById(id));
  }
}
