package com.crudApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product	savedProduct= crudService.saveProduct(product);
		return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
	}

	@PostMapping("/addProducts")
	public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
		List<Product> savedProducts=crudService.saveProducts(products);
		return new ResponseEntity<>(savedProducts,HttpStatus.CREATED);
	}

	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> AllProducts= crudService.getProducts();
		return new ResponseEntity<>(AllProducts,HttpStatus.OK);
	}

	@GetMapping("/getProductById/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product getProduct= crudService.getProductById(id);
//		return new ResponseEntity<>(getProduct,HttpStatus.OK);
		return getProduct !=null ? new ResponseEntity<>(getProduct,HttpStatus.OK)
		                         : new ResponseEntity<>(getProduct,HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getProductByName/{name}")
	public ResponseEntity<Product> getProductByName(@PathVariable String name) {
		Product getProduct= crudService.getProductByName(name);
		return getProduct !=null ? new ResponseEntity<>(getProduct,HttpStatus.OK)
				                 : new ResponseEntity<>(getProduct,HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateProduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product updateproduct= crudService.updateProduct(product);
		return updateproduct !=null ? new ResponseEntity<>(updateproduct,HttpStatus.OK)
				                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<String> deleteTicketById(@PathVariable int id) {
		String deleteTicket= crudService.deleteProduct(id);
		return new ResponseEntity<>(deleteTicket,HttpStatus.OK);
	}
}
