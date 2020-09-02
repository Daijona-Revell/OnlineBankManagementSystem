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
    static Account newAccountObject;


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
                    "6.View all Bank Accounts\n" +
                    "7.Quit Program");

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

                            newAccountObject = accountServices.viewUserAccount(accountNumberFromUser);
                            System.out.println("Customer: " + newAccountObject.getCustomerName());
                            System.out.println("Type of Account: " + newAccountObject.getTypeOfAccount());
                            System.out.println("Balance : " + newAccountObject.getBalance());
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

                            newAccountObject = accountServices.withdrawFunds(accountNumberFromUser, withdraw);
                            System.out.println("New Balance: " + newAccountObject.getBalance());
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
                            newAccountObject = accountServices.depositFunds(accountNumberFromUser, deposit);
                            System.out.println("New Balance: " + newAccountObject.getBalance());
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
                            System.out.println("This account will be removed: " + newAccountObject.getCustomerName());
                        }catch (AccountNotFoundException e)
                        {
                            System.out.println(e.getMessage());
                        }

                        break;
                    case 6:
                        for (Map.Entry<String, Account> entry : accountServices.viewAllAccountsInMap().entrySet())
                        {

                            System.out.println("Account Number " + entry.getKey() + ": Customer Name: "
                                    + entry.getValue().getCustomerName() + ", Balance: "
                                     + entry.getValue().getBalance() + " , Type of Account: "
                                    + entry.getValue().getTypeOfAccount());
                        }

                     break;


                    case 7:
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
        String name = scanner.nextLine();

        System.out.println("Which account would you like to access? (Checking or Savings)");
        String type = scanner.next();

        if (type.equals("Checking")) {
            System.out.println("Checking account created:");
            System.out.println("How much money will you input?");
            long balance = scanner.nextLong();

            System.out.println("New customer added: ");
           newAccountObject = accountServices.createAccount(name, type, balance);
            System.out.println("Customer: " + newAccountObject.getCustomerName());
            System.out.println("New Account Number: " + newAccountObject.getAccountNumber());
            System.out.println("Type of Account: " + newAccountObject.getTypeOfAccount());
            System.out.println("Balance : " + newAccountObject.getBalance());

            //accountServices.createAccount(name, type, accountNumber, balance);
        } else if (type.equals("Savings")) {
            System.out.println("Saving account created:");
            System.out.println("How much money will you input?");
            long balance = scanner.nextLong();
            System.out.println("New customer added: ");

           newAccountObject = accountServices.createAccount(name, type, balance);
            System.out.println("Customer: " + newAccountObject.getCustomerName());
            System.out.println("New Account Number: " + newAccountObject.getAccountNumber());
            System.out.println("Type of Account: " + newAccountObject.getTypeOfAccount());
            System.out.println("Balance : " + newAccountObject.getBalance());

        }
        return newAccountObject;
//        System.out.println("Type of Account: " + newAccount.getTypeOfAccount());
//        System.out.println("Balance : " + newAccount.getBalance());
   }



}
