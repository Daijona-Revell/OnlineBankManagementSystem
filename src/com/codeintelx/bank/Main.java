package com.codeintelx.bank;

import com.codeintelx.bank.exceptions.AccountNotFoundException;
import com.codeintelx.bank.exceptions.InsufficientFundsException;
import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.AccountServices;

import java.util.*;

public class Main {
    public static AccountServices accountServices = new AccountServices();
    //public static Random rand = new Random();


    public static Scanner scanner = new Scanner(System.in);
    //public static String accountNumberFromUser;
    static Account newAccount;


    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // String accountNumberFromUser = scanner.next();


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
                        //Account newAccount;
//                        while (accountServices.searchAccount(accountNumberFromUser) == null) {
//                            System.out.println("Account not found, Please enter a valid account number");
//                            accountNumberFromUser = scanner.next();
//                        }
                        //Account newAccount;
                        try {

                            newAccount = accountServices.viewAccount(accountNumberFromUser);
                            System.out.println("Customer: " + newAccount.getCustomerName());
                            System.out.println("Type of Account: " + newAccount.getTypeOfAccount());
                            System.out.println("Balance : " + newAccount.getBalance());
                        }catch (AccountNotFoundException e)
                        {
                            System.out.println("Account Not Found");
                        }


                        break;
                    case 3:

                        System.out.println("Please enter Account Number");
                        accountNumberFromUser = scanner.next();
                        System.out.println("How much money do you want to withdraw?");
                        long withdraw = scanner.nextLong();
                        try {

                            newAccount = accountServices.withdrawFunds(accountNumberFromUser, withdraw);
                            System.out.println("New Balance: " + newAccount.getBalance());
                        }
                        catch(AccountNotFoundException e)
                        {
                            System.out.println(e.getMessage());
                        }
                            catch(InsufficientFundsException errorMessage)
                            {
                                System.out.println(errorMessage.getMessage());
                               // System.out.println( "Insufficient Funds, Please try again. You have this much in your account: " + newAccount.getBalance());
                            }
//                       if (newAccount.getBalance()<0)
//                       {
//                           System.out.println("Insufficient Funds, Can't remove that much money. This is how much you have in your account");
//                           //System.out.println(newAccount.getBalance());
//                       }
                        break;

                    case 4:

                        System.out.println("Please enter Account Number");
                        accountNumberFromUser = scanner.next();
                        System.out.println("How much do you want to deposit?");
                        long deposit = scanner.nextLong();

                        try {
                            newAccount = accountServices.depositFunds(accountNumberFromUser, deposit);
                            System.out.println("New Balance: " + newAccount.getBalance());
                        } catch (InsufficientFundsException errorMessage)
                        {
                            System.out.println(errorMessage.getMessage());
                        }
                        catch (AccountNotFoundException e)
                        {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 5:
                        System.out.println("Please enter Account Number");
                        accountNumberFromUser = scanner.next();
                        try {

                            accountServices.removeAccount(accountNumberFromUser);
                            System.out.println("This account will be removed: " + newAccount.getCustomerName());
                        }catch (AccountNotFoundException e)
                        {
                            System.out.println(e.getMessage());
                        }

                        break;

                    case 6:
                        quit = true;
                        break;

                    default:
                        System.out.println("Please enter another choice");
                        break;


                }
            } while (!quit);


        }

        public static Account createAccount()
    {
        //newAccount = accountServices.ce(accountNumberFromUser);
        //String accountNumber = "";

        System.out.println("Your account will be created, Please enter name: ");
        String name = scanner.next();

        System.out.println("Which account would you like to access? (Checking or Savings)");
        String type = scanner.next();

        if (type.equals("Checking")) {
            System.out.println("Checking account created:");
            System.out.println("How much money will you input?");
            long balance = scanner.nextLong();

            System.out.println("New customer added: ");
           newAccount = accountServices.createAccount(name, type, balance);
            System.out.println("Customer: " + newAccount.getCustomerName());
            System.out.println("New Account Number: " + newAccount.getAccountNumber());
            System.out.println("Type of Account: " + newAccount.getTypeOfAccount());
            System.out.println("Balance : " + newAccount.getBalance());

            //accountServices.createAccount(name, type, accountNumber, balance);
        } else if (type.equals("Savings")) {
            System.out.println("Saving account created:");
            System.out.println("How much money will you input?");
            long balance = scanner.nextLong();
            System.out.println("New customer added: ");

           newAccount = accountServices.createAccount(name, type, balance);
            System.out.println("Customer: " + newAccount.getCustomerName());
            System.out.println("New Account Number: " + newAccount.getAccountNumber());
            System.out.println("Type of Account: " + newAccount.getTypeOfAccount());
            System.out.println("Balance : " + newAccount.getBalance());

        }
        return  newAccount;
//        System.out.println("Type of Account: " + newAccount.getTypeOfAccount());
//        System.out.println("Balance : " + newAccount.getBalance());
   }



}
