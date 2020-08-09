package com.codeintelx.bank.models;

public class Account
{
    private String accountNumber;
    private double balance;
    private String customerName;
    private String typeOfAccount;

    public Account(String accountNumber, double balance, String customerName, String typeOfAccount)
    {
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



    //Type of Account



    //Account customer name and account ID

}
