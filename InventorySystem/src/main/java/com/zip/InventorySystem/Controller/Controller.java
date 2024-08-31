package com.zip.InventorySystem.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zip.InventorySystem.Parameter.ProductParam;
import com.zip.InventorySystem.entity.Product;
import com.zip.InventorySystem.model.Response;
import com.zip.InventorySystem.service.ProductService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class Controller {
	
	@Autowired
	private ProductService productService;
	
	
	
	@GetMapping("/")
	public String getProducts() {
		List<Product> productList = productService.getProducts();
		Response res = new Response();
		if(productList.size() < 1) {
			res.setCode(1);
			res.setMessage("no product");
			res.setData(new Object());
		}
		res.setCode(0);
		res.setMessage("success get");
		res.setData(productList);
		
		return res.toString();
		
	}
	
	@PostMapping("/add")
	public String addProduct(  @RequestBody ProductParam productParam ) {
		Product product = productService.addProduct(productParam);
		Response res = new Response();
		if(product == null) {
			res.setCode(1);
			res.setMessage("unable to add product");
			res.setData(new Object());
		}
		res.setCode(0);
		res.setMessage("success add");
		res.setData(product);
		
		return res.toString();
	}

	
	@PutMapping("/update/{productId}")
	public String addProduct(  @RequestBody ProductParam productParam, @PathVariable Long productId ) {
		Product product = productService.updateProduct(productParam, productId);
		Response res = new Response();
		if(product == null) {
			res.setCode(1);
			res.setMessage("unable to update product");
			res.setData(new Object());
		}
		res.setCode(0);
		res.setMessage("success update");
		res.setData(product);
		
		return res.toString();
	}
	
	@DeleteMapping("/delete/{productId}")
	public String deleteProduct(  @PathVariable Long productId ) {
		Product product = productService.deleteProduct(productId);
		Response res = new Response();
		if(product == null) {
			res.setCode(1);
			res.setMessage("unable to delete product");
			res.setData(new Object());
		}
		res.setCode(0);
		res.setMessage("success delete");
		res.setData(product);
		
		return res.toString();
	}
	
}
