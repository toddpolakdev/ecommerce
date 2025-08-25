package com.myproject.ecommerce.service;

import com.myproject.ecommerce.dao.CustomerRepository;
import com.myproject.ecommerce.dto.Purchase;
import com.myproject.ecommerce.dto.PurchaseResponse;
import com.myproject.ecommerce.entity.Customer;
import com.myproject.ecommerce.entity.Order;
import com.myproject.ecommerce.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve order info
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with order items
        Set<OrderItem> orderItems = purchase.getOrderItems();
        
        //orderItems.forEach(item -> order.add(item));
        orderItems.forEach(order::add);

        // populate order with billing & shipping address
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // save to database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}
