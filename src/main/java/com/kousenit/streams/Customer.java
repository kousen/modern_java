package com.kousenit.streams;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Customer addOrder(Order order) {
        orders.add(order);
        return this;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return name;
    }
}
