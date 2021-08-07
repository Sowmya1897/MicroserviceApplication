package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.model.Order;
import com.order.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	void save(Order order);

}
