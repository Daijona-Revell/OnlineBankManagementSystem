package com.codeintelx.bank.models;

public class Account
{

    private String accountNumber;
    private long balance;
    private String customerName;
    private String typeOfAccount;

    public Account(String accountNumber, String customerName, String typeOfAccount, long balance)
    {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.typeOfAccount = typeOfAccount;
        this.balance = balance;
    }

    public String getAccountNumber()
    {
        return accountNumber;
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

    public String getTypeOfAccount()
    {
        return typeOfAccount;
    }

}