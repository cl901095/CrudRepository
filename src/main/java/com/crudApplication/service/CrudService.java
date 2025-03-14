package com.crudApplication.service;

import java.util.List;

import com.crudApplication.entity.Product;

public interface CrudService {
	public Product saveProduct(Product product);
	public List<Product> saveProducts(List<Product> products);
	public List<Product> getProducts();
	public Product getProductById(Integer id);
	public Product getProductByName(String name) ;
	public String deleteProduct(int id);
	public Product updateProduct(Product product);

}
