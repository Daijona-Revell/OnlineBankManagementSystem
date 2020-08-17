package com.codeintelx.bank;

import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.AccountServices;

import java.util.*;

public class Main {
    public static AccountServices accountServices = new AccountServices();
    //public static Random rand = new Random();


    public static Scanner scanner = new Scanner(System.in);
    //public static String accountNumberFromUser;


    public static void main(String[] args) {
       // Scanner scanner = new Scanner(System.in);
       // String accountNumberFromUser = scanner.next();

        boolean quit = false;

        while (!quit) {
           // System.out.println("----------------------Welcome To Dai's Bank-----------------");
            String accountNumberFromUser;

            System.out.println("Please enter choice");
            System.out.println("1.Create an Account \n" +
                    "2.View Account by Account Number \n" +
                    "3.Withdraw from Account \n" +
                    "4.Deposit from Account\n" +
                    "5.Remove Account\n" +
                    "6.Quit Program");

            int action = scanner.nextInt();
            scanner.nextLine();
            // scanner.next(); //git

            switch (action) {
                case 1:

                    createAccount();

                    break;

                case 2:

                    System.out.println("Please enter Account number");
                   accountNumberFromUser = scanner.next();

                   accountServices.viewAccount(accountNumberFromUser);


                    break;
                case 3:

                    System.out.println("Please enter Account Number");
                    accountNumberFromUser = scanner.next();
                    System.out.println("How much money do you want to withdraw?");
                    long withdraw = scanner.nextLong();
                    accountServices.withdrawFunds(accountNumberFromUser, withdraw);
                    break;

                case 4:

                    System.out.println("Please enter Account Number");
                    accountNumberFromUser = scanner.next();
                    System.out.println("How much do you want to deposit?");
                    long deposit = scanner.nextLong();
                    accountServices.depositFunds(accountNumberFromUser, deposit);
                    break;

                case 5:
                    System.out.println("Please enter Account Number");
                    accountNumberFromUser = scanner.next();
                    accountServices.removeAccount(accountNumberFromUser);

                    break;

                case 6:
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
        String name = scanner.nextLine();

        System.out.println("Which account would you like to access? ");
        String type = scanner.next();

        if (type.equals("Checking")) {
            System.out.println("Checking account number:");
            System.out.println("How Much money will you input?");
            long balance = scanner.nextLong();

            System.out.println("New customer added: ");
            accountServices.createAccount(name, type, balance);

            //accountServices.createAccount(name, type, accountNumber, balance);
        } else if (type.equals("Savings")) {
            System.out.println("Saving account number:");
            System.out.println("How Much money will you input?");
            long balance = scanner.nextLong();
            System.out.println("New customer added: ");

            accountServices.createAccount(name, type, balance);
//           randomMethod(newAccount);
//           randomMethod(accountServices.createAccount(name, type, accountNumber, balance));

        }
        return null;
    }
//
//    public static void randomMethod(Account account){
//        System.out.println(account.getBalance());
//    }


}
