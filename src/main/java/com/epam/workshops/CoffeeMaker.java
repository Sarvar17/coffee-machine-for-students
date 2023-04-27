package com.epam.workshops;

import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoffeeMaker {
    private final String TABLE_FORMAT = "%-8s%-5s%-10s\n";
    private final Pattern pattern = Pattern.compile("^make\\s+\\w+");

    private final int MAX_COFFEE = 2000;
    private final int MAX_WATER = 1500;
    private final int MAX_MILK = 1000;
    private final int MAX_COCOA = 2000;
    private int coffee;
    private int water;
    private int milk;
    private int cocoa;

    public CoffeeMaker() {
        Random random = new Random();
        this.coffee = random.nextInt(MAX_COFFEE);
        this.water = random.nextInt(MAX_WATER);
        this.milk = random.nextInt(MAX_MILK);
        this.cocoa = random.nextInt(MAX_COCOA);
    }

    public boolean command(String input) throws InterruptedException {
        Matcher matcher = pattern.matcher(input.toLowerCase());

        if (input.equalsIgnoreCase("hello"))
            System.out.println("Hello!");
        else if (input.equalsIgnoreCase("exit")) {
            System.out.println("Bye!");
            return false;
        }
        else if (input.equalsIgnoreCase("status"))
            System.out.println(getStatus());
        else if (input.equalsIgnoreCase("make coffee")) {
            if (isEnoughIngredients())
                System.out.println(makeCoffee());
            else
                System.out.println("Not enough ingredients");
        } else if (matcher.find()) {
            if (input.split(" ")[1].length() > 1) {
                RecipeReader.readRecipe(input.split(" ")[1]);
            }
        } else {
            System.out.println("Unknown command");
        }
        return true;
    }

    public String makeCoffee() throws InterruptedException {
        Actions.grind("coffee", 10);
        Actions.heat("water", 15);
        Actions.pour("water",20);
        Actions.pour("water",10);
        return "Done!";
    }

    private boolean isEnoughIngredients() {
        if (coffee >= 11 && water >= 200) {
            coffee -= 11;
            water -= 200;
            return true;
        }
        return false;
    }

    public String getStatus() {
        String coffeeStatus = String.format(TABLE_FORMAT, "Coffee:", ((coffee * 100) / MAX_COFFEE) + "%", coffee + "g");
        String waterStatus = String.format(TABLE_FORMAT, "Water:", ((water * 100) / MAX_WATER) + "%", water + "g");
        String milkStatus = String.format(TABLE_FORMAT, "Milk:", ((milk * 100) / MAX_MILK) + "%", milk + "g");
        String cocoaStatus = String.format(TABLE_FORMAT, "Cocoa:", ((cocoa * 100) / MAX_COCOA) + "%", cocoa + "g");

        return coffeeStatus + waterStatus + milkStatus + cocoaStatus;
    }
}
