package com.epam.workshops;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RecipeReader {
    private final static String filename = "CoffeeWithMilk.rcp";

    public static void readRecipe () {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



