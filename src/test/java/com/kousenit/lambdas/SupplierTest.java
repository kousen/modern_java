package com.kousenit.lambdas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SupplierTest {
    private String getErrorMessage() {
        System.out.println("Inside getErrorMessage");
        return "argument should be true";
    }

    @Test
    void checkTrue() {
        boolean x = true;
        assertTrue(x, getErrorMessage());  // evaluates both arguments --> call getErrorMessage always
        assertTrue(x, () -> getErrorMessage());  // second arg is an object; only call get if need it
        assertTrue(x, this::getErrorMessage);
    }
}
