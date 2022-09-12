package com.mienekleinepupkin.CoffeeShop;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoffeeShopApplication {

  public static void main(String[] args) {
    SpringApplication.run(CoffeeShopApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner() {
    return args -> {
      File folder = new File(System.getProperty("user.dir") + "/files/");
      if (!folder.exists()) {
        folder.mkdir();
      }
    };
  }
}
