package com.ehrenberg.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehrenberg.apirest.apirest.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
