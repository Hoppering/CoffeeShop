package com.mienekleinepupkin.CoffeeShop.service.coffee;

import com.mienekleinepupkin.CoffeeShop.entity.coffee.Coffee;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface CoffeeService {

  Coffee saveCoffee(Coffee Coffee);

  Coffee saveCoffeeImageById(Long id, MultipartFile file) throws IOException;

  Coffee updateCoffeeImageById(Long id, MultipartFile file) throws IOException;

  String deleteCoffeeImageById(Long id) throws IOException;

  List<Coffee> getAllCoffee();

  Coffee getCoffeeById(Long id);

  Coffee updateCoffeeById(Coffee Coffee, Long id);

  String deleteCoffeeById(Long id) throws IOException;


}
