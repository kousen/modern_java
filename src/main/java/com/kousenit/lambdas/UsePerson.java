package com.kousenit.lambdas;

import java.util.*;
import java.util.stream.Collectors;

public class UsePerson {
    @SuppressWarnings({"Convert2MethodRef"})
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Paul", "George", "Ringo");

        // traditional (non-functional) approach:
        List<Person> beatles = new ArrayList<>(); // shared mutable state
        for (String name : names) {
            beatles.add(new Person(name));
        }
        System.out.println(beatles);

        List<Person> people = names.stream()    // Stream<String>
                .map(name -> new Person(name))  // Stream<Person>
                .collect(Collectors.toList());  // Converts Stream<Person> to List<Person>
        System.out.println(people);

        people = names.stream()
                .map(Person::new)
                // .collect(Collectors.toList());  // In Java 17, can replace this line with .toList()
                .toList();
        System.out.println(people);

        Person[] peopleArray = names.stream()
                .map(Person::new)
                .toArray(Person[]::new);
        System.out.println(Arrays.toString(peopleArray));

        List<String> personNames = List.of("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr");

        people = personNames.stream()
                .map(name -> name.split(" "))
                .map(Person::new) // context arg is a String[], so calls Person(String...)
                .map(Person::new) // context arg is a Person, so calls Person(Person)
                .toList();
        System.out.println(people);

        Optional<String> max = names.stream()
                //.max((s1, s2) -> s1.length() - s2.length()); // provide a Comparator using a lambda
                .max(Comparator.comparingInt(String::length));
        System.out.println(max);

        Optional<String> min = names.stream()
                .min(Comparator.comparingInt(String::length));
        System.out.println(min);

    }
}
