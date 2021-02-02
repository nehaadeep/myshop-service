package com.senecaglobal.myshop.service;

import com.senecaglobal.myshop.models.MyCartRequest;
import com.senecaglobal.myshop.models.MyCartResponse;
import com.senecaglobal.myshop.models.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @description:
 * @author: Suresh_Vannale
 * @date: 2/2/2021-3:32 PM
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Unit test case for MyShopService")
class MyShopServiceTest {

    @InjectMocks
    private MyShopService myShopService;

    @Test
    @DisplayName("Unit test case for calculateMyCart")
    void testCalculateMyCart() {
        MyCartRequest myCartRequest = new MyCartRequest();
        List<Product> products = new ArrayList<>();

        Product product = new Product();
        product.setPrice(500.0);
        product.setName("T-shirt");
        product.setId(1);
        products.add(product);

        product = new Product();
        product.setPrice(500.0);
        product.setName("T-shirt");
        product.setId(1);
        products.add(product);

        product = new Product();
        product.setPrice(5000.0);
        product.setName("Shoes");
        product.setId(4);
        products.add(product);

        product = new Product();
        product.setPrice(2500.0);
        product.setName("Jacket");
        product.setId(3);
        products.add(product);

        myCartRequest.setProducts(products);
        MyCartResponse myCartResponse = myShopService.calculateMyCart(myCartRequest);
        assertNotNull(myCartResponse, "myCartResponse is null");
        assertEquals(8500, myCartResponse.getSubtotal(), "Subtotal not matching");
        assertEquals(1530, myCartResponse.getTax(), "Tax not matching");
        assertEquals(8280, myCartResponse.getTotal(), "Total not matching");
        assertNotNull(myCartResponse.getComments(), "Comments are null");
        assertEquals(2, myCartResponse.getDiscounts().size(), "Size is not mathcing");
    }
}