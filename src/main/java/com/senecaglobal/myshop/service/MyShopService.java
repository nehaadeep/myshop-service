package com.senecaglobal.myshop.service;

import com.senecaglobal.myshop.models.MyCartRequest;
import com.senecaglobal.myshop.models.MyCartResponse;
import com.senecaglobal.myshop.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: Service implementation
 * @author: Suresh_Vannale
 * @date: 2/1/2021-4:43 PM
 */
@Service
public class MyShopService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyShopService.class);

    public MyCartResponse calculateMyCart(MyCartRequest myCartRequest) {
        LOGGER.info("Enter calculateMyCart().");
        DecimalFormat decimalFormat = new DecimalFormat("###.#");
        List<String> discounts = new ArrayList<>();
        MyCartResponse myCartResponse = new MyCartResponse();
        Map<String, List<Product>> map = myCartRequest.getProducts().stream().collect(Collectors.groupingBy(Product::getName));
        Double subTotal = myCartRequest.getProducts().stream().collect(Collectors.summarizingDouble(Product::getPrice)).getSum();
        myCartResponse.setSubtotal(subTotal);
        Double tax = subTotal * 0.18;
        myCartResponse.setTax(tax);
        double totalAmountAfterTax = subTotal + tax;
        if (map.containsKey("Shoes")) {
            double discount = map.get("Shoes").get(0).getPrice() * 0.10 * map.get("Shoes").size();
            totalAmountAfterTax = totalAmountAfterTax - discount;
            discounts.add("10% off on shoes: Rs, " + decimalFormat.format(discount));
        }
        if (map.containsKey("T-shirt") && map.get("T-shirt").size() >= 2 && map.containsKey("Jacket")) {
            double discount = map.get("Jacket").get(0).getPrice() * 0.50;
            int pairsT_Shirts = map.get("T-shirt").size() / 2;
            int jackets = map.get("Jacket").size();

            int discountQuantity;

            if (pairsT_Shirts == jackets) {
                discountQuantity = pairsT_Shirts;
            } else {
                discountQuantity = Math.min(pairsT_Shirts, jackets);
            }
            discount = discount * discountQuantity;
            totalAmountAfterTax = totalAmountAfterTax - discount;
            discounts.add("50% off on Jacket: Rs, " + decimalFormat.format(discount));
        }
        myCartResponse.setTotal(totalAmountAfterTax);
        myCartResponse.setDiscounts(discounts);
        if (discounts.size() == 0) {
            myCartResponse.setComments("No eligible offers");
        } else {
            myCartResponse.setComments(String.format("%d eligible offers", discounts.size()));
        }
        LOGGER.info("Exit calculateMyCart().");
        return myCartResponse;
    }

}