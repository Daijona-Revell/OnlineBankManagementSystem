package com.codeintelx.bank;

import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.AccountServices;

import java.util.*;

public class Main {
    public static AccountServices accountServices = new AccountServices("Customer");
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //AccountServices accountServices = new AccountServices()
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter choice");
        System.out.println("1.Create an Account \n" +
                "2.View Account by Account Number \n" +
                "3.Withdraw from Account \n" +
                "4.Deposit from Account");
        // scanner.next(); //git

        switch (scanner.nextInt())
        {
            case 1:
                //System.out.println("Please enter your name");
                //boolean customerAccount = AccountServices.addNewCustomer();
                //account.customerAccountCreation();
                //Account account = new Account(scanner.nextLine(), scanner.nextInt(), scanner.nextLine(), scanner.nextLine());
//                ArrayList<String> customerName = new ArrayList<String>();
//                    System.out.println("Account will be created");
//                    scanner.nextLine();
//                    System.out.println("Please enter your name");
//                    customerName.add(scanner.nextLine());
//                    System.out.println(customerName.toString());
                         createNewCustomer();
                    break;


                    //System.out.println("Account will be created");
                    // Account account = new Account(scanner.nextLine());
                    //Account account = new Account();
                    //scanner.nextLine();
                    //System.out.println("Please enter your name");
                    //Account account = new Account(scanner.nextLine());
                    //ArrayList<String> customerName = new ArrayList<String>();
                    //customerName.add(scanner.nextLine());
                    //account.customerAccountCreation(scanner.nextLine());
                    //account.setCustomerName(scanner.nextLine());



            case 2:
//                Account account1 = new Account();
//                account1.accountNumber();
                accountServices.linkAccountNumber();

                break;
            case 3:
                System.out.println("Please enter balance");
                AccountServices accountServices = new AccountServices(scanner.nextInt());
                System.out.println("How much do you want to withdraw from your account?");
                //AccountServices accountServices = new AccountServices(scanner.nextInt());
                accountServices.withdrawFunds(scanner.nextInt());
                break;
            default:
                System.out.println("Please enter balance");
                AccountServices accountServices1 = new AccountServices(scanner.nextInt());
                System.out.println("How much do you want to deposit into your account?");
                accountServices1.depositFunds(scanner.nextInt());


        }









    }

    public static void createNewCustomer()
    {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Which account would you like to access? ");
        String type = scanner.nextLine();
        Account newCustomer = Account.createAccount(0.00, name, type);
        //AccountServices accountService;
        if(accountServices.addNewAccount(newCustomer))
        {
            System.out.println("New customer added: name = " + name + ", type = "+ type);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
        accountServices.printCustomers();
    }







}

