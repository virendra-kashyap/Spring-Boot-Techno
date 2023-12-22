package com.example.demo.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductServiceImpl;

@RestController
@RequestMapping("/products")
public class ProductCtl {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productServiceImpl.addProduct(product);
	}

}
