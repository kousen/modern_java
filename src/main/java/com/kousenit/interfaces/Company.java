package com.kousenit.interfaces;

public interface Company {
    default String getName() {
        return "Initech";
    }

    // String getName();
}
