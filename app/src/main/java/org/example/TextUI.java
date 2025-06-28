package org.example;

import java.util.Scanner;

public class TextUI {
    private final Scanner scanner;
    private final AppService service;
    private boolean isLoggedIn;

    public TextUI(AppService service) {
        this.scanner = new Scanner(System.in);
        this.service = service;
        this.isLoggedIn = false;
    }

    public void start() {
        while (true) {
            this.printMenu();
            this.processInput();
        }
    }

    public void printMenu() {
        if (this.isLoggedIn) {
            // Dashboard menu
            System.out.println("1. Balance");
            System.out.println("2. Log out");
            System.out.println("0. Exit");
        } else {
            // Landing page menu
            System.out.println("1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("0. Exit");
        }
    }

    public void processInput() {
        String input = this.scanner.nextLine();
        System.out.println();
        int num = Integer.parseInt(input);

        // Exit case
        if (num == 0) {
            System.out.println("Bye!");
            System.exit(0);
        }

        if (this.isLoggedIn) {
            switch (num) {
                case 1:

                    break;
                case 2:
                    break;
                default:
                    System.out.println("No cases found");
                    break;
            }

        } else {
            switch (num) {
                case 1:
                    String[] cardDetails = this.service.createCard();
                    this.printCreatedCard(cardDetails[0], cardDetails[1]);
                    System.out.println();
                    break;
                case 2:

                    break;
                default:
                    System.out.println("No cases found");
                    break;
            }

        }
    }

    public void printCreatedCard(String card, String pin) {
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(card);
        System.out.println("Your card PIN:");
        System.out.println(pin);
    }

}
