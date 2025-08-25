package com.myproject.ecommerce.service;

import com.myproject.ecommerce.dto.Purchase;
import com.myproject.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
