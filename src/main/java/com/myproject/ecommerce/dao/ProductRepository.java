package com.myproject.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.ecommerce.entity.Product;
import org.springframework.web.bind.annotation.CrossOrigin;;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

}
