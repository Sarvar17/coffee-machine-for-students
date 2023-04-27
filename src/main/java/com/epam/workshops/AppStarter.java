package com.epam.workshops;

import java.util.Scanner;

/**
 * Contains main, starts the app
 *
 * @author Marcin Ogorzalek
 */
class AppStarter {
    public static void main(String[] args) throws InterruptedException {
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        String input = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("CoffeeMaker> ");
            input = scanner.nextLine();
            if (!coffeeMaker.command(input))
                break;
        }
    }
}
