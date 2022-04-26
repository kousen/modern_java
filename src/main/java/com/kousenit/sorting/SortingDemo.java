package com.kousenit.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
        Collections.sort(numbers);
        System.out.println(numbers);
        // numbers.add(2);

        List<String> letters = new ArrayList<>();
        letters.add("b"); letters.add("k");
        letters.add("c"); letters.add("e");
        letters.add("d"); letters.add("r");
        Collections.sort(letters);
        System.out.println(letters);
    }
}
