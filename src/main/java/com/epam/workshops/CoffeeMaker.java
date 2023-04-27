package com.epam.workshops;

import java.util.Random;

public class CoffeeMaker {
    private final String tableFormat = "%-8s%-5s%-10s\n";
    private final Random random = new Random();
    private int coffee;
    private int water;
    private int milk;
    private int cocoa;

    public CoffeeMaker() {
        this.coffee = random.nextInt(2000);
        this.water = random.nextInt(1500);
        this.milk = random.nextInt(1000);
        this.cocoa = random.nextInt(2000);
    }

    public boolean command(String input) throws InterruptedException {
        if (input.equalsIgnoreCase("hello"))
            System.out.println("Hello!");
        else if (input.equalsIgnoreCase("exit"))
            System.out.println("Bye!");
        else if (input.equalsIgnoreCase("status"))
            System.out.println(getStatus());
        else if (input.equalsIgnoreCase("make coffee"))
            if (isEnoughIngredients())
                System.out.println(makeCoffee());
            else
                System.out.println("Not enough ingredients");
        else {
            System.out.println("Unknown command");
            return false;
        }
        return true;
    }

    public String makeCoffee() throws InterruptedException {
        grindCoffee();
        heatWater();
        pourWater(20);
        pourWater(10);
        return "Done!";
    }

    private void pourWater(int secs) throws InterruptedException {
        System.out.println("Pour water...");
        sleep(10);
    }

    private void heatWater() throws InterruptedException {
        System.out.println("Heat water...");
        sleep(15);
    }

    private void grindCoffee() throws InterruptedException {
        System.out.println("Grind coffee...");
        sleep(10);
    }

    private void sleep(int secs) throws InterruptedException {
        Thread.sleep(secs * 1000);
    }

    private boolean isEnoughIngredients() {
        if (coffee >= 11 && water >= 200)
            return true;
        return false;
    }

    public String getStatus() {
        String coffeeStatus = String.format(tableFormat, "Coffee:", ((coffee * 100) / 2000) + "%", coffee + "g");
        String waterStatus = String.format(tableFormat, "Water:", ((water * 100) / 1500) + "%", water + "g");
        String milkStatus = String.format(tableFormat, "Milk:", ((milk * 100) / 1000) + "%", milk + "g");
        String cocoaStatus = String.format(tableFormat, "Cocoa:", ((cocoa * 100) / 2000) + "%", cocoa + "g");

        return coffeeStatus + waterStatus + milkStatus + cocoaStatus;
    }
}
