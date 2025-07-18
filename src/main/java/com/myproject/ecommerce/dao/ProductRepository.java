package com.myproject.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.ecommerce.entity.Product;;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
