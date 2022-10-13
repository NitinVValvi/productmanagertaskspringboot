package com.productmanager.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productmanager.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	Optional<Product> findProductById(int id);

	public void deleteProductById(int id);

	Optional<Product> findProductByName(String name);

	Optional<List<Product>> findProductsByName(String name);

	
}
