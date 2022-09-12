package com.mienekleinepupkin.CoffeeShop.repository.coffee.order;

import com.mienekleinepupkin.CoffeeShop.entity.coffee.order.CoffeeOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeOrderDetailRepository extends JpaRepository<CoffeeOrderDetail, Long> {

}
