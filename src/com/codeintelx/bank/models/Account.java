package com.codeintelx.bank.models;

import java.util.*;

public class Account
{

    private double accountNumber;
    private double balance;
    private String customerName;
    private String typeOfAccount;

    public Account()
    {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.typeOfAccount = typeOfAccount;
        this.balance = balance;
    }

    public Account(String customerName, String typeOfAccount, double accountNumber, double balance)
    {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.typeOfAccount = typeOfAccount;
        this.balance = balance;
    }

    public double getAccountNumber()
    {
        return accountNumber;
    }


    public void setAccountNumber(Double accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getTypeOfAccount()
    {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount)
    {
        this.typeOfAccount = typeOfAccount;
    }

}