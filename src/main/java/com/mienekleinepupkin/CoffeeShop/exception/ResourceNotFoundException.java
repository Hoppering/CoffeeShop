package com.mienekleinepupkin.CoffeeShop.exception;

import java.util.function.Supplier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
  Supplier<String> supplier = () -> "Not found";
}
