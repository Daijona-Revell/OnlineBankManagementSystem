package com.codeintelx.bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter choice");
        System.out.println("1.Create an Account \n" +
                "2.View Account by Account Number \n" +
                "3.Withdraw from Account \n" +
                "4.Deposit from Account");
        // scanner.next();

        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Account will be created");
                System.out.println("Please enter your name");
                scanner.hasNext();
                break;
            case 2:
                System.out.println("Please enter your account number");
                scanner.hasNext();
                break;
            case 3:
                System.out.println("How much do you want to withdraw from your account?");
                scanner.hasNext();
                break;
            default:
                System.out.println("How much do you want to deposit into your account?");
                scanner.hasNext();


        }
    }
}

