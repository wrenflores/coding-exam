package com.zip.InventorySystem.service;

import java.util.List;


import com.zip.InventorySystem.Parameter.ProductParam;
import com.zip.InventorySystem.entity.Product;

public interface ProductService {
	
	List<Product> getProducts();
	
	Product addProduct(ProductParam productParam);
	
	Product updateProduct(ProductParam productParam, Long ProductId);
	
	Product deleteProduct(Long ProductId);

}
