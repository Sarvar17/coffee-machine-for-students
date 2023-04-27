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

    public boolean command(String input) {
        if (input.equalsIgnoreCase("hello"))
            System.out.println("Hello!");
        else if (input.equalsIgnoreCase("exit"))
            System.out.println("Bye!");
        else if (input.equalsIgnoreCase("status"))
            System.out.println(getStatus());
        else {
            System.out.println("Unknown command");
            return false;
        }
        return true;
    }

    public String getStatus() {
        String coffeeStatus = String.format(tableFormat, "Coffee:", ((coffee * 100) / 2000) + "%", coffee + "g");
        String waterStatus = String.format(tableFormat, "Water:", ((water * 100) / 1500) + "%", water + "g");
        String milkStatus = String.format(tableFormat, "Milk:", ((milk * 100) / 1000) + "%", milk + "g");
        String cocoaStatus = String.format(tableFormat, "Cocoa:", ((cocoa * 100) / 2000) + "%", cocoa + "g");

        return coffeeStatus + waterStatus + milkStatus + cocoaStatus;
    }
}
