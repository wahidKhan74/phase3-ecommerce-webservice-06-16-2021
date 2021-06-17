package com.mcit.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcit.webservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
