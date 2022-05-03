package com.kousenit.lambdas;

public class Person {
    private String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public Person(String... names) {
        name = String.join(" ", names);
    }

    public Person(Person other) {
        name = other.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.format("Person(%s)", name);
    }
}
