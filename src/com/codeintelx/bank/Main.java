package com.codeintelx.bank;

import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.AccountServices;

import java.util.*;

public class Main {
    public static AccountServices accountServices = new AccountServices(0.00);
    Account account = new Account();

    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        //AccountServices accountServices = new AccountServices()
        Scanner scanner = new Scanner(System.in);


        while(true)
        {

            System.out.println("Please enter choice");
            System.out.println("1.Create an Account \n" +
                    "2.View Account by Account Number \n" +
                    "3.Withdraw from Account \n" +
                    "4.Deposit from Account");

            int action = scanner.nextInt();
            scanner.nextLine();
            // scanner.next(); //git

            switch (action) {
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
//                    somethingElse();
                    //createAccount();
//                    System.out.println("Enter name: ");
//                    name = scanner.nextLine();
//                    //accountServices. createAccount(name, type);
//                    System.out.println("Which account would you like to access? ");
//                    type = scanner.nextLine();
//                    accountServices. createAccount(name, type);
                    createAccount();


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
                    System.out.println("Please enter account number");
                 accountServices.viewAccount(scanner.nextDouble());

                    break;
                case 3:
//                    System.out.println("Please enter name or Account Number");
//                    AccountServices accountServices = new AccountServices(scanner.next());
//                    System.out.println("How much do you want to withdraw from your account?");
//                    //AccountServices accountServices = new AccountServices(scanner.nextInt());
//                    accountServices.withdrawFunds(scanner.nextInt());
//                    break;
                case 4:
//                    System.out.println("Please enter name or Account Number");
//                    AccountServices accountServices1 = new AccountServices(scanner.next());
//                    System.out.println("How much do you want to deposit into your account?");
//                    accountServices1.depositFunds(scanner.nextInt());
//                    break;
                default:
                    System.out.println("Please enter another choice");


            }
        }









    }

    public static Account createAccount()
    {
        // ArrayList<String> account = new ArrayList<>();
        // ArrayList<Account> account = new ArrayList<>();
        System.out.println("Enter name: ");
         String name = scanner.nextLine();
       // account.add(name);
        System.out.println("Which account would you like to access? ");
        String type = scanner.nextLine();
        //account.add(type);
        Double accountNumber = Math.random();

        if(type.equals("Checking"))
        {
            System.out.println("Checking account number:");
            //Double accountNumber = Math.random();
            //account.add(accountNumber);
            System.out.println("New customer added: name = " + name + ", type = "+ type + ", account number: " + accountNumber );
           // System.out.println(account);

            // Account newCustomer = Account.createAccount("" , 0.00, name, type);
            //bankCustomers.add(newCustomer);
        }
        else if (type.equals("Savings"))
        {
            System.out.println("Saving account number:");
            //Double accountNumber = Math.random();
            //account.add(accountNumber);
            System.out.println("New customer added: name = " + name + ", type = "+ type + ", account number: " + accountNumber );
            //System.out.println(account);
            // Account newCustomer = Account.createAccount("" , 0.00, name, type);
            //account.add(newCustomer);
            //account.add(accountNumber);
        }
        else
        {
            System.out.println("We trying");
            //System.out.println(account);
        }
        accountServices.createAccount(name, type, accountNumber);
        return null;

    }













//    public static void createAccount()
//    {
//       // ArrayList<String> account = new ArrayList<>();
//        ArrayList<String> account = new ArrayList<>();
//        System.out.println("Enter name: ");
//        String name = scanner.nextLine();
//        account.add(name);
//        System.out.println("Which account would you like to access? ");
//        String type = scanner.nextLine();
//        account.add(type);
//
//        if(type.equals("Checking"))
//        {
//            System.out.println("Checking account number:");
//            Double accountNumber = Math.random();
//            account.add(accountNumber.toString());
//            System.out.println("New customer added: name = " + name + ", type = "+ type + ", account number: " + accountNumber );
//            System.out.println(account);
//
//           // Account newCustomer = Account.createAccount("" , 0.00, name, type);
//            //bankCustomers.add(newCustomer);
//        }
//        else if (type.equals("Savings"))
//        {
//            System.out.println("Saving account number:");
//            Double accountNumber = Math.random();
//            account.add(accountNumber.toString());
//            System.out.println("New customer added: name = " + name + ", type = "+ type + ", account number: " + accountNumber );
//            System.out.println(account);
//           // Account newCustomer = Account.createAccount("" , 0.00, name, type);
//            //account.add(newCustomer);
//            //account.add(accountNumber);
//        }
//        else
//        {
//            System.out.println(account);
//        }
//
//    }

//    public static void createNewCustomer()
//    {
//         ArrayList<Account> bankCustomers= new ArrayList<>();
//
//        System.out.println("Enter name: ");
//        String name = scanner.nextLine();
//        System.out.println("Which account would you like to access? ");
//        String type = scanner.nextLine();
//        if(type == "Checking")
//        {
//            System.out.println("Checking account number:");
//            Double accountNumber = Math.random();
//            Account newCustomer = Account.createAccount("" , 0.00, name, type);
//            bankCustomers.add(newCustomer);
//        }
//        else if(type == "Savings")
//        {
//            System.out.println("Saving account number:");
//            Double accountNumber = Math.random();
//            Account newCustomer = Account.createAccount("" , 0.00, name, type);
//            bankCustomers.add(newCustomer);
//        }
////        System.out.println("account number:");
//        Double accountNumber = Math.random();
//        Account newCustomer = Account.createAccount("" , 0.00, name, type);
//        //AccountServices accountService;
//         if(accountServices.addNewAccount(newCustomer))
//        {
//            System.out.println("New customer added: name = " + name + ", type = "+ type + ", account number: " + accountNumber );
//        } else {
//            System.out.println("Cannot add, " + name + " already on file");
//        }
//        accountServices.printCustomers();
//        System.out.println(bankCustomers.size());
//    }

//    public static void somethingElse()
//    {
//        ArrayList<Integer> something= new ArrayList<>();
//        something.add(4);
//
//        System.out.println(something);
//    }



//    private static void queryCustomer() {
//        System.out.println("Enter existing accountNumber: ");
//        String accountNumber = scanner.nextLine();
//        Contact existingContactRecord = mobilePhone.queryContact(name);
//        if (existingContactRecord == null) {
//            System.out.println("Contact not found.");
//            return;
//        }
//
//
//
//
//
//
//


//    private static void queryCustomer() {
//        System.out.println("Enter accountNumber: ");
//        String accountNumber = scanner.nextLine();
//        Account existingAccountNumber = accountServices.queryCustomer(accountNumber);
//        if (existingAccountNumber == null) {
//            System.out.println("Contact not found.");
//            return;
//        }
//    }
}

