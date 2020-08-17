package com.codeintelx.bank.models;

public class Account
{

    private int accountNumber;
    private long balance;
    private String customerName;
    private String typeOfAccount;

    public Account()
    {
    }

    public Account(String customerName, String typeOfAccount, long balance)
    {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.typeOfAccount = typeOfAccount;
        this.balance = balance;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }


    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public long getBalance()
    {
        return balance;
    }

    public void setBalance(long balance)
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