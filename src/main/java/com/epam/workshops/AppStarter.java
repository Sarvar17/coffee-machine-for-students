package com.epam.workshops;

import java.util.Scanner;

/**
 * Contains main, starts the app
 *
 * @author Marcin Ogorzalek
 */
class AppStarter {
    public static void main(String[] args) {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("CoffeeMaker> ");
            input = scanner.nextLine();
            if (input.toLowerCase().equals("hello"))
                System.out.println("Hello!");
            else if (input.toLowerCase().equals("exit"))
                System.out.println("Bye!");
            else
                System.out.println("Unknown command");
        }
    }
}
