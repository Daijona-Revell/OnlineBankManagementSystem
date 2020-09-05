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

//Adds customer to Map and returns the account information.
    public Account createAccount(String name, String type, long balance)
    {
        UUID uuid = UUID.randomUUID();
        String accountNumber = (Long.toString(uuid.randomUUID().getMostSignificantBits())
                .substring(1, 11).replace("-", ""));
        Account newUserAccount = new Account(accountNumber, name, type, balance);

        userAccounts.put(accountNumber, newUserAccount);


        return newUserAccount;
    }


//Search Map for key and returns the accountNumber (key)

    private Account searchAccount(String accountNumber) throws AccountNotFoundException
    {

        if (!userAccounts.containsKey(accountNumber))
        {
            throw new AccountNotFoundException("Account not found, please enter another account number");
        }

        return userAccounts.get(accountNumber);

    }

//View Account input from the user

    public Account viewUserAccount(String accountNumberFromUser) throws AccountNotFoundException
    {
        return searchAccount(accountNumberFromUser);
    }


//Removes element from Map based on the key (account number) provided by the user
    public void removeUserAccount(String accountNumberFromUser) throws AccountNotFoundException
    {
        userAccounts.remove(accountNumberFromUser);
    }

//Deposits Funds

    public Account depositFunds(String accountNumberFromUser, long deposit)
            throws AccountNotFoundException, InsufficientFundsException
    {
        Account newUserAccount;
        newUserAccount = searchAccount(accountNumberFromUser);

        if (deposit < 0)
        {
            throw new InsufficientFundsException("You cannot enter a negative value");
        }

//Adds deposit amount and updates balance
        if (newUserAccount != null)
        {
            deposit += newUserAccount.getBalance();
            newUserAccount.setBalance(deposit);
        }

        return newUserAccount;
    }


// Withdraw funds

    public Account withdrawFunds(String accountNumberFromUser, long withdraw)
            throws InsufficientFundsException, AccountNotFoundException
    {
//Finds person via account number

        Account newUserAccount;
        newUserAccount = searchAccount(accountNumberFromUser);

        if (withdraw < 0)
        {
            throw new InsufficientFundsException("You cannot enter a negative number, please try again.");
        }
        else if (newUserAccount != null)
        {
//Sets new Balance in newBalance
            long newBalance = (newUserAccount.getBalance() - withdraw);
//Sets new balance in the Map
            if (newBalance >= 0)
            {
                newUserAccount.setBalance(newBalance);
            }
            else if ((newBalance < 0))
            {
                throw new InsufficientFundsException("Insufficient Funds, You have " +
                        newUserAccount.getBalance() + " in your account.");
            }

        }

        return newUserAccount;
    }

//View all keys and information associated in the Map.

    public Map<String, Account> viewAllAccountsInMap()
    {
        return userAccounts;
    }


}












