package com.epam.workshops;

public class CoffeeMaker {
    private String status;

    public CoffeeMaker() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static void command(String input) {
        if (input.equalsIgnoreCase("hello"))
            System.out.println("Hello!");
        else if (input.equalsIgnoreCase("exit"))
            System.out.println("Bye!");
        else
            System.out.println("Unknown command");
    }

    @Override
    public String toString() {
        return "CoffeeMaker{" +
                "status='" + status + '\'' +
                '}';
    }
}
