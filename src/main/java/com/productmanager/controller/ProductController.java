package com.productmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productmanager.model.Product;
import com.productmanager.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

	private final ProductService productservice;

	@Autowired
	public ProductController(ProductService productservice) {
		this.productservice = productservice;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productservice.findAllProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
		Product product = productservice.findProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);

	}

	@GetMapping("/findproduct/{name}")
	public ResponseEntity<Product> getProductsByName(@PathVariable(value = "name") String name) {
		Product product = productservice.findProductByName(name);
		return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);

	}

	@GetMapping("/findproducts/{name}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable(value = "name") String name) {
		List<Product> products = productservice.findProductsByName(name);
		return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);

	}

	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product newproduct = productservice.addProduct(product);

		return new ResponseEntity<Product>(newproduct, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable int id) {
		Product updateProduct = productservice.get(id);
		productservice.save(product);
		return new ResponseEntity<>(updateProduct, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {

		productservice.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
