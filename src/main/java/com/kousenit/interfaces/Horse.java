package com.kousenit.interfaces;

public interface Horse extends Animal {
    default String speak() {
        return "neigh";
    }
}
