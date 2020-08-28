package com.codeintelx.bank.services;

import com.codeintelx.bank.exceptions.AccountNotFoundException;
import com.codeintelx.bank.exceptions.InsufficientFundsException;
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
        UUID uuid = UUID.randomUUID();
        String accountNumber = (Long.toString(uuid.randomUUID().getMostSignificantBits()).substring(1, 11).replace("-", ""));
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

    private Account searchAccount(String accountNumber) throws AccountNotFoundException
    {
        //System.out.println("Search Account method");

//        for (Map.Entry<String,Account> entry : userAccounts.entrySet())
//        {
//
            if (!userAccounts.containsKey(accountNumber))
            {
                throw new AccountNotFoundException("Account not found, please enter another account number");
                //return userAccounts.get(accountNumber);
            }

//        }
        return userAccounts.get(accountNumber);
        //return null;
    }


    //View Account input from the user

    public Account viewAccount(String accountNumberFromUser) throws AccountNotFoundException
    {

        //System.out.println("we in the view account class");

        return searchAccount(accountNumberFromUser);
    }

            //Removes element from Map
    public void removeAccount(String accountNumberFromUser) throws AccountNotFoundException
    {
    Account newAccount = searchAccount(accountNumberFromUser);
        userAccounts.remove(newAccount);

//    if(newAccount!= null)
//    {
//        userAccounts.clear();
//        //userAccounts.remove(accountNumberFromUser);
//        //System.out.println("Account will be removed: " + userAccounts.remove(accountNumberFromUser).getCustomerName());
//
//    }
    //return newAccount;

    }

    public Account depositFunds(String accountNumberFromUser, long deposit) throws AccountNotFoundException, InsufficientFundsException
    {
        Account newAccount;
        newAccount = searchAccount(accountNumberFromUser);


        if(deposit<0)
        {
            throw new InsufficientFundsException("You cannot enter a negative value");
        }


            if (newAccount != null)
            {
                //int accountIndex = i;
                //System.out.println("Name: " + newAccount.getCustomerName());
                //Adds deposit to balance
                deposit += newAccount.getBalance();
                //Sets new balance (deposit) in the index
                newAccount.setBalance(deposit);
                //Displays new deposit amount
                //System.out.println( "Balance " + deposit);

            }

        return newAccount;
    }

//
//        //Withdraw from amount
//
    public Account withdrawFunds ( String accountNumberFromUser, long withdraw) throws InsufficientFundsException, AccountNotFoundException
        {
            //Finds person via account number

                Account newAccount;
                newAccount = searchAccount(accountNumberFromUser);

            if (newAccount != null)
            {
                //System.out.println("Name: " + newAccount.getCustomerName());
                // Sets new Balance in newBalance
                long newBalance = (newAccount.getBalance() - withdraw);
                //Sets new balance in the array list
                if (newBalance >= 0)
                {
                    //System.out.println("Balance: " + newBalance);
                    newAccount.setBalance(newBalance);
                }
                else if (newBalance<0)
                {
                    throw new InsufficientFundsException("Insufficient Funds, You have " + newAccount.getBalance() + " in your account.");

                }

            }


            return newAccount;
        }
}












