package com.myproject.ecommerce.dto;

import com.myproject.ecommerce.entity.Address;
import com.myproject.ecommerce.entity.Customer;
import com.myproject.ecommerce.entity.Order;
import com.myproject.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
