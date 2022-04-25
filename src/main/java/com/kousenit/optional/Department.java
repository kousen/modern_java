package com.kousenit.optional;

import java.util.Optional;

public class Department {
    private String name;
    private Manager manager;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Optional<Manager> getOptionalManager() {
        return Optional.ofNullable(manager);
    }
}
