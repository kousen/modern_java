package com.kousenit.interfaces;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

// Create a class called CompanyEmployee that implements both
//   the Company and Employee interfaces
// Implement the necessary methods
// Give the class a two-arg constructor that takes first and last name
// Implement the getName method so that the test below passes
public class CompanyEmployeeTest {

    @Test
    public void getName() {
        CompanyEmployee emp = new CompanyEmployee("Peter", "Gibbons");
        assertEquals("Peter Gibbons works for Initech", emp.getName());

        String name = "CompanyEmployee[first=" + emp.first() + ", last=" + emp.last() + "]";
        System.out.println(name);
        System.out.println(emp);
        assertThat(emp.toString()).isEqualTo(name);
    }

    @Test
    public void checkEquivalence() {
        CompanyEmployee michael1 = new CompanyEmployee("Michael", "Bolton");
        CompanyEmployee michael2 = new CompanyEmployee("Michael", "Bolton");
        assertNotSame(michael1, michael2);  // two separate objects
        assertEquals(michael1, michael2);   // equivalent by the equals method
    }
}