package com.epam.workshops;

public class Actions {
    public static void pour (String ingredient, int secs) throws InterruptedException {
        System.out.println("Pour " + ingredient + "...");
        sleep(secs);
    }

    public static void heat (String ingredient, int secs) throws InterruptedException {
        System.out.println("Heat " + ingredient + "...");
        sleep(secs);
    }

    public static void grind (String ingredient, int secs) throws InterruptedException {
        System.out.println("Grind " + ingredient + "...");
        sleep(secs);
    }

    private static void sleep(int secs) throws InterruptedException {
        Thread.sleep(secs * 1000L);
    }
}
