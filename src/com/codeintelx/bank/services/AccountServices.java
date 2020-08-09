package com.codeintelx.bank.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountServices
{

    private double balance;

    public AccountServices(double balance)
    {
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
