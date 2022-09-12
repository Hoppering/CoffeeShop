package com.mienekleinepupkin.CoffeeShop.implementation.coffee;

import com.mienekleinepupkin.CoffeeShop.exception.ResourceNoContent;
import com.mienekleinepupkin.CoffeeShop.exception.ResourceNotFoundException;
import com.mienekleinepupkin.CoffeeShop.service.coffee.CoffeeService;
import com.mienekleinepupkin.CoffeeShop.entity.coffee.Coffee;
import com.mienekleinepupkin.CoffeeShop.repository.coffee.CoffeeRepository;
import com.mienekleinepupkin.CoffeeShop.storage.StorageFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CoffeeImplementation implements CoffeeService {

  @Autowired
  private CoffeeRepository coffeeRepository;
  @Autowired
  private StorageFile storageFile;

  @Override
  public Coffee saveCoffee(Coffee coffee) {
    Coffee existingCoffee = Optional.ofNullable(coffee)
        .orElseThrow(ResourceNoContent::new);
    return coffeeRepository.save(existingCoffee);
  }

  @Override
  public List<Coffee> getAllCoffee() {
    return coffeeRepository.findAll();
  }

  @Override
  public Coffee getCoffeeById(Long id) {
    return coffeeRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public Coffee updateCoffeeById(Coffee coffee, Long id) {
    Coffee existingCoffee = coffeeRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    existingCoffee.setCountry(coffee.getCountry());
    existingCoffee.setAcidity(coffee.getAcidity());
    existingCoffee.setDensity(coffee.getDensity());
    existingCoffee.setCoffeeMethodPreparation(coffee.getCoffeeMethodPreparation());
    existingCoffee.setTreatment(coffee.getTreatment());
    existingCoffee.setContent(coffee.getContent());
    existingCoffee.setPrice(coffee.getPrice());
    existingCoffee.setSize(coffee.getSize());
    existingCoffee.setAmount(coffee.getAmount());
    return coffeeRepository.save(existingCoffee);
  }

  @Override
  public String deleteCoffeeById(Long id) throws IOException {
    Coffee existingCoffee = coffeeRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    storageFile.deleteFile(existingCoffee.getImage());
    coffeeRepository.deleteById(id);
    return "Successfully deleted";
  }

  @Override
  public Coffee saveCoffeeImageById(Long id, MultipartFile file) throws IOException {
    Coffee existingCoffee = coffeeRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    Optional.ofNullable(file)
        .orElseThrow(ResourceNoContent::new);
    existingCoffee.setImage(storageFile.saveFile(file));
    return coffeeRepository.save(existingCoffee);
  }

  @Override
  public Coffee updateCoffeeImageById(Long id, MultipartFile file) throws IOException {
    Coffee existingCoffee = coffeeRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    Optional.ofNullable(file)
        .orElseThrow(ResourceNoContent::new);
    storageFile.deleteFile(existingCoffee.getImage());
    existingCoffee.setImage(storageFile.saveFile(file));
    return coffeeRepository.save(existingCoffee);
  }

  @Override
  public String deleteCoffeeImageById(Long id) throws IOException {
    Coffee existingCoffee = coffeeRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    storageFile.deleteFile(existingCoffee.getImage());
    existingCoffee.setImage("");
    coffeeRepository.save(existingCoffee);
    return "Successfully deleted";
  }
}
