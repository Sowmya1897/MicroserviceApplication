package com.product.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;
import javax.validation.Valid;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.product.model.Product;
import com.product.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
@Autowired
ProductRepository repository;


@PostMapping("/saveProducts")
public String saveProducts(@Valid @RequestBody Product product){
	String message="";
	int prd=0;
	
	prd=repository.save(product).getPid();
	if(prd>0) {
	message="product saved successfully with pid "+prd+".";
}else {
	message="Can not add product!";
}
	return message;
}
@GetMapping("/products")
@ResponseBody
public  ResponseEntity<List<Product>> fetchProducts()  {

	
	List<Product> product = repository.findAll();

	if(product.size()==0) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;

	}
	return new ResponseEntity<>(product,HttpStatus.OK) ;
	
}

@GetMapping("/products/{pid}")
@ResponseBody
public Optional<Product> findByProductId(@PathVariable Integer pid ){
	Optional<Product> product = repository.findById(pid);
	return product;
}
}

