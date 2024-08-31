package com.zip.InventorySystem.Parameter;

import java.math.BigDecimal;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductParam {
    private String name;
	
    private String description;
    
    private String productType;
	
	private BigDecimal quantity;
	
	private BigDecimal price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public ProductParam (String name, String description, String productType, BigDecimal quantity, BigDecimal price) {
		this.name = name;
		this.description =description;
		this.productType = productType;
		this.quantity = quantity;
		this.price = price;
	}

}
