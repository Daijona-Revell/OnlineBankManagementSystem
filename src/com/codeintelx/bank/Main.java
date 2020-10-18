package com.codeintelx.bank;

import com.codeintelx.bank.exceptions.AccountNotFoundException;
import com.codeintelx.bank.exceptions.InsufficientFundsException;
import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.AccountServices;

import java.sql.SQLException;
import java.util.*;

public class Main {

    public static AccountServices accountServices = new AccountServices();

    public static Scanner scanner = new Scanner(System.in);

    static Account newAccountObject;


    public static void main(String[] args) {


        boolean quit = false;

        while (!quit) {
            System.out.println("----------------------Welcome To Dai's Bank-----------------");
            String accountNumberFromUser;

            System.out.println("Please enter choice");
            System.out.println("1.Create an Account \n" +
                    "2.View Account by Account Number \n" +
                    "3.Withdraw from Account \n" +
                    "4.Deposit from Account\n" +
                    "5.Remove Account\n" +
                    "6.View all Bank Accounts\n" +
                    "7.Quit Program");

            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1:
                    createAccount();

                    break;

                case 2:

                    System.out.println("Please enter Account number");
                    accountNumberFromUser = scanner.next();
                    try {
                        newAccountObject = accountServices.searchAccount(accountNumberFromUser);
                        System.out.println("Account Number " + newAccountObject.getAccountNumber());
                        System.out.println("Customer Name: " + newAccountObject.getCustomerName());
                        System.out.println("Type Of Account: " + newAccountObject.getTypeOfAccount());
                        System.out.println("Balance: " + newAccountObject.getBalance());
                    } catch (AccountNotFoundException | SQLException errorMessage) {
                        System.out.println(errorMessage.getMessage());
                    }

                    break;

                case 3:

                    System.out.println("Please enter Account Number");
                    accountNumberFromUser = scanner.next();
                    System.out.println("How much money do you want to withdraw?");
                    double withdraw = scanner.nextDouble(); //Double.parseDouble(df.format(scanner.nextDouble()));
                    try {
                        newAccountObject = accountServices.withdrawFunds(accountNumberFromUser, withdraw);
                        System.out.println("New Balance: " + newAccountObject.getBalance());
                    } catch (AccountNotFoundException | InsufficientFundsException | SQLException errorMessage) {
                        System.out.println(errorMessage.getMessage());
                    }

                    break;

                case 4:

                    System.out.println("Please enter Account Number");
                    accountNumberFromUser = scanner.next();
                    System.out.println("How much do you want to deposit?");
                    double deposit = scanner.nextDouble(); //Double.parseDouble(df.format(scanner.nextDouble()));

                    try {
                        newAccountObject = accountServices.depositFunds(accountNumberFromUser, deposit);
                        System.out.println("New Balance: " + newAccountObject.getBalance());
                    } catch (InsufficientFundsException | AccountNotFoundException | SQLException errorMessage) {
                        System.out.println(errorMessage.getMessage());
                    }


                    break;

                case 5:
                    System.out.println("Please enter Account Number");
                    accountNumberFromUser = scanner.next();
                    try {

                        newAccountObject = accountServices.removeUserAccount(accountNumberFromUser);
                        System.out.println("This account will be removed: " + newAccountObject.getCustomerName());
                    } catch (SQLException | AccountNotFoundException errorMessage) {
                        System.out.println(errorMessage.getMessage());
                    }

                    break;

                case 6:
                    try {
                       for(int i = 0; i < accountServices.viewAllAccountsInDatabase().size(); i++)
                       {
                           System.out.println("Account Number:" + accountServices.viewAllAccountsInDatabase().get(i).getAccountNumber());
                           System.out.println("Customer Name:" + accountServices.viewAllAccountsInDatabase().get(i).getCustomerName());
                           System.out.println("Type Of Account:" + accountServices.viewAllAccountsInDatabase().get(i).getTypeOfAccount());
                           System.out.println("Balance:" + accountServices.viewAllAccountsInDatabase().get(i).getBalance()+ "\n");
                       }

                    } catch (SQLException errorMessage) {
                        System.out.println(errorMessage.getMessage());
                    }

                    break;

                case 7:
                    System.out.println("Session ending now. Thank you for using Dai's bank!");
                    quit = true;
                    break;

                default:
                    System.out.println("Please enter another choice");
                    break;

            }
        }

    }

    public static Account createAccount() {

        System.out.println("Your account will be created, Please enter Name: ");
        String customerName = scanner.nextLine();

        System.out.println("Which account would you like to access? (Checking or Savings)");
        String typeOfAccount = scanner.next();

        if (typeOfAccount.equals("Checking")) {
            System.out.println("Checking account created:");
            System.out.println("How much money will you input?");
            double balance = scanner.nextDouble();//Double.parseDouble(df.format(scanner.nextDouble()));
            System.out.println("New customer added: ");
            newAccountObject = accountServices.createAccount(customerName, typeOfAccount, balance);
            System.out.println("Customer: " + newAccountObject.getCustomerName());
            System.out.println("New Account Number: " + newAccountObject.getAccountNumber());
            System.out.println("Type of Account: " + newAccountObject.getTypeOfAccount());
            System.out.println("Balance : " + newAccountObject.getBalance());

        } else if (typeOfAccount.equals("Savings")) {
            System.out.println("Saving account created:");
            System.out.println("How much money will you input?");
            double balance = scanner.nextDouble();//Double.parseDouble(df.format(scanner.nextDouble()));
            System.out.println("New customer added: ");

            newAccountObject = accountServices.createAccount(customerName, typeOfAccount, balance);
            System.out.println("Customer: " + newAccountObject.getCustomerName());
            System.out.println("New Account Number: " + newAccountObject.getAccountNumber());
            System.out.println("Type of Account: " + newAccountObject.getTypeOfAccount());
            System.out.println("Balance : " + newAccountObject.getBalance());

        }
        return newAccountObject;
    }

}
