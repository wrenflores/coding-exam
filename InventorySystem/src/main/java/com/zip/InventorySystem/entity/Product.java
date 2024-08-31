package com.zip.InventorySystem.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zip.InventorySystem.type.ProductType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="products")
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString()
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="description")
    private String description;
	
	@Column(name="type")
    @Enumerated(EnumType.STRING)
    private ProductType productType;
	
	@Column(name="quantity")
	private BigDecimal quantity;
	

	@Column(name="price")
	private BigDecimal price;
	
	@Override
    public String toString() {
		return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description=" + description +
                ", type=" + productType +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

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

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
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
	
//	public Product (String name, String description, ProductType productType, BigDecimal quantity, BigDecimal price) {
//		this.name = name;
//		this.description =description;
//		this.productType = productType;
//		this.quantity = quantity;
//		this.price = price;
//	}
	

}
