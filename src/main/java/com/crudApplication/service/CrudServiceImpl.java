package com.crudApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudApplication.entity.Product;
import com.crudApplication.repo.ProductRepository;

@Service
public class CrudServiceImpl implements CrudService{
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products){
		return productRepository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public Product getProductById(Integer id) {
		return productRepository.findById(id).orElse(null);
	}

	
	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}
	
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "product deleted "+id;
	}
	
	public Product updateProduct(Product product) {
		Product existingProduct=productRepository.findById(product.getProductId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuanity(product.getQuanity());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setMfDate(product.getMfDate());
		existingProduct.setExpDate(product.getExpDate());
		return productRepository.save(existingProduct);
	}
}
