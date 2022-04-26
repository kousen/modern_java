package com.kousenit.lambdas;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SupplierTest {
    private final Logger logger = Logger.getLogger("SupplierTest");

    private String getErrorMessage() {
        System.out.println("Inside getErrorMessage");
        return "This should be true";
    }

    @Test
    void assertTrueWithMessage() {
        boolean x = true;
        // assertTrue(x, getErrorMessage());
        //assertTrue(x, () -> getErrorMessage());
        assertTrue(x, this::getErrorMessage);
        logger.fine(() -> "The value of x is " + x);
    }
}
