package com.mienekleinepupkin.CoffeeShop.exception;

import java.util.function.Supplier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class ResourceNoContent extends RuntimeException{
  Supplier<String> supplier = () -> "Body is null";
}
