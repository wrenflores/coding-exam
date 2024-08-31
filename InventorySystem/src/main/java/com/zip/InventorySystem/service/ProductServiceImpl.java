package com.zip.InventorySystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zip.InventorySystem.utility;
import com.zip.InventorySystem.Parameter.ProductParam;
import com.zip.InventorySystem.dao.ProductDAO;
import com.zip.InventorySystem.entity.Product;
import com.zip.InventorySystem.type.ProductType;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;


	@Override
	public List<Product> getProducts() {
		return (List<Product>) productDAO.findAll();
	}

	@Override
	public Product addProduct(ProductParam productParam) {
		
		String checkPoint = utility.isProductValid(productParam);
		if( !"".equals(checkPoint) ) {
			return null;
		}
		
		Product product = productDAO.findByName(productParam.getName());
		if( product != null ) {
			return null;
		}
		
		product = new Product();
		product.setName(productParam.getName());
		product.setDescription(productParam.getDescription());
		product.setProductType(ProductType.valueOf(productParam.getProductType()));
		product.setQuantity(productParam.getQuantity());
		product.setPrice(productParam.getPrice());
		
		Product productAdded = productDAO.save(product);
		if( productAdded == null ) {
			return null;
		}
		
		return productAdded;
	}

	@Override
	public Product updateProduct(ProductParam productParam, Long ProductId) {
		String checkPoint = utility.isProductValid(productParam);
		if( !"".equals(checkPoint) ) {
			return null;
		}
		
		Product product = productDAO.findById(ProductId).orElse(new Product());
		if( product == null ) {
			return null;
		}

		product.setName(productParam.getName());
		product.setDescription(productParam.getDescription());
		product.setProductType(ProductType.valueOf(productParam.getProductType()));
		product.setQuantity(productParam.getQuantity());
		product.setPrice(productParam.getPrice());
		
		Product productUpdated = productDAO.save(product);
		if( productUpdated == null ) {
			return null;
		}
		
		return productUpdated;
	}

	@Override
	public Product deleteProduct(Long ProductId) {
		Product product = productDAO.findById(ProductId).get();
		if( product == null ) {
			return null;
		}
		
		productDAO.deleteById(ProductId);
		return product;
	}
	
	
	
	

}
