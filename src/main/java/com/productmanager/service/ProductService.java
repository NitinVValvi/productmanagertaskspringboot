package com.productmanager.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.productmanager.exception.ApiError;
import com.productmanager.exception.ProductNotFoundException;
import com.productmanager.model.Product;
import com.productmanager.repo.ProductRepo;

@Service
@Transactional
public class ProductService {
	
	private final ProductRepo productrepo;
	@Autowired
	 public ProductService(ProductRepo productrepo) {
		this.productrepo=productrepo;
	}
	public List<Product> findAllProducts() {
		
		return productrepo.findAll();
	}
	public Product findProductById(int id) {
		
		return productrepo.findProductById(id).
				orElseThrow(()->new ProductNotFoundException("product by id "+id+" was not found"));
	}
	
	public Product findProductByName(String name)
	{
		
		  return productrepo.findProductByName(name)
				  .orElseThrow(()-> new
		  ProductNotFoundException("Product by name "+ name+" was not found"));
		 
		
		
	}
	public Product addProduct(Product product) {
		
		return productrepo.save(product);
	}
	
	
	public void deleteProduct(int id) {
	
		productrepo.deleteProductById(id);
		
		throw new ProductNotFoundException("Product with id" +id+ "not present");
			
	}
	public Product updateProduct(Product product) {
		
		return productrepo.save(product);
	}
	public Product get(int id) {
		
		return productrepo.findById(id).get();
	}
	public void save(Product product) {
		productrepo.save(product);
		
	}
	public List<Product> findProductsByName(String name) {
		
		return productrepo.findProductsByName(name).orElseThrow(()-> new
				  ProductNotFoundException("Product by name "+ name+" was not found"));
	}
}
