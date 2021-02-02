package com.senecaglobal.myshop.api.impl;

import com.senecaglobal.myshop.exception.RestBaseException;
import com.senecaglobal.myshop.models.MyCartRequest;
import com.senecaglobal.myshop.models.MyCartResponse;
import com.senecaglobal.myshop.models.Product;
import com.senecaglobal.myshop.service.MyShopService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @description:
 * @author: Suresh_Vannale
 * @date: 2/2/2021-3:05 PM
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Unit test cases for MyShopApiImpl")
class MyShopApiImplTest {

    @Mock
    private MyShopService myShopService;

    @InjectMocks
    private MyShopApiImpl myShopApi;

    @Test
    @DisplayName("Unit test case for empty products")
    void testEmptyProducts() {
        try {
            myShopApi.getTotalAmountOfMyCart(new MyCartRequest());
        } catch (RestBaseException restBaseException) {
            assertEquals("Products should not be empty", restBaseException.getMessage(), "Not matching");
        }
    }

    @Test
    @DisplayName("Unit test case for calculateMyCart")
    void testCalculateMyCart() {
        MyCartRequest myCartRequest = new MyCartRequest();
        Product product = new Product();
        product.setPrice(500.0);
        product.setName("T-shirt");
        product.setId(1);
        List<Product> products = new ArrayList<>();
        products.add(product);
        myCartRequest.setProducts(products);
        ResponseEntity<MyCartResponse> responseEntity = myShopApi.getTotalAmountOfMyCart(myCartRequest);
        assertNotNull(responseEntity, "responseEntity is null");
        assertEquals(200, responseEntity.getStatusCodeValue(), "Status code not matching");
    }
}