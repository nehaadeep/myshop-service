package com.senecaglobal.myshop.api.impl;

import com.senecaglobal.myshop.api.MyshopApi;
import com.senecaglobal.myshop.exception.ErrorCode;
import com.senecaglobal.myshop.exception.RestBaseException;
import com.senecaglobal.myshop.models.MyCartRequest;
import com.senecaglobal.myshop.models.MyCartResponse;
import com.senecaglobal.myshop.service.MyShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @description: Implementation for MyshopApi
 * @author: Suresh_Vannale
 * @date: 2/1/2021-3:42 PM
 */
@RestController
public class MyShopApiImpl implements MyshopApi {

    @Autowired
    private MyShopService myShopService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MyShopApiImpl.class);

    @Override
    public ResponseEntity<MyCartResponse> getTotalAmountOfMyCart(@Valid MyCartRequest myCartRequest) {
        LOGGER.info("Enter getTotalAmountOfMyCart().");
        if (CollectionUtils.isEmpty(myCartRequest.getProducts())) {
            throw new RestBaseException(ErrorCode.BAD_REQUEST.getErrorCode(), "Products should not be empty", HttpStatus.BAD_REQUEST);
        }
        MyCartResponse myCartResponse = myShopService.calculateMyCart(myCartRequest);
        LOGGER.info("Exit getTotalAmountOfMyCart().");
        return ResponseEntity.ok(myCartResponse);
    }
}
