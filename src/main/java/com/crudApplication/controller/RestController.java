package com.crudApplication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crudApplication.entity.Product;
import com.crudApplication.service.CrudService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/product")
public class RestController {

	private CrudService crudService;

	public RestController(CrudService crudService) {
		super();
		this.crudService = crudService;
	}

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return crudService.saveProduct(product);
	}

	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return crudService.saveProducts(products);
	}

	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		return crudService.getProducts();
	}

	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable int id) {
		return crudService.getProductById(id);
	}

	@GetMapping("/getProductByName/{name}")
	public Product getProductByName(@PathVariable String name) {
		return crudService.getProductByName(name);
	}

	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return crudService.updateProduct(product);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public String deleteTicketById(@PathVariable int id) {
		return crudService.deleteProduct(id);
	}
}
