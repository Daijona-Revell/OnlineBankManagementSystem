package com.codeintelx.bank;

import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.AccountServices;

import java.util.*;

public class Main {
    public static AccountServices accountServices = new AccountServices();


    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;

        while (!quit) {
            System.out.println("----------------------Welcome To Dai's Bank-----------------");

            System.out.println("Please enter choice");
            System.out.println("1.Create an Account \n" +
                    "2.View Account by Account Number \n" +
                    "3.Withdraw from Account \n" +
                    "4.Deposit from Account\n" +
                    "5.Quit program\n");

            int action = scanner.nextInt();
            scanner.nextLine();
            // scanner.next(); //git

            switch (action) {
                case 1:

                    createAccount();

                    break;

                case 2:

                    System.out.println("Please enter your account number");
                    double accountNumberFromUser = scanner.nextDouble();

                    accountServices.viewAccount(accountNumberFromUser);

                    break;
                case 3:

                    System.out.println("Please enter Account Number");
                    double accountNum = scanner.nextDouble();
                    System.out.println("How much money do you want to withdraw?");
                    double withdraw = scanner.nextInt();
                    accountServices.withdrawFunds(accountNum, withdraw);
                    break;
                case 4:

                    System.out.println("Please enter Account Number");
                    double accountNumber = scanner.nextDouble();
                    System.out.println("How much do you want to deposit?");
                    double deposit = scanner.nextInt();
                    accountServices.depositFunds(accountNumber, deposit);
                    break;
                case 5:
                    quit = true;
                    break;

                default:
                    System.out.println("Please enter another choice");
                    break;


            }
        }


    }

    public static Account createAccount() {

        System.out.println("Enter name: ");
        String name = scanner.next();

        System.out.println("Which account would you like to access? ");
        String type = scanner.next();

        double accountNumber = Math.random();


        if (type.equals("Checking")) {
            System.out.println("Checking account opening:");

            System.out.println("How much money will you input?");
            double balance = scanner.nextDouble();

            System.out.println("New customer added: ");

            accountServices.createAccount(name, type, accountNumber, balance);
        } else if (type.equals("Savings")) {
            System.out.println("Savings account opening:");
            System.out.println("How much money will you input?");
            double balance = scanner.nextDouble();
            System.out.println("New customer added: ");

            accountServices.createAccount(name, type, accountNumber, balance);
        }
        return null;
    }


}
