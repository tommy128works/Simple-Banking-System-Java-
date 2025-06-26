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
        this.printMenu();
        this.processInput();
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
        int input = Integer.parseInt(this.scanner.nextLine());

        // Exit case
        if (input == 0) {
            System.out.println("Bye!");
            System.exit(0);
        }

        if (this.isLoggedIn) {
            switch (input) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("No cases found");
                    break;
            }



        } else {
            switch (input) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("No cases found");
                    break;
            }

        }
    }

}
