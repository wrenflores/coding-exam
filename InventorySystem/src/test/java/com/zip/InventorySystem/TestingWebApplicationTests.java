package com.zip.InventorySystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zip.InventorySystem.Parameter.ProductParam;
import com.zip.InventorySystem.dao.ProductDAO;
import com.zip.InventorySystem.entity.Product;
import com.zip.InventorySystem.service.ProductServiceImpl;
import com.zip.InventorySystem.type.ProductType;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestingWebApplicationTests {

    @Mock
    private ProductDAO productDAO;
    

    @InjectMocks
    private ProductServiceImpl productService; // Assuming the class name is ProductService

    @Test
    void testUpdateProduct() {
        // Arrange
        ProductParam productParam = new ProductParam("New Name", "New Description", "electronic", new BigDecimal(10),  new BigDecimal(99));
        Product existingProduct = new Product();
        existingProduct.setName("Old Name");
        existingProduct.setDescription("Old Description");
        existingProduct.setProductType(ProductType.valueOf("household"));
        existingProduct.setQuantity(new BigDecimal(5));
        existingProduct.setPrice( new BigDecimal(49));
        Product updatedProduct = new Product();
        updatedProduct.setName("New Name");
        updatedProduct.setDescription("New Description");
        updatedProduct.setProductType(ProductType.valueOf("electronic"));
        updatedProduct.setQuantity(new BigDecimal(10));
        updatedProduct.setPrice( new BigDecimal(99));
        
        lenient().when(productDAO.save(argThat(p -> p.getName().equals("New Name")
                && p.getDescription().equals("New Description")
                && p.getProductType() == ProductType.electronic
                && p.getQuantity().equals(new BigDecimal(10))
                && p.getPrice().equals(new BigDecimal(99)))))
        .thenReturn(updatedProduct);

        // Act
        Product result = productService.updateProduct(productParam, 1l);

        // Assert
        assertNotNull(result);
        assertEquals("New Name", result.getName());
        assertEquals("New Description", result.getDescription());
        assertEquals(ProductType.electronic, result.getProductType());
        assertEquals(new BigDecimal(10), result.getQuantity());
        assertEquals(new BigDecimal(99), result.getPrice());
    }
}

