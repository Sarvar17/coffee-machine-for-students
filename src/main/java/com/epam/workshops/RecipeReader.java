package com.epam.workshops;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RecipeReader {
    private final static String fileformat = ".rcp";

    public static void readRecipe (String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename + fileformat))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



