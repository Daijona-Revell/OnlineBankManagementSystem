package com.codeintelx.bank.services;

public class AccountServices
{

    private double balance;

    public AccountServices(double balance)
    {
        this.balance = balance;
    }

    //Deposit amount


    public void depositFunds(double deposit)
    {
        this.balance+=deposit;
        System.out.println(this.balance);

    }

    //Withdraw from amount

    public void withdrawFunds(double withdraw)
    {
        this.balance -= withdraw;
        if (this.balance < 0) {
            System.out.println("Insufficient Funds");

        } else {
            System.out.println(this.balance);
        }

    }

}
