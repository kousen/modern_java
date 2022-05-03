package com.kousenit.lambdas;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside MyRunnable");
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();

        // Java 7 syntax
        new Thread(new Runnable() {  // anonymous inner class
            @Override
            public void run() {
                System.out.println("Inside an anonymous inner class");
            }
        }).start();

        // Expression lambda
        new Thread(() -> System.out.println("Inside expression lambda")).start();

        // Block lambda
        new Thread(() -> {
            System.out.println("Inside block lambda");
        }).start();

        // Assign a lambda to a variable
        Runnable runnable = () -> System.out.println("Assigned to a variable");
        new Thread(runnable).start();
    }
}

