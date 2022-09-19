package com.rest.webservices.webservices1.product;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("MyFilter")
public class Product {
   private String prodId;
   
   private String prodName;
   
   private Integer prodQuantity;
   
public Product(String prodId, String prodName, int prodQuantity) {
	super();
	this.prodId = prodId;
	this.prodName = prodName;
	this.prodQuantity = prodQuantity;
}

public String getProdId() {
	return prodId;
}

public String getProdName() {
	return prodName;
}

public int getProdQuantity() {
	return prodQuantity;
}

@Override
public String toString() {
	return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodQuantity=" + prodQuantity + "]";
}
   
   
}
