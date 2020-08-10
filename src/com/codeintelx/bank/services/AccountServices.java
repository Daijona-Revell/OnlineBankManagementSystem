package com.codeintelx.bank.services;

import com.codeintelx.bank.models.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountServices {

    private static Scanner scanner = new Scanner(System.in);

    private static double balance = 0;

    private String myCustomers;
    private ArrayList<Account> bankCustomers;


    public AccountServices(String myCustomers) {
        this.myCustomers = myCustomers;
        this.bankCustomers = new ArrayList<Account>();
    }

    public boolean addNewAccount(Account account) {
        if (findAccount(account.getCustomerName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }

        bankCustomers.add(account);
        return true;

    }

    private int findAccount(Account account) {
        return this.bankCustomers.indexOf(account);
    }

    private int findAccount(String accountName) {
        for (int i = 0; i < this.bankCustomers.size(); i++) {
            Account account = this.bankCustomers.get(i);
            if (account.getCustomerName().equals(accountName)) {
                return i;
            }
        }
        return -1;
    }


    public AccountServices(double balance) {
        this.balance = balance;
    }


//    public String customerAccountCreation (String customerName)
//    {
//        while(customerName == null)
//        {
//            Map <String, String> customer = new HashMap<>();
//            customer.put("", "");
//        }
//        return customerName;
//    }

    //Deposit amount


//    public static boolean addNewCustomer()
//    {
//        System.out.println("Enter name: ");
//        String name = scanner.nextLine();
//        System.out.println("Which account would you like to access? ");
//        String type = scanner.nextLine();
//        Account newCustomer = Account.createAccount(balance, name, type);
//        //AccountServices accountService;
////        if(addNewCustomer())
////        {
//         System.out.println("New contact added: name = " + name + ", type = "+ type);
////        } else {
////            System.out.println("Cannot add, " + name + " already on file");
////        }
//        return false;
//    }


//    private static void queryCustomers() {
//        System.out.println("Enter existing contact name: ");
//        String name = scanner.nextLine();
//        AccountServices existingContactRecord = mobilePhone.queryContact(name);
//        if (existingContactRecord == null) {
//            System.out.println("Contact not found.");
//            return;
//        }
//
//        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getPhoneNumber());
//    }

    public void printCustomers() {
        System.out.println("Customer List");
        for (int i = 0; i < this.bankCustomers.size(); i++) {
            System.out.println((i + 1) + "." +
                    this.bankCustomers.get(i).getCustomerName() + " -> " +
                    this.bankCustomers.get(i).getTypeOfAccount());
        }

    }


    public void depositFunds(double deposit) {
        this.balance += deposit;
        System.out.println(this.balance);

    }

    //Withdraw from amount

    public void withdrawFunds(double withdraw) {
        this.balance -= withdraw;
        if (this.balance < 0) {
            System.out.println("Insufficient Funds");

        } else {
            System.out.println(this.balance);
        }

    }


    public void linkAccountNumber() {
        Map<Double, ArrayList<Account>> customer = new HashMap<>();
        customer.put(Math.random(), bankCustomers);


            }


}
