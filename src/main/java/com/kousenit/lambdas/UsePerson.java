package com.kousenit.lambdas;

import java.util.*;
import java.util.stream.Collectors;

public class UsePerson {
    @SuppressWarnings({"Convert2MethodRef"})
    public static void main(String[] args) {
        List<String> names = List.of("John", "Paul", "George", "Ringo");
        System.out.println(names);

        // Old-style, Java 7 and earlier, approach:
        List<Person> beatles = new ArrayList<>(); // shared mutable state
        for (String name : names) {
            beatles.add(new Person(name));
        }
        System.out.println("The Beatles: " + beatles);

        List<Person> people = names.stream()    // Stream<String>
                .map(name -> new Person(name))  // Stream<Person>
                .collect(Collectors.toList());  // Converts Stream<Person> to List<Person>
        System.out.println(people);

        people = names.stream()
                .map(Person::new)  // constructor reference (method reference to a ctor)
                .peek(person -> System.out.println(person + " on thread " + Thread.currentThread().getName()))
                .collect(Collectors.toList());
        System.out.println(people);
        System.out.println(people.getClass().getName());  // for me, returns an ArrayList

        people = names.parallelStream()
                .map(Person::new)
                .peek(person -> System.out.println(person + " on thread " + Thread.currentThread().getName()))
                //.collect(Collectors.toCollection(() -> new LinkedList<>()));
                .collect(Collectors.toCollection(LinkedList::new)); // must return a LinkedList
        System.out.println(people);
        System.out.println(people.getClass().getName());

        List<Person> personList = Collections.synchronizedList(new ArrayList<>());
        names.parallelStream()
                .map(Person::new)
                .peek(person -> System.out.println(person + " on thread " + Thread.currentThread().getName()))
                .forEach(person -> personList.add(person));
        System.out.println(personList);

        Person[] peopleArray = names.stream()
                .map(Person::new)
                .toArray(Person[]::new);
        System.out.println(Arrays.toString(peopleArray));
    }
}
