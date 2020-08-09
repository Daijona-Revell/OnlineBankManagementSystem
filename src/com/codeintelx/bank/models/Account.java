package com.codeintelx.bank.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Account {
    ArrayList<String> customer = new ArrayList<String>();
    ArrayList<String> account = new ArrayList<String>();
    private String accountNumber;
    private double balance;
    private String customerName;
    private String typeOfAccount;

    public Account(String customerName) {
        this.customerName = customerName;
    }

    public Account(String accountNumber, double balance, String customerName, String typeOfAccount) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.typeOfAccount = typeOfAccount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    //Name

    public void customerAccountCreation(String customerName) {
        if (customerName == null) {
//            Map<String, String> customer = new HashMap<>();
//            customer.put("", "");

//            for(Map.Entry<String,String> entry : customer.entrySet()){
//                System.out.println("Current citizen in set: "
//                        + entry.getKey() + ": " +entry.getValue());
//                if(entry.getValue().equals(customer)){
//                    System.out.println(entry.getKey());
        }

    }

    //Type of Account


    //Account customer name and account ID

}
