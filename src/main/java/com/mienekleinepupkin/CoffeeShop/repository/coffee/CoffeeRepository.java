package com.mienekleinepupkin.CoffeeShop.repository.coffee;

import com.mienekleinepupkin.CoffeeShop.entity.coffee.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

}
