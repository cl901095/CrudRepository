package com.crudApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Product_Details")
public class Product {
	
	@Id
	@GeneratedValue
	private Integer productId;
	private String name;
	private Integer Quanity;
	private String MfDate;
	private String expDate;
	private Double price;

}
