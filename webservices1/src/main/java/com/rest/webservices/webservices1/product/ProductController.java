package com.rest.webservices.webservices1.product;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class ProductController {
	
	/*
	 * @GetMapping(path="/filter") public MappingJacksonValue productDetails(){
	 * 
	 * Product product =new Product("Prod1","Bag",4);
	 * 
	 * MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(product);
	 * 
	 * SimpleBeanPropertyFilter filter =
	 * SimpleBeanPropertyFilter.filterOutAllExcept("prodId");
	 * 
	 * FilterProvider filters = new SimpleFilterProvider().addFilter("MyFilter",
	 * filter);
	 * 
	 * mappingJacksonValue.setFilters(filters);
	 * 
	 * return mappingJacksonValue; }
	 */
	
	
	@GetMapping(path="/filter-lists")
	public List<Product> productDetailsList()
	{
		
		return Arrays.asList(new Product("Prod1","Bag",4),new Product("Prod2","Car",8));
	}

	
}
