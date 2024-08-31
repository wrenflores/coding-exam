package com.zip.InventorySystem.dao;

import org.springframework.data.repository.CrudRepository;

import com.zip.InventorySystem.entity.Product;


public interface ProductDAO extends CrudRepository<Product, Long> {
	
	<T> Product findByName(String name);

}
