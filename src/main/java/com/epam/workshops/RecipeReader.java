package com.epam.workshops;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RecipeReader {
    private final static String fileFormat = ".rcp";

    public static void readRecipe (String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename + fileFormat))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



