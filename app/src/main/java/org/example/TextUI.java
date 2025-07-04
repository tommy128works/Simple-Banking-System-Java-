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
            this.scanner.close();
            System.exit(0);
        }

        if (this.isLoggedIn) {
            switch (num) {
                case 1:
                    this.getBalance();
                    break;
                case 2:
                    this.setIsLoggedIn(false);
                    System.out.println("You have successfully logged out!");
                    System.out.println();
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
                    this.processLogin();
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

    public void processLogin() {
        System.out.println("Enter your card number:");
        String cardInput = this.scanner.nextLine();
        System.out.println("Enter your PIN:");
        String pinInput = this.scanner.nextLine();
        System.out.println();

        if (this.service.verifyLogin(cardInput, pinInput)) {
            this.setIsLoggedIn(true);
            System.out.println("You have successfully logged in!");
        } else {
            System.out.println("Wrong card number or PIN!");
        }
        System.out.println();
    }

    public void setIsLoggedIn(boolean value) {
        this.isLoggedIn = value;
    }

    public void getBalance() {
        System.out.println("Balance: " + this.service.getBalance());
        System.out.println();
    }

}
