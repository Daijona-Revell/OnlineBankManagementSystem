package com.codeintelx.bank.services;

import com.codeintelx.bank.models.Account;

import java.util.ArrayList;

public class AccountServices {

    ArrayList<Account> account = new ArrayList<>();

    private static double balance;
    private Double accountNumber;
    private String name;


//    public AccountServices(double accountNumber) {
//        this.accountNumber = accountNumber;
//    }

    public AccountServices() {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    //Adds customer to account array list.
    public Account createAccount(String name, String type, double accountNumber, double balance) {
        account.add(new Account(name, type, accountNumber, balance));

            //Displays Customer name, Account Number, and Balance
        for (int i = 0; i < account.size(); i++) {
            System.out.println("Name: " + account.get(i).getCustomerName());

            System.out.println("Account Number: " + account.get(i).getAccountNumber());

            System.out.println("Balance: " + account.get(i).getBalance());

        }
        return null;
    }


    //View Account input from the user

    public Account viewAccount(double accountNumberFromUser) {
        int accountIndex;

        for (int i = 0; i < account.size(); i++) {

            if (accountNumberFromUser == (account.get(i).getAccountNumber())) {
                accountIndex = i;
                System.out.println("Customer Name: " + account.get(accountIndex).getCustomerName());
                System.out.println("Type of Account: " + account.get(accountIndex).getTypeOfAccount());
                System.out.println("Account Number: " + account.get(accountIndex).getAccountNumber());
                System.out.println("Balance: " + account.get(accountIndex).getBalance());
                // System.out.println(account);
                //return (true);

                //System.out.println("we in the view account class");
               // break;
            }

        }

       return null;
    }

        public double depositFunds(double accountNumber, double deposit)
        {
        //viewAccount(accountNumber);

            for (int i = 0; i < account.size(); i++) {
//
                if (accountNumber == (account.get(i).getAccountNumber()))
                {
                    int accountIndex = i;
                    System.out.println("Name: " + account.get(accountIndex).getCustomerName());
                    //Adds deposit to balance
                    deposit += account.get(accountIndex).getBalance() ;
                    //Sets new balance (deposit) in the index
                    account.get(accountIndex).setBalance(deposit);
                    //Sets new deposit amount

                    System.out.println( "Balance " + deposit);

                   // System.out.println("we in the deposit account class");
                    //break;

                 }

            }

            return 0;
        }

        //Withdraw from amount

        public double withdrawFunds ( double accountNum, double withdraw)
        {
            //Finds person via account number

            for (int i = 0; i < account.size(); i++) {
//
                if (accountNum == (account.get(i).getAccountNumber()))
                {
                    int accountIndex = i;
                    System.out.println("Name: " + account.get(accountIndex).getCustomerName());
                    // Sets new Balance in newBalance
                   double newBalance = (account.get(accountIndex).getBalance() - withdraw);
                   //Sets new balance in the array list
                    account.get(accountIndex).setBalance(newBalance);
                   if(newBalance>0)
                   {
                       System.out.println("Balance " + newBalance);
                   }
                   else
                   {
                       System.out.println("Insufficient Funds");
                   }

                    //System.out.println("we in the withdraw account class");
                    //break;


                }
            }
            return 0;
        }
}








