package com.codeintelx.bank.services;

import com.codeintelx.bank.models.Account;

import java.util.*;

public class AccountServices
{

    private Map<String, Account> userAccounts = new HashMap<>();




    public AccountServices()
    {

    }

    //Adds customer to account array list.
    public Account createAccount(String name, String type, long balance)
    {
        //UUID uuid = UUID.randomUUID();
        String accountNumber = (Long.toString(UUID.randomUUID().getMostSignificantBits()).substring(1, 11).replace("-", ""));
        //System.out.println("Create Account Class");
        Account newAccount = new Account(accountNumber, name, type, balance);
        //UUID uuid = UUID.randomUUID();
//       // String numericUUID = Long.toString(uuid.getMostSignificantBits()) + Long.toString(uuid.getLeastSignificantBits());
        //accountNumber = (Long.toString(UUID.randomUUID().getMostSignificantBits()).substring(1,11).replace("-", ""));




        //String accountNumber = returnAccountNumber();
        userAccounts.put(accountNumber, newAccount);

        //Account test = userAccounts.keySet();

        //String accountNumber = returnAccountNumber();





//        Displays Customer name, Account Number, and Balance
//        System.out.println("Customer: " + userAccounts.get(accountNumber).getCustomerName());
       // System.out.println("Your new account number is: " + accountNumber);

        return newAccount;
    }



//    public String returnAccountNumber()
//    {
//        UUID uuid = UUID.randomUUID();
//        // String numericUUID = Long.toString(uuid.getMostSignificantBits()) + Long.toString(uuid.getLeastSignificantBits());
//        String accountNumber = (Long.toString(UUID.randomUUID().getMostSignificantBits()).substring(1,11).replace("-", ""));
//        return accountNumber;
//        //return userAccounts.get(getAccountNumber());
//    }

    //Search Map for key and returns the accountNumber

    public Account searchAccount(String accountNumber)
    {
        //System.out.println("Search Account method");

//        for (Map.Entry<String,Account> entry : userAccounts.entrySet())
//        {
//
//            if (userAccounts.containsKey(accountNumber))
//            {
//                return userAccounts.get(accountNumber);
//            }
//        }
        return userAccounts.get(accountNumber);
        //return null;
    }


    //View Account input from the user

    public Account viewAccount(String accountNumberFromUser)
    {

        //System.out.println("we in the view account class");

        return searchAccount(accountNumberFromUser);
    }

            //Removes element from Map
    public Account removeAccount(String accountNumberFromUser)
    {
    Account newAccount = searchAccount(accountNumberFromUser);
        userAccounts.remove(accountNumberFromUser);

//    if(newAccount!= null)
//    {
//        userAccounts.clear();
//        //userAccounts.remove(accountNumberFromUser);
//        //System.out.println("Account will be removed: " + userAccounts.remove(accountNumberFromUser).getCustomerName());
//
//    }
    return newAccount;

    }

    public Account depositFunds(String accountNumberFromUser, long deposit)
        {
            Account newAccount;
            newAccount = searchAccount(accountNumberFromUser);
//
                if (newAccount!= null)
                {
                    //int accountIndex = i;
                    //System.out.println("Name: " + newAccount.getCustomerName());
                    //Adds deposit to balance
                    deposit += newAccount.getBalance() ;
                    //Sets new balance (deposit) in the index
                    userAccounts.get(accountNumberFromUser).setBalance(deposit);
                    //Displays new deposit amount
                    //System.out.println( "Balance " + deposit);


                 }
                return newAccount;
        }

//
//        //Withdraw from amount
//
    public Account withdrawFunds ( String accountNumberFromUser, long withdraw)
        {
            //Finds person via account number

            Account newAccount;
            newAccount = searchAccount(accountNumberFromUser);

                if (newAccount!= null)
                {
                    //System.out.println("Name: " + newAccount.getCustomerName());
                    // Sets new Balance in newBalance
                   long newBalance = (newAccount.getBalance() - withdraw);
                   //Sets new balance in the array list
                   if(newBalance>=0)
                   {
                       //System.out.println("Balance: " + newBalance);
                      userAccounts.get(accountNumberFromUser).setBalance(newBalance);
                   }
//                   else
//                   {
//                       return null;
//                       //System.out.println("Insufficient Funds");
//                   }

                }

            return newAccount;
        }
}












